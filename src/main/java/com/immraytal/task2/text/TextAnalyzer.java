package com.immraytal.task2.text;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TextAnalyzer implements TextParser {
    private static final Logger LOG = Logger.getLogger(TextAnalyzer.class);
    public List<Paragraph> paragraphs = new ArrayList<>();

    public TextAnalyzer(Path path) {
        String content;

        try {
            content = Files.lines(path).reduce("", (a, b) -> {
                return a + "\n" + b;
            });
            this.init(content);
        } catch (IOException var4) {
            LOG.error("File not found or haven't permissions\n" + var4.toString());
        }

    }

    public TextAnalyzer(String content) {
        this.init(content);
    }

    private void init(String content) {
        Pattern pattern = Pattern.compile("\\n{2,}|\\t+");
        String[] strings = pattern.split(content);

        for (int i = 0; i < strings.length; ++i) {
            this.paragraphs.add(new Paragraph(strings[i]));
        }

    }

    public String getUniqueWord() {
        String word = (paragraphs.get(0).sentences.get(0).words.get(1)).toString();
        boolean same = true;
        for (int w = 1; w < paragraphs.get(0).sentences.get(0).words.size(); ++w) {
            if (!same) {
                LOG.info("Found a unique word from the first sentence - " + word);
                return word;
            }
            same = false;
            word = (paragraphs.get(0).sentences.get(0).words.get(w)).toString();

            for (int i = 0; i < paragraphs.size(); ++i) {
                for (int j = 1; j < paragraphs.get(i).sentences.size(); ++j) {
                    for (int k = 0; k < paragraphs.get(i).sentences.get(j).words.size(); ++k) {
                        if (paragraphs.get(i).sentences.get(j).words.get(k).toString().equals(word)) {
                            same = true;
                        }


                    }
                }
            }
        }

        LOG.info("Not found a unique word from the first sentence");
        return null;
    }

    public String getFullElement() {
        String res = "";

        for (int i = 0; i < paragraphs.size(); ++i) {
            res = res + paragraphs.get(i).getFullElement();
        }

        return res;
    }
}

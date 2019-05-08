package com.immraytal.task2.text;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Paragraph implements TextParser {
    private static final Logger LOG = Logger.getLogger(Paragraph.class);
    List<Sentence> sentences = new ArrayList<>();

    public Paragraph(String str) {
        Pattern pattern = Pattern.compile("([.?!;])\\s*");
        String[] strings = pattern.split(str);

        int i;
        for (i = 0; i < strings.length; ++i) {
            try {
                strings[i] = strings[i] + str.charAt(str.lastIndexOf(strings[i]) + strings[i].length());
            } catch (Exception e) {
                LOG.info("Overrun - cancel operation " + e.toString());
            }
        }

        for (i = 0; i < strings.length; ++i) {
            this.sentences.add(new Sentence(strings[i]));
        }

    }

    public String getFullElement() {
        String res = "";

        for (int i = 0; i < this.sentences.size(); ++i) {
            res = res + sentences.get(i).getFullElement() + '\n';
        }

        return res;
    }
}

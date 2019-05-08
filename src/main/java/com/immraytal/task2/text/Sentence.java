package com.immraytal.task2.text;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Sentence implements TextParser {
    List<Word> words = new ArrayList();
    List<Symbol> symbols = new ArrayList();

    public Sentence(String str) {
        String[] strings = str.split("\\s+");

        for (int i = 0; i < strings.length; ++i) {
            if (Pattern.matches(".+[.,!:;*^%]\\n?", strings[i])) {
                System.out.println(strings[i].substring(strings[i].length()));
                words.add(new Word(strings[i].substring(0, strings[i].length() - 1)));
                symbols.add(new Symbol(strings[i].charAt(strings[i].length() - 1) + ""));
            } else {
                symbols.add(new Symbol());
                words.add(new Word(strings[i]));
            }
        }

    }

    public String getFullElement() {
        String res = "";

        for (int i = 0; i < this.words.size(); ++i) {
            res = res + words.get(i).toString() + symbols.get(i).toString() + " ";
        }

        return res;
    }
}

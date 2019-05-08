package com.immraytal.task2.text;


public class Word implements TextParser {
    String string;

    public Word(String str) {
        this.string = str;
    }

    public String toString() {
        return this.string;
    }

    public String getFullElement() {
        return this.string;
    }
}

package com.immraytal.task2.init;

import com.immraytal.task2.text.TextAnalyzer;
import com.immraytal.task2.text.TextParser;

import java.nio.file.Path;
import java.nio.file.Paths;

public class main {
    public static void main(String[] args) {
        Path paths = Paths.get("\\Users\\Surv\\Desktop\\task2\\src\\main\\resources\\text.txt");
        TextParser txtAnal = new TextAnalyzer(paths);
        System.out.println("=========================================================================================");
        System.out.println(txtAnal.getFullElement());
        System.out.println(((TextAnalyzer) txtAnal).getUniqueWord());
    }
}

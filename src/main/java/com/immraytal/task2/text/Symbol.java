package com.immraytal.task2.text;

public class Symbol implements TextParser {
    String symbol;

    public Symbol(String symbol) {
        this.symbol = symbol;
    }

    public Symbol() {
        this.symbol = "";
    }

    public String toString() {
        return this.symbol;
    }

    public String getFullElement() {
        return this.symbol;
    }
}

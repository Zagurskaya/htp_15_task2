package com.zagurskaya.task2.reformer;

public class DataReformer {
    public String refactor(String text) {
        String refactorText = "";
        refactorText = text.replaceAll("\n", " ");
        return refactorText;
    }

}

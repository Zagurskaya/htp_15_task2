package com.zagurskaya.task2.validation;

public class DataValidation {
    private static final String PUNCTUATION_PATTERN = "[.!?]|[.]+";

    public static boolean isSymbolTypePunctuationForEndSentence(String value) {

        if (value.matches(PUNCTUATION_PATTERN)) {
            return true;
        } else {
            return false;
        }
    }
}

package com.zagurskaya.task2.validation;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DataValidationTest extends Assert {
    private String value;

    @Test
    public void isSymbolTypePunctuationForEndSentenceTrue() {
        value = ".";
        boolean actual = DataValidation.isSymbolTypePunctuationForEndSentence(value);
        assertTrue(actual);
    }

    @Test
    public void isSymbolTypePunctuationForEndSentenceTrueFalse() {
        value = "-";
        boolean actual = DataValidation.isSymbolTypePunctuationForEndSentence(value);
        assertFalse(actual);
    }
}

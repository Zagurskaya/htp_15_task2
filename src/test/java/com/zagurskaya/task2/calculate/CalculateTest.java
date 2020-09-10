package com.zagurskaya.task2.calculate;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculateTest extends Assert {
    private String text;

    @Test
    public void arithmeticExpressionTest() {
        text = "6*i+9*(3+j-4)";
        String expected = "15.0";
        String actual = Calculate.arithmeticExpression(text,1L,2L);
        assertEquals(actual, expected);
    }
}

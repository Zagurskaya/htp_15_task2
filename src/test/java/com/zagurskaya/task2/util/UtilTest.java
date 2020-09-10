package com.zagurskaya.task2.util;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UtilTest extends Assert {
    private String text;

    @Test
    public void refactorTextWithArithmeticExpressionTest() {
        text = "hello 6*i+9*(3+j-4) world";
        String expected = "hello 15 world";
        String actual = DataUtil.refactorTextWithArithmeticExpression(text,1L,2L);
        assertEquals(actual, expected);
    }
}

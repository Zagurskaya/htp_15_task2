package com.zagurskaya.task2.composite;

import com.zagurskaya.task2.composite.impl.TextComposite;
import com.zagurskaya.task2.composite.impl.TextComponentType;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TextCompositeTest extends Assert {
    TextComposite textComposite;
    TextComposite textComponentSymbol1;

    @BeforeTest
    public void setUp() {
        TextComposite textComponentSymbol1 = new TextComposite(TextComponentType.SYMBOL);

}

    @Test
    public void addTest() {
        textComposite = new TextComposite(TextComponentType.SYMBOL);
        textComposite.add(textComponentSymbol1);
        assertNotNull(textComposite);
    }

}

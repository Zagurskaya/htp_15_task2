package com.zagurskaya.task2.parser;

import com.zagurskaya.task2.composite.TextComponent;
import com.zagurskaya.task2.composite.impl.Symbol;
import com.zagurskaya.task2.composite.impl.SymbolType;
import com.zagurskaya.task2.composite.impl.TextComponentType;
import com.zagurskaya.task2.composite.impl.TextComposite;
import com.zagurskaya.task2.parser.impl.SymbolParser;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SymbolParserTest extends Assert {
    private SymbolParser symbolParser;
    String text;

    @BeforeTest
    public void setUp() {
        symbolParser = SymbolParser.getInstance();
    }

    @Test
    public void parseTest() {
        Symbol letter1 = new Symbol('h', SymbolType.LETTER);
        Symbol punctuation1 = new Symbol('.', SymbolType.PUNCTUATION);
        Symbol number1 = new Symbol('3', SymbolType.PUNCTUATION);

        TextComposite textComponentLexeme1 = new TextComposite(TextComponentType.LEXEME);
        textComponentLexeme1.add(number1);
        textComponentLexeme1.add(letter1);
        textComponentLexeme1.add(punctuation1);

        text = "3h.";
        TextComponent expected = textComponentLexeme1;
        TextComponent actual = symbolParser.parse(text);
        assertEquals(actual.toString(), expected.toString());
    }
}

package com.zagurskaya.task2.parser;

import com.zagurskaya.task2.composite.TextComponent;
import com.zagurskaya.task2.composite.impl.Symbol;
import com.zagurskaya.task2.composite.impl.SymbolType;
import com.zagurskaya.task2.composite.impl.TextComponentType;
import com.zagurskaya.task2.composite.impl.TextComposite;
import com.zagurskaya.task2.parser.impl.SentenceParser;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SentenceParserTest extends Assert {
    private SentenceParser sentenceParser;
    private String text;

    @BeforeTest
    public void setUp() {
        sentenceParser = SentenceParser.getInstance();
    }

    @Test
    public void parseTest() {
        Symbol letter1 = new Symbol('h', SymbolType.LETTER);
        Symbol letter2 = new Symbol('e', SymbolType.LETTER);
        Symbol letter3 = new Symbol('l', SymbolType.LETTER);
        Symbol letter4 = new Symbol('l', SymbolType.LETTER);
        Symbol letter5 = new Symbol('o', SymbolType.LETTER);

        Symbol letter6 = new Symbol('w', SymbolType.LETTER);
        Symbol letter7 = new Symbol('o', SymbolType.LETTER);
        Symbol letter8 = new Symbol('r', SymbolType.LETTER);
        Symbol letter9 = new Symbol('d', SymbolType.LETTER);

        Symbol punctuation1 = new Symbol('.', SymbolType.PUNCTUATION);

        TextComposite textComponentLexeme1 = new TextComposite(TextComponentType.LEXEME);
        textComponentLexeme1.add(letter1);
        textComponentLexeme1.add(letter2);
        textComponentLexeme1.add(letter3);
        textComponentLexeme1.add(letter4);
        textComponentLexeme1.add(letter5);

        TextComposite textComponentLexeme2 = new TextComposite(TextComponentType.LEXEME);
        textComponentLexeme2.add(letter6);
        textComponentLexeme2.add(letter7);
        textComponentLexeme2.add(letter8);
        textComponentLexeme2.add(letter9);
        textComponentLexeme2.add(punctuation1);

        TextComposite textComponentSentence = new TextComposite(TextComponentType.SENTENCE);
        textComponentSentence.add(textComponentLexeme1);
        textComponentSentence.add(textComponentLexeme2);

        text = "hello word.";
        TextComponent expected = textComponentSentence;
        TextComponent actual = sentenceParser.parse(text);
        assertEquals(actual.toString(), expected.toString());
    }
}

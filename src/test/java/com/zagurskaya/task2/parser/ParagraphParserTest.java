package com.zagurskaya.task2.parser;

import com.zagurskaya.task2.composite.TextComponent;
import com.zagurskaya.task2.composite.impl.Symbol;
import com.zagurskaya.task2.composite.impl.SymbolType;
import com.zagurskaya.task2.composite.impl.TextComponentType;
import com.zagurskaya.task2.composite.impl.TextComposite;
import com.zagurskaya.task2.parser.impl.ParagraphParser;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ParagraphParserTest extends Assert {
    private ParagraphParser paragraphParser;
    private String text;

    @BeforeTest
    public void setUp() {
        paragraphParser = ParagraphParser.getInstance();
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

        Symbol letter10 = new Symbol('M', SymbolType.LETTER);
        Symbol letter11 = new Symbol('e', SymbolType.LETTER);
        Symbol punctuation2 = new Symbol('.', SymbolType.PUNCTUATION);

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

        TextComposite textComponentLexeme3 = new TextComposite(TextComponentType.LEXEME);
        textComponentLexeme3.add(letter10);
        textComponentLexeme3.add(letter11);
        textComponentLexeme3.add(punctuation2);

        TextComposite textComponentSentence = new TextComposite(TextComponentType.SENTENCE);
        textComponentSentence.add(textComponentLexeme1);
        textComponentSentence.add(textComponentLexeme2);

        TextComposite textComponentSentence2 = new TextComposite(TextComponentType.SENTENCE);
        textComponentSentence2.add(textComponentLexeme3);

        TextComposite textComponentParagraph1 = new TextComposite(TextComponentType.PARAGRAPH);
        textComponentParagraph1.add(textComponentSentence);
        TextComposite textComponentParagraph2 = new TextComposite(TextComponentType.PARAGRAPH);
        textComponentParagraph2.add(textComponentSentence2);

        TextComposite textComponentText = new TextComposite(TextComponentType.TEXT);
        textComponentText.add(textComponentParagraph1);
        textComponentText.add(textComponentParagraph2);

        text = "hello word.\n\tMe.";
        TextComponent expected = textComponentText;
        TextComponent actual = paragraphParser.parse(text);
        assertEquals(actual.toString(), expected.toString());
    }
}

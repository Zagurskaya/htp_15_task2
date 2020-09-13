package com.zagurskaya.task2.sorter;

import com.zagurskaya.task2.comparator.TextComparator;
import com.zagurskaya.task2.composite.TextComponent;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TextComponentSorterTest extends Assert {
    private TextComponentSorter sorter;
    String text;

    @BeforeTest
    public void setUp() {
        sorter = new TextComponentSorter();
    }

    @Test
    public void sortTextParagraphsByCountSentenceTest() {

        String text = "It has survived - not only popularised in. Of sheets! Assss ddddddd ggggggg.\n\t" +
                "It is at its layout. The, point.";
        String expected = "[ It is at its layout. The, point.,  It has survived - not only popularised in. Of sheets! Assss ddddddd ggggggg.]";
        List<TextComponent> actual = sorter.sortTextParagraphsByCountSentence(text);
        assertEquals(actual.toString(), expected);
    }

    @Test
    public void sortTextSentenceTestByLengthWords() {
        String text = "Of,,,, sheets!\n\t" +
                "The, pointm.";
        String expected = "[ The, pointm,  Of,,,, sheets]";
        List<TextComponent> actual = sorter.sortTextSentences(text, TextComparator.ALL_LENGTH_WORDS);
        assertEquals(actual.toString(), expected);
    }

    @Test
    public void sortTextSentenceTestByLengthLexeme() {
        String text = "Of,,,, sheets!\n\t" +
                "The, pointm.";
        String expected = "[ Of,,,, sheets,  The, pointm]";
        List<TextComponent> actual = sorter.sortTextSentences(text, TextComparator.ALL_LENGTH_LEXEME);
        assertEquals(actual.toString(), expected);
    }
}

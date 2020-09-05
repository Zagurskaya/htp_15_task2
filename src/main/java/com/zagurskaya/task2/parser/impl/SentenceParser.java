package com.zagurskaya.task2.parser.impl;

import com.zagurskaya.task2.composite.TextComponent;
import com.zagurskaya.task2.composite.impl.componentEnum.TextComponentType;
import com.zagurskaya.task2.composite.impl.TextComposite;
import com.zagurskaya.task2.parser.Parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SentenceParser implements Parser {
    private final static SentenceParser sentenceParser = new SentenceParser();
    private static final String SENTENCE_DELIMITER = "[.!?]+";
    private LexemeParser lexemeParser = LexemeParser.getInstance();

    private SentenceParser() {
    }

    public static SentenceParser getInstance() {
        return sentenceParser;
    }

    @Override
    public TextComponent parse(String text) {
        TextComponent componentParagraph = new TextComposite(TextComponentType.PARAGRAPH);
        List<String> context = Arrays.stream(text.split(SENTENCE_DELIMITER)).collect(Collectors.toList());
        for (String element : context) {
            TextComponent componentLexeme = lexemeParser.parse(element);
            componentParagraph.add(componentLexeme);
        }
        return componentParagraph;
    }
}

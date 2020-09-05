package com.zagurskaya.composite.parser.impl;

import com.zagurskaya.composite.composite.TextComponent;
import com.zagurskaya.composite.composite.impl.componentEnum.TextComponentType;
import com.zagurskaya.composite.composite.impl.TextComposite;
import com.zagurskaya.composite.parser.Parser;

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

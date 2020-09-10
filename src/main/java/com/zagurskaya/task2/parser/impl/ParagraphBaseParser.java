package com.zagurskaya.task2.parser.impl;

import com.zagurskaya.task2.composite.TextComponent;
import com.zagurskaya.task2.composite.impl.TextComponentType;
import com.zagurskaya.task2.composite.impl.TextComposite;
import com.zagurskaya.task2.parser.BaseParser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParagraphBaseParser implements BaseParser {
    private final static ParagraphBaseParser paragraphParser = new ParagraphBaseParser();
    private SentenceBaseParser sentenceParser = SentenceBaseParser.getInstance();
    private static final String PARAGRAPH_DELIMITER = "\n\t";

    private ParagraphBaseParser() {
    }

    public static ParagraphBaseParser getInstance() {
        return paragraphParser;
    }

    @Override
    public TextComponent parse(String text) {
        TextComponent componentText;
        componentText= new TextComposite(TextComponentType.TEXT);
        List<String> context = Arrays.stream(text.split(PARAGRAPH_DELIMITER)).collect(Collectors.toList());
        context.forEach(s -> {
            TextComponent componentSentence = sentenceParser.parse(s);
            componentText.add(componentSentence);
        });
        return componentText;
    }
}

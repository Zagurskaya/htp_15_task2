package com.zagurskaya.task2.parser.impl;

import com.zagurskaya.task2.composite.TextComponent;
import com.zagurskaya.task2.composite.impl.TextComponentType;
import com.zagurskaya.task2.composite.impl.TextComposite;
import com.zagurskaya.task2.parser.Parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParagraphParser implements Parser {
    private final static ParagraphParser paragraphParser = new ParagraphParser();
    private SentenceParser sentenceParser = SentenceParser.getInstance();
    private static final String PARAGRAPH_DELIMITER = "\n\t";

    private ParagraphParser() {
    }

    public static ParagraphParser getInstance() {
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

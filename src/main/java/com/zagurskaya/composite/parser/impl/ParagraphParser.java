package com.zagurskaya.composite.parser.impl;

import com.zagurskaya.composite.composite.TextComponent;
import com.zagurskaya.composite.composite.impl.componentEnum.TextComponentType;
import com.zagurskaya.composite.composite.impl.TextComposite;
import com.zagurskaya.composite.parser.Parser;

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

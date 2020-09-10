package com.zagurskaya.task2.parser.impl;

import com.zagurskaya.task2.composite.TextComponent;
import com.zagurskaya.task2.composite.impl.TextComponentType;
import com.zagurskaya.task2.composite.impl.TextComposite;
import com.zagurskaya.task2.parser.BaseParser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LexemeParser implements BaseParser {
    private static final LexemeParser lexemeParser = new LexemeParser();
    private static final String LEXEME_DELIMITER = "\\s";
    private SymbolParser symbolParser = SymbolParser.getInstance();


    private LexemeParser() {
    }

    public static LexemeParser getInstance() {
        return lexemeParser;
    }

    @Override
    public TextComponent parse(String text) {
        TextComponent componentText = new TextComposite(TextComponentType.SENTENCE);
        List<String> context = Arrays.stream(text.trim().split(LEXEME_DELIMITER)).collect(Collectors.toList());
        context.forEach(s -> {
            TextComponent componentSymbol = symbolParser.parse(s);
            componentText.add(componentSymbol);
        });
        return componentText;
    }
}

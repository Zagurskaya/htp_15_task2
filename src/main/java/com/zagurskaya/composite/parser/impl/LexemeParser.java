package com.zagurskaya.composite.parser.impl;

import com.zagurskaya.composite.composite.TextComponent;
import com.zagurskaya.composite.composite.impl.componentEnum.TextComponentType;
import com.zagurskaya.composite.composite.impl.TextComposite;
import com.zagurskaya.composite.parser.Parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LexemeParser implements Parser {
    private static final LexemeParser lexemeParser = new LexemeParser();
    private static final String LEXEME_DELIMITER = "\\s";
    private SymbolParser symbolParser = SymbolParser.getInstance();


    private LexemeParser() {
    }

    static LexemeParser getInstance() {
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

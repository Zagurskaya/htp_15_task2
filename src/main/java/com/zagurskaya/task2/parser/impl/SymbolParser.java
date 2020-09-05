package com.zagurskaya.task2.parser.impl;

import com.zagurskaya.task2.composite.TextComponent;
import com.zagurskaya.task2.composite.impl.Symbol;
import com.zagurskaya.task2.composite.impl.componentEnum.SymbolType;
import com.zagurskaya.task2.composite.impl.componentEnum.TextComponentType;
import com.zagurskaya.task2.composite.impl.TextComposite;
import com.zagurskaya.task2.parser.Parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SymbolParser implements Parser {
    private static final SymbolParser symbolParser = new SymbolParser();
    private static final String SYMBOL_DELIMITER = "";

    private static final String ALPHABET_VALIDATE_PATTERN = "[a-zA-Zа-яА-Я]{1}";
    private static final String NUMBER_VALIDATE_PATTERN = "\\d";

    private SymbolParser() {
    }

    public static SymbolParser getInstance() {
        return symbolParser;
    }

    @Override
    public TextComponent parse(String text) {
        TextComponent componentText = new TextComposite(TextComponentType.LEXEME);
        List<String> context = Arrays.stream(text.split(SYMBOL_DELIMITER)).collect(Collectors.toList());
        context.forEach(s -> {
            SymbolType type;
            if (s.matches(ALPHABET_VALIDATE_PATTERN)) {
                type = SymbolType.LETTER;
            } else if (s.matches(NUMBER_VALIDATE_PATTERN)) {
                type = SymbolType.NUMBER;
            } else {
                type = SymbolType.PUNCTUATION;
            }
            Symbol symbol = new Symbol(s.charAt(0), type);
            componentText.add(symbol);
        });
        return componentText;
    }
}

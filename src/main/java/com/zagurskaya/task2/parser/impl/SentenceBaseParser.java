package com.zagurskaya.task2.parser.impl;

import com.zagurskaya.task2.composite.TextComponent;
import com.zagurskaya.task2.composite.impl.Symbol;
import com.zagurskaya.task2.composite.impl.SymbolType;
import com.zagurskaya.task2.composite.impl.TextComponentType;
import com.zagurskaya.task2.composite.impl.TextComposite;
import com.zagurskaya.task2.parser.BaseParser;
import com.zagurskaya.task2.validation.DataValidation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SentenceBaseParser implements BaseParser {
    private final static SentenceBaseParser sentenceParser = new SentenceBaseParser();
    private static final String SENTENCE_DELIMITER = "((?<=[.!?])|(?=[.!?]))";
    private LexemeBaseParser lexemeParser = LexemeBaseParser.getInstance();

    private SentenceBaseParser() {
    }

    public static SentenceBaseParser getInstance() {
        return sentenceParser;
    }

    @Override
    public TextComponent parse(String text) {
        TextComponent componentParagraph = new TextComposite(TextComponentType.PARAGRAPH);
        List<String> context = Arrays.stream(text.split(SENTENCE_DELIMITER)).collect(Collectors.toList());
        for (String element : context) {
            if (!DataValidation.isSymbolTypePunctuationForEndSentence(element)) {
                TextComponent componentLexeme = lexemeParser.parse(element);
                componentParagraph.add(componentLexeme);
            } else {
                Symbol symbol = new Symbol(element.charAt(0), SymbolType.PUNCTUATION);
                componentParagraph.add(symbol);
            }
        }
        return componentParagraph;
    }
}

package com.zagurskaya.task2.sorter;

import com.zagurskaya.task2.comparator.TextComparator;
import com.zagurskaya.task2.composite.TextComponent;
import com.zagurskaya.task2.composite.impl.TextComponentType;
import com.zagurskaya.task2.parser.impl.ParagraphParser;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TextComponentSorter {

    public List<TextComponent> sortTextParagraphsByCountSentence(String text) {
        ParagraphParser paragraphParser = ParagraphParser.getInstance();
        TextComponent components = paragraphParser.parse(text);
        List<TextComponent> paragraphs = new ArrayList<>();
        components.getComponents().stream()
                .filter(textComponent -> textComponent.getComponentType() == TextComponentType.PARAGRAPH)
                .forEach(textComponent -> paragraphs.add(textComponent));
        paragraphs.sort(TextComparator.SIZE);
        return paragraphs;
    }

    public List<TextComponent> sortTextSentences(String text, Comparator comparator) {
        ParagraphParser paragraphParser = ParagraphParser.getInstance();
        TextComponent components = paragraphParser.parse(text);
        List<TextComponent> sentences = new ArrayList<>();
        components.getComponents().stream().forEach(component -> {
            component.getComponents().stream()
                    .filter(lexeme -> lexeme.getComponentType() == TextComponentType.SENTENCE)
                    .forEach(lexema -> sentences.add(lexema));
        });
        sentences.sort(comparator);
        return sentences;
    }
}

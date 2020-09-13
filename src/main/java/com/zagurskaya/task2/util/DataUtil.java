package com.zagurskaya.task2.util;

import com.zagurskaya.task2.calculate.Calculate;
import com.zagurskaya.task2.composite.TextComponent;
import com.zagurskaya.task2.composite.impl.Symbol;
import com.zagurskaya.task2.composite.impl.SymbolType;
import com.zagurskaya.task2.composite.impl.TextComponentType;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataUtil {
    private static final String ARITHMETIC_EXPRESSION_PATTERN = "\\s([ij\\d+\\.\\+\\-\\*\\/\\(\\)\\s^%]*)\\s";

    public static String refactorTextWithArithmeticExpression(String text, Long i, Long j) {
        String refactorText = text;

        Pattern pattern = Pattern.compile(ARITHMETIC_EXPRESSION_PATTERN);
        Matcher matcher = pattern.matcher(text);
        List<String> strings = new ArrayList<>();
        while (matcher.find()) {
            String stringByPattern = matcher.group().trim();
            strings.add(stringByPattern);
        }
        for (String s : strings) {
            if (s.length() > 1) {
                refactorText = refactorText.replace(s, Calculate.arithmeticExpression(s, i, j).replace(".0", ""));
            }
        }
        return refactorText;
    }

    public static Integer lengthAllСhildComponents(List<TextComponent> components) {
        return components.stream().mapToInt(component -> component.getComponents().size()).sum();
    }

    public static Integer lengthComponents(List<TextComponent> components) {
        int result;
        result = lengthAllСhildComponents(components);
        for (TextComponent component : components) {
            List<TextComponent> symbols = component.getComponents();
            for (TextComponent symbol : symbols) {
                if (((Symbol) symbol).getType() == SymbolType.PUNCTUATION) {
                    result--;
                }
            }
        }
        return result;
    }
}

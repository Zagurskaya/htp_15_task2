package com.zagurskaya.task2.reformer;

import com.zagurskaya.task2.calculate.Calculate;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataReformer {
    private static final String ARITHMETIC_EXPRESSION_PATTERN = "\\s([ij\\d+\\.\\+\\-\\*\\/\\(\\)\\s^%]*)\\s";

    public String refactor(String text, Long i, Long j) {
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
                refactorText = refactorText.replace(s, Calculate.result(s, i, j).replace(".0", ""));
            }
        }
        System.out.println(refactorText);
        return refactorText;
    }

}

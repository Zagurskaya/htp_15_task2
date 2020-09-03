package com.zagurskaya.composite.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataParser {
    private static final String TRIANGLE_SEPARATOR = "\n";

    public List<String> parsTextToRowTriangleList(StringBuffer text) {

        List<String> trianglesList = Arrays.stream(text.toString()
                .split(TRIANGLE_SEPARATOR))
                .filter(s -> s.length() != 0)
                .collect(Collectors.toList());
        return trianglesList;
    }
}

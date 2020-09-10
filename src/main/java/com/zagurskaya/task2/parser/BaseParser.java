package com.zagurskaya.task2.parser;

import com.zagurskaya.task2.composite.TextComponent;

public interface BaseParser {
    TextComponent parse(String text);
}

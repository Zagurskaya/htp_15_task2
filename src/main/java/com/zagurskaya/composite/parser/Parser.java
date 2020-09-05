package com.zagurskaya.composite.parser;

import com.zagurskaya.composite.composite.TextComponent;

public interface Parser {
    TextComponent parse(String text);
}

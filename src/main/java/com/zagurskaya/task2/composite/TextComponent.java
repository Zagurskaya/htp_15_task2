package com.zagurskaya.task2.composite;

import com.zagurskaya.task2.composite.impl.TextComponentType;

public interface TextComponent {
    void add(TextComponent component);

    void remove(TextComponent component);

    TextComponent getСhild(int index);

    TextComponentType getComponentType();

    String toString();

}

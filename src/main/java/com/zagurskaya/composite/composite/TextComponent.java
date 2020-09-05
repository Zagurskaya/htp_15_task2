package com.zagurskaya.composite.composite;

import com.zagurskaya.composite.composite.impl.componentEnum.TextComponentType;

public interface TextComponent {
    void add(TextComponent component);

    void remove(TextComponent component);

    TextComponent getСhild(int index);

    TextComponentType getComponentType();

}

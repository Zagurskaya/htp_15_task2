package com.zagurskaya.composite.composite.impl;

import com.zagurskaya.composite.composite.TextComponent;
import com.zagurskaya.composite.composite.impl.componentEnum.SymbolComponentType;
import com.zagurskaya.composite.composite.impl.componentEnum.TextComponentType;
import com.zagurskaya.composite.exception.ProjectException;

public class SymbolComposite implements TextComponent {

    private SymbolComponentType type;
    private char content;

    public SymbolComposite(char content, SymbolComponentType type) {
        this.content = content;
        this.type = type;
    }

    @Override
    public void add(TextComponent component) {
        throw new ProjectException("Method is not supported");
    }

    @Override
    public void remove(TextComponent component) {
        throw new ProjectException("Method is not supported");
    }

    @Override
    public TextComponent getСhild(int index) {
        return null;
    }

    @Override
    public TextComponentType getComponentType() {
        return null;
    }

    @Override
    public String toString() {
        return "" + content;
    }
}

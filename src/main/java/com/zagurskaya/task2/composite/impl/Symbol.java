package com.zagurskaya.task2.composite.impl;

import com.zagurskaya.task2.composite.TextComponent;
import com.zagurskaya.task2.composite.impl.componentEnum.SymbolType;
import com.zagurskaya.task2.composite.impl.componentEnum.TextComponentType;
import com.zagurskaya.task2.exception.ProjectException;

public class Symbol implements TextComponent {

    private SymbolType type;
    private char content;

    public Symbol(char content, SymbolType type) {
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

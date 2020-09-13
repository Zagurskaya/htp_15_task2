package com.zagurskaya.task2.composite.impl;

import com.zagurskaya.task2.composite.TextComponent;
import com.zagurskaya.task2.exception.ProjectException;

import java.util.List;

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
    public List<TextComponent> getComponents() {
        return null;
    }

    public SymbolType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "" + content;
    }
}

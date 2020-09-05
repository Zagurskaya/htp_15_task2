package com.zagurskaya.task2.composite.impl;

import com.zagurskaya.task2.composite.TextComponent;
import com.zagurskaya.task2.composite.impl.componentEnum.TextComponentType;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private TextComponentType type;
    List<TextComponent> components = new ArrayList<>();

    public TextComposite(TextComponentType type) {
        this.type = type;
    }

    @Override
    public void add(TextComponent component) {
        components.add(component);

    }

    @Override
    public void remove(TextComponent component) {
        components.remove(component);
    }

    @Override
    public TextComponent getСhild(int index) {
        return components.get(index);
    }

    @Override
    public TextComponentType getComponentType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextComposite that = (TextComposite) o;

        if (type != that.type) return false;
        return components != null ? components.equals(that.components) : that.components == null;

    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (components != null ? components.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        components.stream().forEach(component -> {
            if (TextComponentType.PARAGRAPH.equals(component.getComponentType())) {
                builder.append("\n\t");
            } else if (TextComponentType.LEXEME.equals(component.getComponentType()) ||
                    TextComponentType.SENTENCE.equals(component.getComponentType())
            ) {
                builder.append(" "); //" "
            }
            builder.append(component.toString());
        });
        return builder.toString();
    }
}

package com.zagurskaya.composite.entity;

public class StringValue implements Lecsema {
    private StringBuilder value;

    public StringValue(StringBuilder value) {
        this.value = value;
    }

    @Override
    public StringBuilder value() {
        return this.value;
    }

    @Override
    public void add(StringBuilder element) {
        this.value.append(element);
    }

    @Override
    public void remove(StringBuilder element) {
        this.value.toString().replace(element, "");
    }
}

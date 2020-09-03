package com.zagurskaya.composite.entity;

import java.util.ArrayList;
import java.util.List;

public class ProjectComposite implements Lecsema {
    List<Lecsema> list = new ArrayList<>();

    @Override
    public StringBuilder value() {
        return null;
    }

    @Override
    public void add(StringBuilder element) {
        list.stream().forEach(s -> list.add(s));

    }

    @Override
    public void remove(StringBuilder element) {
        list.stream().forEach(s -> list.remove(s));
    }
}

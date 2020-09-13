package com.zagurskaya.task2.comparator;

import com.zagurskaya.task2.composite.TextComponent;
import com.zagurskaya.task2.util.DataUtil;

import java.util.Comparator;

public enum TextComparator implements Comparator<TextComponent> {
    SIZE {
        @Override
        public int compare(TextComponent o1, TextComponent o2) {
            return Long.compare(o1.getComponents().size(), o2.getComponents().size());
        }
    },
    ALL_LENGTH_WORDS {
        @Override
        public int compare(TextComponent o1, TextComponent o2) {
            return Integer.compare(DataUtil.lengthAllСhildComponents(o1.getComponents()), DataUtil.lengthAllСhildComponents(o2.getComponents()));
        }
    },
    ALL_LENGTH_LEXEME {
        @Override
        public int compare(TextComponent o1, TextComponent o2) {
            return Integer.compare(DataUtil.lengthComponents(o1.getComponents()), DataUtil.lengthComponents(o2.getComponents()));
        }
    }

}

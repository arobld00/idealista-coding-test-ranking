package com.idealista.infrastructure.utils;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class WordCounter {

    private String text;

    public WordCounter(String text) {
        this.text = text;
    }

    public int getCount() {
        return (isBlank(text)) ? 0 : text.split("\\s+").length;
    }

}

package com.study.demo.user;

public enum ColorCode {
    PINK("#bd75c7"), BLUE("#2b3aab"), ORANGE("#c28229"),RED("#873242"),GREEN("#588c5b");
    private final String value;

    ColorCode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

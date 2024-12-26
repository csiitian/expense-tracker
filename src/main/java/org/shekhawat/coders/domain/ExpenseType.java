package org.shekhawat.coders.domain;

public enum ExpenseType {
    EQUAL("EQUAL"),
    EXACT("EXACT"),
    PERCENT("PERCENT");

    String name;

    ExpenseType(String name) {
        this.name = name;
    }
}

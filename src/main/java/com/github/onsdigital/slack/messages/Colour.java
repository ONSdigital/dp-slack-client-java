package com.github.onsdigital.slack.messages;

public enum Colour {
    GOOD("good"),

    WARNING("warning"),

    DANGER("danger");

    private String color;

    Colour(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }
}

package com.github.onsdigital.slack.messages;

import java.util.ArrayList;
import java.util.List;

public class PostMessageAttachment {

    private String pretext;

    private String text;

    private String title;

    private String color;

    private List<PostMessageField> fields;

    public PostMessageAttachment() {
        this("", "", Colour.GOOD);
    }

    public PostMessageAttachment(String title, String text, Colour colour) {
        this.fields = new ArrayList<>();
        this.title = title;
        this.text = text;
        if (colour == null) colour = Colour.GOOD;
        this.color = colour.getColor();
    }

    public String getPretext() {
        return pretext;
    }

    public void setPretext(String pretext) {
        this.pretext = pretext;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<PostMessageField> getFields() {
        return fields;
    }

    public void setFields(List<PostMessageField> fields) {
        this.fields = fields;
    }

    public PostMessageAttachment addField(String title, String value, boolean isShort) {
        this.getFields().add(new PostMessageField(title, value, isShort));
        return this;
    }
}

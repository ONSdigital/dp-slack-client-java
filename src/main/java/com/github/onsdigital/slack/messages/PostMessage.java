package com.github.onsdigital.slack.messages;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PostMessage {

    @SerializedName("icon_emoji")
    private String emoji;

    private String channel;

    private String username;

    private String text;

    private List<PostMessageAttachment> attachments;

    private String ts;

    public PostMessage() {
        this("", "", ":grinning:", "");
    }

    public PostMessage(String username, String channel, String emoji) {
        this(username, channel, emoji, "");
    }

    public PostMessage(String username, String channel, String emoji, String text) {
        this.username = username;
        this.channel = channel;
        this.text = text;
        this.emoji = emoji;

        this.attachments = new ArrayList<>();
    }

    public String getEmoji() {
        return this.emoji;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getUsername() {
        return this.username;
    }

    public String getText() {
        return this.text;
    }

    public List<PostMessageAttachment> getAttachments() {
        return this.attachments;
    }

    public String getTs() {
        return this.ts;
    }

    public PostMessage emoji(final String emoji) {
        this.emoji = emoji;
        return this;
    }

    public PostMessage channel(final String channel) {
        this.channel = channel;
        return this;
    }

    public PostMessage uername(final String username) {
        this.username = username;
        return this;
    }

    public PostMessage text(final String text) {
        this.text = text;
        return this;
    }

    public PostMessage attachments(final List<PostMessageAttachment> attachments) {
        this.attachments = attachments;
        return this;
    }

    public PostMessage ts(final String ts) {
        this.ts = ts;
        return this;
    }

    public PostMessage addAttachment(PostMessageAttachment attachment) {
        this.getAttachments().add(attachment);
        return this;
    }

    public PostMessage withAttachment(String title, String text, Colour colour) {
        this.getAttachments().add(new PostMessageAttachment(title, text, colour));
        return this;
    }
}
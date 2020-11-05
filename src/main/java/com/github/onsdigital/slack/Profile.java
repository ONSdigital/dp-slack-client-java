package com.github.onsdigital.slack;

import com.github.onsdigital.slack.messages.PostMessage;

public class Profile {

    private String username;

    private String emoji;

    private String authToken;

    public Profile(final String username, final String emoji, final String authToken) {
        this.username = username;
        this.emoji = emoji;
        this.authToken = authToken;
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmoji() {
        return this.emoji;
    }

    public String getAuthToken() {
        return this.authToken;
    }

    public PostMessage newPostMessage(String channel, String text) {
        return new PostMessage(this.username, channel, this.emoji, text);
    }
}

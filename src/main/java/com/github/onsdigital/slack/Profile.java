package com.github.onsdigital.slack;

import com.github.onsdigital.slack.messages.PostMessage;

public class Profile {

    private final String username;
    private final String emoji;
    private final String authToken;

    Profile(final String username, final String emoji, final String authToken) {
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

    public static class Builder {

        private String username;
        private String emoji;
        private String authToken;

        public Builder() {
        }

        public Builder username(final String username) {
            this.username = username;
            return this;
        }

        public Builder emoji(final String emoji) {
            this.emoji = emoji;
            return this;
        }

        public Builder authToken(final String authToken) {
            this.authToken = authToken;
            return this;
        }

        public Profile create() {
            return new Profile(this.username, this.emoji, this.authToken);
        }
    }
}

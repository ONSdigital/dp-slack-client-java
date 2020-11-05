package com.github.onsdigital.slack.client;

public class PostMessageResponse {

    private boolean ok;
    private String channel;
    private String ts;

    public PostMessageResponse(final boolean ok, final String channel, final String ts) {
        this.ok = ok;
        this.channel = channel;
        this.ts = ts;
    }

    public PostMessageResponse() {
        this(false, "", "");
    }

    public boolean isOk() {
        return this.ok;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getTs() {
        return this.ts;
    }
}

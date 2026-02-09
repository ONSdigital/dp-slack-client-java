package com.github.onsdigital.slack.client;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.core5.http.io.entity.StringEntity;

class Http {

    static final String CONTENT_TYPE = "Content-type";
    static final String APPLICATION_JSON = "application/json; charset=UTF-8";

    public HttpPost createHttpPost(String url, String authToken, String json) {
        try {
            HttpPost post = new HttpPost(url);
            post.addHeader(CONTENT_TYPE, APPLICATION_JSON);
            post.addHeader("Authorization", "Bearer " + authToken);
            post.setEntity(new StringEntity(json));
            return post;
        } catch (IllegalArgumentException ex) {
            throw new RuntimeException(ex);
        }
    }
}

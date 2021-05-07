package com.github.onsdigital.slack.client;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.io.UnsupportedEncodingException;

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
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }
    }
}

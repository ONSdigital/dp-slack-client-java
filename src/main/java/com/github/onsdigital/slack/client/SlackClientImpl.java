package com.github.onsdigital.slack.client;

import com.github.onsdigital.slack.Profile;
import com.github.onsdigital.slack.messages.PostMessage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SlackClientImpl implements SlackClient {
    private final Profile profile;

    private Http http;
    private Gson gson;

    public SlackClientImpl(Profile profile) {
        this.profile = profile;
        this.http = new Http();
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public PostMessageResponse sendMessage(PostMessage message) {
        HttpPost postMessageRequest = http.createHttpPost(
                "https://slack.com/api/chat.postMessage", this.profile.getAuthToken(), gson.toJson(message));

        return sendMessage(postMessageRequest);
    }

    @Override
    public PostMessageResponse updateMessage(PostMessage message) {
        HttpPost postMessageRequest = http.createHttpPost(
                "https://slack.com/api/chat.update", this.profile.getAuthToken(), gson.toJson(message));

        return sendMessage(postMessageRequest);
    }

    @Override
    public Profile getProfile() {
        return this.profile;
    }

    public PostMessageResponse sendMessage(HttpPost httpPost) {
        try (
                CloseableHttpClient httpClient = HttpClients.createDefault();
                CloseableHttpResponse response = httpClient.execute(httpPost)
        ) {
            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("incorrect response status code");
            }

            try (
                    InputStream in = response.getEntity().getContent();
                    InputStreamReader reader = new InputStreamReader(in)
            ) {
                PostMessageResponse entity = gson.fromJson(reader, PostMessageResponse.class);
                System.out.println(gson.toJson(entity));

                if (!entity.isOk()) {
                    // to expand this to include error details.
                    throw new RuntimeException("slack response was not OK");
                }

                return entity;
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}

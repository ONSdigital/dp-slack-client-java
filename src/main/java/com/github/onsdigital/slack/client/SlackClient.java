package com.github.onsdigital.slack.client;

import com.github.onsdigital.slack.messages.PostMessage;
import com.github.onsdigital.slack.Profile;

public interface SlackClient {

    PostMessageResponse sendMessage(PostMessage message);

    PostMessageResponse updateMessage(PostMessage message);

    Profile getProfile();
}

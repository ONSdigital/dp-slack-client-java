package com.github.onsdigital.slack.example;

import com.github.onsdigital.slack.Profile;
import com.github.onsdigital.slack.client.PostMessageResponse;
import com.github.onsdigital.slack.client.SlackClient;
import com.github.onsdigital.slack.client.SlackClientImpl;
import com.github.onsdigital.slack.messages.Colour;
import com.github.onsdigital.slack.messages.PostMessage;
import com.github.onsdigital.slack.messages.PostMessageAttachment;

import java.util.Date;

public class App {

    public static void main(String[] args) throws Exception {
        Profile profile = new Profile.Builder()
                        .username("Zebedee-test")
                        .emoji(":chart_with_upwards_trend:")
                        .authToken(System.getenv("SLACK_TOKEN"))
                        .create();

        SlackClient slack = new SlackClientImpl(profile);

        run(slack);
    }

    public static void run(SlackClient slack) throws Exception {
        Profile profile = slack.getProfile();

        PostMessage msg = profile.newPostMessage("slack-client-test", "Publishing collection *testCollection1*")
                .addAttachment(
                        new PostMessageAttachment("Pre-publish", "", Colour.GOOD)
                                .addField("Start time", new Date().toString(), true));

        PostMessageResponse response = slack.sendMessage(msg);

        Thread.sleep(3000);

        msg.ts(response.getTs())
                .channel(response.getChannel())
                .getAttachments()
                .get(0)
                .addField("End time:", new Date().toString(), true);

        msg.addAttachment(new PostMessageAttachment("Publish", "", Colour.GOOD)
                        .addField("Start time",  new Date().toString(), true));


        response = slack.updateMessage(msg);
        Thread.sleep(3000);

        msg.ts(response.getTs())
                .channel(response.getChannel())
                .getAttachments()
                .get(1)
                .addField("Publish end time:", new Date().toString(), true);

        msg.addAttachment(new PostMessageAttachment("Post-publish", "", Colour.GOOD)
                        .addField("Start time:", new Date().toString(), true));

        response = slack.updateMessage(msg);
        Thread.sleep(3000);

        msg.text(msg.getText() + " completed successfully :white_check_mark:")
                .ts(response.getTs())
                .channel(response.getChannel())
                .getAttachments()
                .get(2)
                .addField("end time:", new Date().toString(), true);
        slack.updateMessage(msg);
    }
}

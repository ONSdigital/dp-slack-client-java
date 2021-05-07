package com.github.onsdigital.slack;

public class Configuration {

    private static final String POST_MESSAGE_URI = "https://slack.com/api/chat.postMessage";
    private static final String UPDATE_MESSAGE_URI = "https://slack.com/api/chat.update";

    private final String slackToken;
    private final String slackDefaultChannel;
    private final String slackAlarmChannel;
    private final String slackPublishChannel;
    private final String slackUsername;

    private Configuration(final String slackToken, final String slackDefaultChannel, final String slackAlarmChannel,
                    final String slackPublishChannel, final String slackUsername) {
        this.slackToken = slackToken;
        this.slackDefaultChannel = slackDefaultChannel;
        this.slackAlarmChannel = slackAlarmChannel;
        this.slackPublishChannel = slackPublishChannel;
        this.slackUsername = slackUsername;
    }

    public static class Builder {
        private String authToken;
        private String defaultChannel;
        private String alarmChannel;
        private String publishChannel;
        private String userName;

        public void authToken(final String slackToken) {
            this.authToken = slackToken;
        }

        public void defaultChannel(final String slackDefaultChannel) {
            this.defaultChannel = slackDefaultChannel;
        }

        public void alarmChannel(final String slackAlarmChannel) {
            this.alarmChannel = slackAlarmChannel;
        }

        public void publishChannel(final String slackPublishChannel) {
            this.publishChannel = slackPublishChannel;
        }

        public void username(final String slackUsername) {
            this.userName = slackUsername;
        }

        public Configuration build() {
            return new Configuration(this.authToken, this.defaultChannel, this.alarmChannel, this.publishChannel, this.userName);
        }
    }


}

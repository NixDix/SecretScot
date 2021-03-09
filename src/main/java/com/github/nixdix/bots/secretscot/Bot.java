package com.github.nixdix.bots.secretscot;

import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;

class Bot {
    private static final String TOKEN = new String();

    public static void runBot() {
        try {
            System.getenv("DISCORD_TOKEN");
        } catch (NullPointerException ex) {
            throw new NullPointerException("Failed to get token.");
        }

        final DiscordClient client = DiscordClient.create(TOKEN);
        final GatewayDiscordClient gateway = client.login()
                .block();

        gateway.on(MessageCreateEvent.class).subscribe(evt -> {
            final String msg = evt.getMessage().toString();

            if (msg.isEmpty() || msg.length() == 0) {
                throw new IllegalArgumentException("Despite this callback being fired, the message is empty??");
            }
        });

        gateway.onDisconnect().block();
    }
}

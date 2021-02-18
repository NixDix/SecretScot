package org.nixdix.bots.secretscot;

import org.javacord.api.*;

public class App {
    public static void main(String[] args) {
        String token = "PLACEHOLDER";

        DiscordApi api = new DiscordApiBuilder()
                .setToken(token)
                .login()
                .join();

        api.addMessageCreateListener(event -> {
            if (event.getMessageContent()
                    .equalsIgnoreCase("!ping")) {
                event.getChannel().sendMessage(":PONG");
            } else if (event.getMessageContent()
                    .equalsIgnoreCase("!shybeega")) {
                event.getChannel()
                        .sendMessage("BUZZ BUZZ BUZZ!");
            }
        });
    }
}

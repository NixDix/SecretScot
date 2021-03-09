package com.github.nixdix.bots.secretscot.plugins;

import discord4j.core.object.Embed;
import discord4j.core.object.entity.Message;

interface Plugin {
    /* return true or false depending on success */
    boolean disable();
    boolean enable();

    void process(Message msg, Embed.Author author);
}
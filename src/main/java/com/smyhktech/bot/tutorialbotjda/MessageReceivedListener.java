/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smyhktech.bot.tutorialbotjda;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 *
 * @author skedzie
 */
public class MessageReceivedListener extends ListenerAdapter {
    
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentDisplay();
        
        if (message.startsWith("!hello")) {
            String name = event.getAuthor().getAsMention();
            
            String response = name + " hey bitch!";
            event.getTextChannel().sendMessage(response).queue();
        }
    }
}

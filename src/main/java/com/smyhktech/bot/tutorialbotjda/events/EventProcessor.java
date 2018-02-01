/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smyhktech.bot.tutorialbotjda.events;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.core.hooks.EventListener;

/**
 *
 * @author skedzie
 */
public class EventProcessor implements EventListener {
    
    Guild guild;
    User user;
    MessageChannel channel;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Override
    public void onEvent(Event event) {
        if (event instanceof GuildMemberJoinEvent) {
            user = ((GuildMemberJoinEvent) event).getUser();

            LocalDateTime joinTime = LocalDateTime.now();
            String formattedDate = formatter.format(joinTime);
            
            guild = ((GuildMemberJoinEvent) event).getGuild();
            channel = guild.getTextChannelById(353293437312958465L);
            
            String message = user.getAsMention() + " joined at: " + formattedDate;
            channel.sendMessage(message).queue();
        }
        else if (event instanceof GuildMemberLeaveEvent) {
            user = ((GuildMemberLeaveEvent) event).getUser();
            
            LocalDateTime leaveTime = LocalDateTime.now();
            String formattedDate = formatter.format(leaveTime);
            
            guild = ((GuildMemberLeaveEvent) event).getGuild();
            channel = guild.getTextChannelById(353293437312958465L);
            
            String message = user.getAsMention() + " left at: " + formattedDate;
            channel.sendMessage(message).queue();
        }
    }
}

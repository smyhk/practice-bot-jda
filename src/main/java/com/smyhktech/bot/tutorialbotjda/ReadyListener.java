/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smyhktech.bot.tutorialbotjda;

import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 *
 * @author skedzie
 */
public class ReadyListener extends ListenerAdapter {
    
    @Override
    public void onReady(ReadyEvent e) {
        System.out.println("Bot online!");
        System.out.println(e.getJDA().getSelfUser().getName());
        System.out.println(e.getJDA().getSelfUser().getDiscriminator());
    }
}

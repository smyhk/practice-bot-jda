/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smyhktech.bot.tutorialbotjda;

import com.smyhktech.bot.tutorialbotjda.listeners.ReadyListener;
import com.smyhktech.bot.tutorialbotjda.listeners.MessageReceivedListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 *
 * @author skedzie
 */
public class BotMain extends ListenerAdapter {
    
    public static void main(String[] args) {
        
        List<String> config = null;
        try {
            config = Files.readAllLines(Paths.get("config.txt"));

        } catch (IOException ex) {
            Logger.getLogger(BotMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        String token = config.get(0);
        
        try {
            
            JDA jda = new JDABuilder(AccountType.BOT)
                    .setToken(token)
                    .addEventListener(new ReadyListener())
                    .buildBlocking();
            
            jda.addEventListener(new MessageReceivedListener());
            jda.getPresence().setGame(Game.playing("I'm a dickbot, suck it!"));
            
        } catch (LoginException | InterruptedException ex) {
            Logger.getLogger(BotMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

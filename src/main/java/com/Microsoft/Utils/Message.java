package com.Microsoft.Utils;

import com.Microsoft.FireFlyClaim;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Message {
//    public FireFlyClaim plugin;
//
//    public Message(FireFlyClaim plugin){
//        this.plugin = plugin;
//    }

    public static void sendConsoleMessage(String message){
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "[FireFlyClaim] " + message));
    }

    public static void sendMessage(Player player, String message){
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }


}

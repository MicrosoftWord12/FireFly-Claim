package com.Microsoft;

import com.Microsoft.ChunkCommands.ClaimCMD;
import com.Microsoft.ChunkInfo.ChunkClaiming;
import com.Microsoft.Utils.ConfigYML;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class FireFlyClaim extends JavaPlugin {
    public ConfigYML config;

    @Override
    public void onEnable() {
        this.config = new ConfigYML(this);
        // Plugin startup logic

        // Plugin Config File loading
        this.saveDefaultConfig();

        config.fileSetup();
        config.get().options().copyDefaults(true);
        config.save();
        try{

            getCommand("claim").setExecutor(new ClaimCMD(new ChunkClaiming(new ConfigYML(this))));

        }catch (NullPointerException ex){
            ex.printStackTrace();
        }

        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[FireFlyClaim] Plugin Started up");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        config.save();
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[FireFlyClaim] Plugin spooling down");
    }

    public void sendPluginMessage(String message){
        Bukkit.getConsoleSender().sendMessage(message);
    }


}

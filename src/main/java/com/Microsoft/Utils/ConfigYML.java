package com.Microsoft.Utils;

import com.Microsoft.FireFlyClaim;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigYML {

    public FireFlyClaim plugin;

    public ConfigYML(FireFlyClaim plugin){
        this.plugin = plugin;
    }


    private static File file;
    private static FileConfiguration customFile;


    public void fileSetup(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("FireFlyClaim").getDataFolder(), "data.yml");
        if (!file.exists()){
            try{
                if (file.createNewFile()){
//                    System.out.println("Custom File Has Been Created");
//                    this.plugin.sendPluginMessage("&6Custom File Has Been Created");
                    Message.sendConsoleMessage("&6Custom File Has Been Created");
                }
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
        customFile = YamlConfiguration.loadConfiguration(file);
    }

    public FileConfiguration get(){ return customFile; }
    public void save() {
        try{
            customFile.save(file);
        }catch (IOException ex){
//            System.out.println("Could not save custom file");
            Message.sendConsoleMessage("&6Custom File Has Been Created");
//            this.plugin.sendPluginMessage("&cCould not save customer file");
        }
    }


}

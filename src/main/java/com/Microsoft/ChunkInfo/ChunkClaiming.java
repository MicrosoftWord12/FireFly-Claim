package com.Microsoft.ChunkInfo;

import com.Microsoft.FireFlyClaim;
import com.Microsoft.Utils.ConfigYML;
import com.Microsoft.Utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.*;
//import java.util.List;

public class ChunkClaiming {

//    public FireFlyClaim plugin;
    public ConfigYML config;

    public ChunkClaiming(ConfigYML config){
        this.config = config;
    }

    //////////////////// Chunk Claim functionality and so forth start here
//    HashMap<UUID, Set<String>> chunk = new HashMap<>();

    public void makeClaim(UUID uuid, String chunkId){
        try{
            List<String> chunk = new ArrayList<>(config.get().getStringList("Players." + uuid.toString() + ".Chunk"));
            if (!isInList(uuid, chunkId)){
                chunk.add(chunkId);
                config.get().set("Players." + uuid + ".Chunk", chunk);
                config.save();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public boolean isInList(UUID uuid, String chunkId){
        List<String> chunk = new ArrayList<>(config.get().getStringList("Players." + uuid.toString() + ".Chunk"));
        return chunk.contains(chunkId);
    }






}

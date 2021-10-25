package com.Microsoft.ChunkInfo;

import com.Microsoft.FireFlyClaim;
import com.Microsoft.Utils.ConfigYML;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;
//import java.util.List;

public class ChunkClaiming {

//    public FireFlyClaim plugin;
    public ConfigYML config;

    public ChunkClaiming(ConfigYML config){
        this.config = config;
    }

    //////////////////// Chunk Claim functionality and so forth start here
    HashMap<UUID, Set<String>> chunk = new HashMap<>();

    public void makeClaim(UUID uuid, Set<String> chunkId){
        try{
            chunk.put(uuid, chunkId);
            config.get().set("Players." + uuid.toString() + ".Chunk", chunkId.toString());
            config.save();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public boolean isClaimOwner(Player player, Set<String> chunkId){
        if (chunk.containsKey(player.getUniqueId()) && chunk.containsValue(chunkId)){
            if (chunk.get(player.getUniqueId()).equals(chunkId)){
                return false;
            }
            return true;
        }
        return true;
    }

    public boolean isClaimed(Player player, Set<String> chunkId){
        return chunk.containsKey(player.getUniqueId()) && chunk.containsValue(chunkId);
    }



}

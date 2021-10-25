package com.Microsoft.ChunkInfo;

import com.Microsoft.FireFlyClaim;
import com.Microsoft.Utils.ConfigYML;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
//import java.util.List;

public class ChunkClaiming {

//    public FireFlyClaim plugin;
    public ConfigYML config;

    public ChunkClaiming(ConfigYML config){
        this.config = config;
    }

    //////////////////// Chunk Claim functionality and so forth start here
    HashMap<Player, Set<String>> chunk = new HashMap<>();

    public void makeClaim(Player player, Set<String> chunkId){
        try{
            chunk.put(player, chunkId);
            config.get().set("Players." + player.toString() + ".Chunk", chunkId.toString());
            config.save();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public boolean isClaimOwner(Player player, Set<String> chunkId){
        if (chunk.containsKey(player) && chunk.containsValue(chunkId)){
            if (chunk.get(player).equals(chunkId)){
                return false;
            }
            return true;
        }
        return true;
    }

    public boolean isClaimed(Player player, Set<String> chunkId){
        return chunk.containsKey(player) && chunk.containsValue(chunkId);
    }



}

package com.Microsoft.ChunkCommands;

import com.Microsoft.ChunkInfo.ChunkClaiming;
import com.Microsoft.Utils.Message;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;

public class ClaimCMD implements CommandExecutor {
    public ChunkClaiming chunkClaiming;

    public ClaimCMD(ChunkClaiming chunkClaiming){
        this.chunkClaiming = chunkClaiming;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;
        double getX = player.getLocation().getX();
        double getY = player.getLocation().getY();
        String land = getX + " " + getY;

        if (!chunkClaiming.isClaimed(player, Collections.singleton(land))){
            if (chunkClaiming.isClaimOwner(player, Collections.singleton(land))){
                chunkClaiming.makeClaim(player, Collections.singleton(land));
                Message.sendMessage(player, "&aYou have claimed this land");
            }else{
                Message.sendMessage(player, "&cLol this is your land");
            }
        }else{
            Message.sendMessage(player, "&cThis land is claimed");
        }
        return true;
    }
}

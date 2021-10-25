package com.Microsoft.ChunkCommands;

import com.Microsoft.ChunkInfo.ChunkClaiming;
import com.Microsoft.ChunkInfo.ClaimPerms;
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
        if (!(sender.hasPermission(ClaimPerms.CLAIM_ADD.name()))) return false;
        Player player = (Player) sender;

        double getX = player.getLocation().getChunk().getX();
        double getZ = player.getLocation().getChunk().getZ();
        String land = getX + " " + getZ;

        if (!chunkClaiming.isClaimed(player, Collections.singleton(land))) {
            Message.sendMessage(player, "&aYou have claimed this land");
            chunkClaiming.makeClaim(player.getUniqueId(), Collections.singleton(land));
            return false;
        }

        return true;
    }
}

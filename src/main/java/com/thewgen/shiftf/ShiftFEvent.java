package com.thewgen.shiftf;

import org.apache.commons.lang3.text.StrSubstitutor;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

import java.util.Map;

public class ShiftFEvent implements Listener {
    @EventHandler
    public void ShiftF(final PlayerSwapHandItemsEvent e){
        Player player = e.getPlayer();
        Server server = ShiftF.getPlugin(ShiftF.class).getServer();
        String command = ShiftF.getPlugin(ShiftF.class).getConfig().getString("Command");
        Map<String, String> placeholders = Map.of(
                "player", e.getPlayer().getName(),
                "locationX", Integer.toString(player.getLocation().getBlockX()),
                "locationY", Integer.toString(player.getLocation().getBlockY()),
                "locationZ", Integer.toString(player.getLocation().getBlockZ())
        );
        if (player.isSneaking()){
            e.setCancelled(true);
            server.dispatchCommand((CommandSender) server.getConsoleSender(), "cp menu " + player.getName());
        }
    }
}

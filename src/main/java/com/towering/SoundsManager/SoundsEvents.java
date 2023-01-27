package com.towering.SoundsManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class SoundsEvents implements Listener {
    @EventHandler
    public void onWorldChange(PlayerChangedWorldEvent event) {
        Player player = event.getPlayer();
        if (player.getWorld().getName().equalsIgnoreCase("hub3")) {
            player.playSound(player.getLocation(), "audio2", 0.2f, 1f);
        }
    }
}

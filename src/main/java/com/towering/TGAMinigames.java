package com.towering;

import com.towering.SoundsManager.SoundsCommands;
import com.towering.SoundsManager.SoundsEvents;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class TGAMinigames extends JavaPlugin implements Listener{

    @Override
    public void onEnable() {
        getLogger().info("TGAMinigames has been enabled!");
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new SoundsEvents(), this);
        getCommand("music").setExecutor(new SoundsCommands());
    }

    @Override
    public void onDisable() {
        getLogger().info("TGAMinigames has been disabled!");
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        e.getPlayer().setResourcePack("");
    }
    @EventHandler
    public void onPackLoad(PlayerResourcePackStatusEvent e){
        PlayerResourcePackStatusEvent.Status packStatus = e.getStatus();
        Player player = e.getPlayer();

        if (packStatus == PlayerResourcePackStatusEvent.Status.DECLINED || packStatus == PlayerResourcePackStatusEvent.Status.FAILED_DOWNLOAD){
            player.kickPlayer("Texture pack error.");
        }
        if (packStatus == PlayerResourcePackStatusEvent.Status.SUCCESSFULLY_LOADED)  {
            player.playSound(player.getLocation(), "audio2", 0.2f, 1f);
        }
    }
}

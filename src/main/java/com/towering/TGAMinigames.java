package com.towering;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public final class TGAMinigames extends JavaPlugin implements Listener{

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getLogger().info("TGAMinigames has been enabled!");
        getServer().getPluginManager().registerEvents(this, this);
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
    }
}

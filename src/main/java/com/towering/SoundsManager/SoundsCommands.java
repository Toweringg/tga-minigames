package com.towering.SoundsManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class SoundsCommands implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(label.equalsIgnoreCase("music")){
            if(!(sender instanceof Player)) {
                sender.sendMessage("This command cannot be ran through console.");
            }
            Player player = (Player) sender;
            if(player.hasPermission("music.help")) {
                if (args.length == 0 || args.length == 1) {
                    sender.sendMessage("/music start all - will start the music playlist for everyone on the server" +
                            "\n/music start (player) - will start the music playlist for the specified player" +
                            "\n/music stop all - will stop the music playlist for everyone on the server" +
                            "\n/music stop (player) - will stop the music playlist for the specified player");
                } else {
                    if (args[0].equalsIgnoreCase("start")) {
                        Player target = Bukkit.getServer().getPlayerExact(args[1]);
                        if (args[1].equalsIgnoreCase("all")) {
                            for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                                p.playSound(player.getLocation(), "audio2", 0.2f, 1f);
                            }
                            player.sendMessage(ChatColor.GREEN + "Christmas playlist now playing for ALL players.");
                        } else if (target != null) {
                            target.playSound(player.getLocation(), "audio2", 0.2f, 1f);
                            player.sendMessage(ChatColor.GREEN + "Christmas playlist now playing for " + ChatColor.WHITE + args[1] + ChatColor.GREEN + ".");
                        } else {
                            sender.sendMessage("Player " + args[1] + " is not online.");
                        }
                    } else if (args[0].equalsIgnoreCase("stop")) {
                        Player target = Bukkit.getServer().getPlayerExact(args[1]);
                        if (args[1].equalsIgnoreCase("all")) {
                            for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                                p.stopSound("audio2");
                            }
                            player.sendMessage(ChatColor.RED + "Christmas playlist stopped for ALL players.");
                        } else if (target != null) {
                            target.stopSound("audio2");
                            player.sendMessage(ChatColor.RED + "Christmas playlist stopped for" + ChatColor.WHITE + args[1] + ChatColor.RED + ".");
                        } else {
                            sender.sendMessage("Player " + args[1] + " is not online.");
                        }
                    }
                }
            }
        }
        return true;
    }
}


package de.mimoalexer.yHIMH;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import static org.bukkit.Bukkit.getServer;

public class YourHeartIsMyHeart extends JavaPlugin implements Listener, CommandExecutor {
    private boolean active = false;
    private boolean debug = false;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        this.getCommand("heart").setExecutor(this);
        getLogger().info("YourHeartIsMyHeart enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("YourHeartIsMyHeart disabled.");
    }

    @Override
    public boolean onCommand(CommandSender sender, @NotNull Command command, @NotNull String label, String @NotNull [] args) {
        if (!sender.hasPermission("yourheartis.myheart.use")) {
            sender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
            return true;
        }

        if (args.length == 1) {
            String sub = args[0].toLowerCase();
            switch (sub) {
                case "start":
                    active = true;
                    sender.sendMessage(ChatColor.GREEN + "Shared heart damage enabled.");
                    break;
                case "stop":
                    active = false;
                    sender.sendMessage(ChatColor.GREEN + "Shared heart damage disabled.");
                    break;
                default:
                    sender.sendMessage(ChatColor.RED + "Usage: /heart <start|stop|debug> [start|stop]");
            }
            return true;
        } else if (args.length == 2 && args[0].equalsIgnoreCase("debug")) {
            String mode = args[1].toLowerCase();
            switch (mode) {
                case "start":
                    debug = true;
                    sender.sendMessage(ChatColor.GREEN + "Debug mode enabled.");
                    break;
                case "stop":
                    debug = false;
                    sender.sendMessage(ChatColor.GREEN + "Debug mode disabled.");
                    break;
                default:
                    sender.sendMessage(ChatColor.RED + "Usage: /heart debug <start|stop>");
            }
            return true;
        }

        sender.sendMessage(ChatColor.RED + "Usage: /heart <start|stop|debug> [start|stop]");
        return true;
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (!active) return;
        if (!(event.getEntity() instanceof Player damaged)) return;

        double dmg = event.getFinalDamage();
        EntityDamageEvent.DamageCause cause = event.getCause();

        if (debug) {
            String msg = ChatColor.RED + "[HeartDebug] " + damaged.getName() + " took " + dmg + " damage from " + cause;
            for (Player p : Bukkit.getOnlinePlayers()) {
                if (p.isOp()) {
                    p.sendMessage(msg);
                }
            }
        }

        for (Player p : Bukkit.getOnlinePlayers()) {
            if (!p.equals(damaged)) {
                p.damage(dmg);
            }
        }
    }
}
package net.kayega;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class CommandExecutor extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getCommand("playercommand").setExecutor(new PlayerCommand());
        getCommand("pcommand").setExecutor(new PlayerCommand());

        Bukkit.getPluginManager().registerEvents(this, this);
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage("§6[§aCommand Executor§6] §aPlugin Enabled!");
        Bukkit.getConsoleSender().sendMessage("§6[§aCommand Executor§6] §8Version: 2.7.4");
        Bukkit.getConsoleSender().sendMessage(" ");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§6[§aCommand Executor§6] §cPlugin Disabled!");
    }
}

package me.luminescence.serverinfo;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        System.out.println("[ServerInfo] Has enabled successfully");

        Bukkit.getPluginManager().registerEvents(new JoinMessage(), this);

        //commands
        Objects.requireNonNull(getCommand("discord")).setExecutor(new DiscordCommand());
        Objects.requireNonNull(getCommand("website")).setExecutor(new WebsiteCommand());
        Objects.requireNonNull(getCommand("serverinfo")).setExecutor(new InfoCommand());

    }

}

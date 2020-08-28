package me.luminescence.serverinfo;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class WebsiteCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Main main = JavaPlugin.getPlugin(Main.class);

        String prefix = main.getConfig().getString("prefix");
        assert prefix != null;
        prefix = ChatColor.translateAlternateColorCodes('&', prefix);


        if (args.length == 0) {

            String website = main.getConfig().getString("websiteLink");
            assert website != null;
            website = ChatColor.translateAlternateColorCodes('&', website);

            String webMessage = main.getConfig().getString("websiteMessage").replace("%websiteLink%", "&6&l" + website).replace("%prefix%", prefix);
            webMessage = ChatColor.translateAlternateColorCodes('&', webMessage);

            sender.sendMessage(webMessage);

        }

        return false;
    }
}

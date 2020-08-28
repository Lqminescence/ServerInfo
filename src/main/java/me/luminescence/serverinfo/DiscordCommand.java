package me.luminescence.serverinfo;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class DiscordCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Main main = JavaPlugin.getPlugin(Main.class);

        String prefix = main.getConfig().getString("prefix");
        assert prefix != null;
        prefix = ChatColor.translateAlternateColorCodes('&', prefix);

        if (args.length == 0) {

            String discord = main.getConfig().getString("discordLink");
            assert discord != null;
            discord = ChatColor.translateAlternateColorCodes('&', discord);

            String discordMessage = main.getConfig().getString("discordMessage").replace("%discordLink%", "&9&l" + discord).replace("%prefix%", prefix);
            discordMessage = ChatColor.translateAlternateColorCodes('&', discordMessage);

            sender.sendMessage(discordMessage);

        } else if (args[0].equalsIgnoreCase("set")) {

            if (sender.hasPermission("serverinfo.set")) {

            if (args[1] == null) {

                sender.sendMessage(prefix + ChatColor.RED + "Incorrect usage! Please do /discord set [discord link]!");

            } else {

                main.getConfig().set("discordLink", args[1]);
                sender.sendMessage(prefix + ChatColor.GREEN + " You have set the server discord link to " + args[1]);

            }

            } else {

                sender.sendMessage(ChatColor.RED + "You are not allowed to set the discord link!");

            }
        }

        return false;
    }
}

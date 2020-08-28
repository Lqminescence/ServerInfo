package me.luminescence.serverinfo;

import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class InfoCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Main main = JavaPlugin.getPlugin(Main.class);

            String prefix = main.getConfig().getString("prefix");
            assert prefix != null;
            prefix = ChatColor.translateAlternateColorCodes('&', prefix);

            String discord = main.getConfig().getString("discordLink");
            assert discord != null;
            discord = ChatColor.translateAlternateColorCodes('&', discord);


            String message = Objects.requireNonNull(main.getConfig().getString("joinMessageL1")).replace("%prefix%", prefix).replace("%discordLink%", discord);
            message = ChatColor.translateAlternateColorCodes('&', message);

            String message1 = Objects.requireNonNull(main.getConfig().getString("joinMessageL2")).replace("%prefix%", prefix).replace("%discordLink%", discord);
            message1 = ChatColor.translateAlternateColorCodes('&', message1);

            String message2 = Objects.requireNonNull(main.getConfig().getString("joinMessageL3")).replace("%prefix%", prefix).replace("%discordLink%", discord);
            message2 = ChatColor.translateAlternateColorCodes('&', message2);

            String message3 = Objects.requireNonNull(main.getConfig().getString("joinMessageL4")).replace("%prefix%", prefix).replace("%discordLink%", discord);
            message3 = ChatColor.translateAlternateColorCodes('&', message3);

            String message4 = Objects.requireNonNull(main.getConfig().getString("joinMessageL5")).replace("%prefix%", prefix).replace("%discordLink%", discord);
            message4 = ChatColor.translateAlternateColorCodes('&', message4);

            String message5 = Objects.requireNonNull(main.getConfig().getString("joinMessageL6")).replace("%prefix%", prefix).replace("%discordLink%", discord);
            message5 = ChatColor.translateAlternateColorCodes('&', message5);

            String message6 = Objects.requireNonNull(main.getConfig().getString("joinMessageL7")).replace("%prefix%", prefix).replace("%discordLink%", discord);
            message6 = ChatColor.translateAlternateColorCodes('&', message6);


            Player player = (Player) sender;

            player.sendMessage(StringUtils.center(message, 19));
            player.sendMessage(StringUtils.center(message1, 10));
            player.sendMessage(StringUtils.center(message2, 5));
            player.sendMessage(StringUtils.center(message3, 4));
            player.sendMessage(StringUtils.center(message4, 4));
            player.sendMessage(StringUtils.center(message5, 10));
            player.sendMessage(StringUtils.center(message6, 4));


        }


        return false;
    }
}

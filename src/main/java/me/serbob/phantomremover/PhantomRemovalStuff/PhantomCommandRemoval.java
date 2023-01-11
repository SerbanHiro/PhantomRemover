package me.serbob.phantomremover.PhantomRemovalStuff;

import me.serbob.phantomremover.PhantomRemover;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PhantomCommandRemoval implements CommandExecutor {
    private final PhantomRemover plugin;

    public PhantomCommandRemoval(PhantomRemover plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("phantoms")) {
            if (args.length != 1) {
                sender.sendMessage(ChatColor.RED + "Usage: /phantoms <enabled|disabled>");
                return true;
            }

            String value = args[0];
            if (value.equalsIgnoreCase("enabled") || value.equalsIgnoreCase("disabled")) {
                plugin.getConfig().set("phantoms", value);
                plugin.saveConfig();
                sender.sendMessage(ChatColor.GREEN + "Phantom removal has been " + ChatColor.RED + value + ChatColor.GREEN + ".");
                return true;
            } else {
                sender.sendMessage(ChatColor.RED + "Invalid value. Usage: /phantoms <enabled|disabled>");
                return true;
            }
        }
        return false;
    }
}
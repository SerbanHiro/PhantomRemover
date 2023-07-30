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
            handlePhantomsCommand(sender, args);
            return true;
        }
        return false;
    }

    private void handlePhantomsCommand(CommandSender sender, String[] args) {
        if (args.length != 1) {
            sendUsageMessage(sender);
            return;
        }

        String value = args[0].toLowerCase();
        if (value.equals("enabled") || value.equals("disabled")) {
            setPhantomRemovalStatus(sender, value);
        } else {
            sendUsageMessage(sender);
        }
    }

    private void sendUsageMessage(CommandSender sender) {
        sender.sendMessage(ChatColor.RED + "Usage: /phantoms <enabled|disabled>");
    }

    private void setPhantomRemovalStatus(CommandSender sender, String value) {
        plugin.getConfig().set("phantoms", value);
        plugin.saveConfig();
        sender.sendMessage(ChatColor.GREEN + "Phantom removal has been " + ChatColor.RED + value + ChatColor.GREEN + ".");
    }
}

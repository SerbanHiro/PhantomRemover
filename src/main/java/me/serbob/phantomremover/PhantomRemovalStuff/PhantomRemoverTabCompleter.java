package me.serbob.phantomremover.PhantomRemovalStuff;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhantomRemoverTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            List<String> options = new ArrayList<>();
            options.add("enabled");
            options.add("disabled");
            return StringUtil.copyPartialMatches(args[0], options, new ArrayList<>());
        }
        return Collections.emptyList();
    }
}

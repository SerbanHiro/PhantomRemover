package me.serbob.phantomremover;

import me.serbob.phantomremover.PhantomRemovalStuff.PhantomCommandRemoval;
import me.serbob.phantomremover.PhantomRemovalStuff.PhantomRemoverListener;
import me.serbob.phantomremover.PhantomRemovalStuff.PhantomRemoverTabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

public final class PhantomRemover extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        reloadConfig();

        getCommand("phantoms").setExecutor(new PhantomCommandRemoval(this));
        getCommand("phantoms").setTabCompleter(new PhantomRemoverTabCompleter());
        getServer().getPluginManager().registerEvents(new PhantomRemoverListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

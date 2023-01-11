package me.serbob.phantomremover.PhantomRemovalStuff;

import me.serbob.phantomremover.PhantomRemover;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class PhantomRemoverListener implements Listener {
    private final PhantomRemover plugin;

    public PhantomRemoverListener(PhantomRemover plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        if (event.getEntityType() == EntityType.PHANTOM &&
                plugin.getConfig().getString("phantoms").equalsIgnoreCase("enabled")) {
            event.setCancelled(true);
        }
    }
}

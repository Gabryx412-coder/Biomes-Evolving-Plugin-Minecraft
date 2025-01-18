package com.gabryx412.biomes;


import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class PlayerActionsListener implements Listener {

    private final BiomeManager biomeManager;

    public PlayerActionsListener(BiomeManager biomeManager) {
        this.biomeManager = biomeManager;
    }

    // Ascolta le azioni dei giocatori che possono influenzare i biomi
    @EventHandler
    public void onPlayerAction(PlayerInteractEvent event) {
        if (event.getItem() != null && event.getItem().getType() == Material.STONE_AXE) {
            biomeManager.evolveBiome(event.getPlayer().getWorld(), event.getPlayer().getLocation().getBlockX(), event.getPlayer().getLocation().getBlockZ());
        }
    }

    @EventHandler
    public void onPlayerEat(PlayerItemConsumeEvent event) {
        if (event.getItem().getType() == Material.APPLE) {
            biomeManager.evolveBiome(event.getPlayer().getWorld(), event.getPlayer().getLocation().getBlockX(), event.getPlayer().getLocation().getBlockZ());
        }
    }
}

package com.gabryx412.biomes;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class BiomeEventHandler implements Listener {

    private final BiomeManager biomeManager;

    public BiomeEventHandler(BiomeManager biomeManager) {
        this.biomeManager = biomeManager;
    }

    // Gestisce gli eventi speciali per l'evoluzione dei biomi
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        biomeManager.evolveBiome(event.getPlayer().getWorld(), event.getPlayer().getLocation().getBlockX(), event.getPlayer().getLocation().getBlockZ());
    }
}

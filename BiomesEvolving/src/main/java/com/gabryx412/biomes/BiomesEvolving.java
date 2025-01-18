package com.gabryx412.biomes;

import org.bukkit.plugin.java.JavaPlugin;

public class BiomesEvolving extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("BiomesEvolving plugin avviato!");

        // Crea il manager dei biomi e registra gli eventi
        BiomeManager biomeManager = new BiomeManager();
        getServer().getPluginManager().registerEvents(new PlayerActionsListener(biomeManager), this);
        getServer().getPluginManager().registerEvents(new BiomeEventHandler(biomeManager), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("BiomesEvolving plugin disabilitato!");
    }
}


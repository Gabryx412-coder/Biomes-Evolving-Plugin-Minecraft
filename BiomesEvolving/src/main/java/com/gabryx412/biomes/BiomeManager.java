package com.gabryx412.biomes;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.json.JSONObject;

public class BiomeManager {

    private JSONObject biomeData;

    public BiomeManager() {
        loadBiomeData();
    }

    // Carica i dati dei biomi dal file JSON
    private void loadBiomeData() {
        try (FileReader reader = new FileReader(new File("plugins/BiomesEvolving/BiomeData.json"))) {
            int i;
            StringBuilder stringBuilder = new StringBuilder();
            while ((i = reader.read()) != -1) {
                stringBuilder.append((char) i);
            }
            this.biomeData = new JSONObject(stringBuilder.toString());
        } catch (IOException e) {
            Bukkit.getLogger().warning("Impossibile caricare i dati dei biomi.");
        }
    }

    // Gestisce l'evoluzione di un bioma
    public void evolveBiome(World world, int x, int z) {
        Chunk chunk = world.getChunkAt(x, z);
        String currentBiome = chunk.getWorld().getBiome(x, z).toString().toLowerCase();

        if (biomeData.has(currentBiome)) {
            JSONObject biomeInfo = biomeData.getJSONObject(currentBiome);
            double growthRate = biomeInfo.getDouble("growthRate");
            double decayRate = biomeInfo.getDouble("decayRate");

            // Evolve o degenere il bioma in base a un fattore casuale
            double factor = Math.random();
            if (factor < growthRate) {
                evolveToNewBiome(chunk, biomeInfo.getString("evolution"));
            } else if (factor > decayRate) {
                decayBiome(chunk);
            }
        }
    }

    // Evolve un bioma in un nuovo bioma
    private void evolveToNewBiome(Chunk chunk, String newBiome) {
        chunk.getWorld().setBiome(chunk.getX(), chunk.getZ(), org.bukkit.block.Biome.valueOf(newBiome.toUpperCase()));
    }

    // Deteriora un bioma, cambiandolo a un bioma desertico
    private void decayBiome(Chunk chunk) {
        chunk.getWorld().setBiome(chunk.getX(), chunk.getZ(), org.bukkit.block.Biome.DESERT);
    }
}

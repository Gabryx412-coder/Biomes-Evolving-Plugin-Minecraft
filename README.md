# BiomesEvolving Plugin

## Descrizione

**BiomesEvolving** è un plugin per Minecraft 1.21 che introduce un sistema dinamico in cui i biomi evolvono in base alle azioni dei giocatori e agli eventi del mondo. Con questo plugin, i biomi di Minecraft cambiano nel tempo, passando da uno stato sano a uno degradata (o viceversa) in risposta alle azioni dei giocatori, come la deforestazione, la costruzione, o la raccolta di risorse. I biomi evoluti possono rivelare nuove risorse, creature o sfide uniche per i giocatori.

## Funzionalità

- **Evoluzione dei biomi**: I biomi possono evolversi o decadere a seconda delle azioni dei giocatori.
- **Gestione dei biomi**: Il plugin gestisce vari biomi (ad esempio, bosco, deserto) e li modifica nel tempo in base a vari fattori come la crescita e il degrado.
- **Evoluzione attiva**: I biomi possono evolversi in nuovi biomi (ad esempio, un bosco può diventare un deserto se il giocatore distrugge troppe risorse naturali).
- **Risorse uniche**: I biomi evoluti rivelano nuove risorse, creature o ambienti speciali.
  
## Come Installare

1. **Pre-requisiti**:
    - Minecraft 1.21
    - Spigot API 1.21
    - Java 17 o successivo
    - Un server Spigot funzionante

2. **Download del Plugin**:
   - Scarica il plugin e inseriscilo nella cartella `plugins/` del tuo server Minecraft.

3. **Compilare il Plugin**:
   Se desideri compilare il plugin manualmente, segui questi passaggi:
   - Clona o scarica il progetto.
   - Assicurati di avere [Gradle](https://gradle.org/install/) installato.
   - Esegui il comando `./gradlew build` dalla root del progetto.
   - Troverai il file `.jar` compilato nella cartella `build/libs`.

4. **Carica il Plugin**:
   - Una volta ottenuto il file `.jar`, copia il file nella cartella `plugins/` del tuo server Minecraft.
   - Riavvia il server.

## Configurazione

Il plugin non richiede configurazioni complesse. La configurazione di base è contenuta nel file `plugin.yml`. 

Puoi anche modificare i dati relativi ai biomi nel file `BiomeData.json` per personalizzare il comportamento dell'evoluzione dei biomi.

### File `BiomeData.json`

Questo file contiene i dati di base per i biomi e definisce come evolvono. Un esempio di configurazione:

```json
{
  "forest": {
    "growthRate": 0.05,
    "decayRate": 0.02,
    "evolution": "desert",
    "resources": ["wood", "leaves", "saplings"]
  },
  "desert": {
    "growthRate": 0.01,
    "decayRate": 0.1,
    "evolution": "forest",
    "resources": ["sand", "cactus"]
  }
}

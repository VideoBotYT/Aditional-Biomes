package net.videobot.additional_biomes.worldgen.levelgen.biome;

import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.videobot.additional_biomes.worldgen.ModPlacedFeatures;

public class ADOverworldBiomes {
    // helper methods from Oh The Biomes Weve Go
    private static void addDefaultOverworldGeneration(BiomeGenerationSettings.Builder generationSettings) {
        globalOverworldGeneration(generationSettings);
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
    }

    private static BiomeGenerationSettings.Builder setupDefaultOverworldGeneration(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
        addDefaultOverworldGeneration(generationSettings);
        return generationSettings;
    }

    private static BiomeGenerationSettings.Builder setupDefaultOverworldGenerationWithoutLava(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
        generationSettings.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE);
        generationSettings.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND);
        generationSettings.addCarver(GenerationStep.Carving.AIR, Carvers.CANYON);
        generationSettings.addFeature(GenerationStep.Decoration.LAKES, MiscOverworldPlacements.LAKE_LAVA_UNDERGROUND);
        BiomeDefaultFeatures.addDefaultCrystalFormations(generationSettings);
        BiomeDefaultFeatures.addDefaultMonsterRoom(generationSettings);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(generationSettings);
        BiomeDefaultFeatures.addDefaultSprings(generationSettings);
        BiomeDefaultFeatures.addSurfaceFreezing(generationSettings);
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        return generationSettings;
    }

    private static void addSpawn(MobSpawnSettings.Builder builder, EntityType<?> entityType, int weight, int minGroupSize, int maxGroupSize) {
        builder.addSpawn(entityType.getCategory(), new MobSpawnSettings.SpawnerData(entityType, weight, minGroupSize, maxGroupSize));
    }

    private static void addVegetal(BiomeGenerationSettings.Builder builder, ResourceKey<PlacedFeature> feature) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, feature);
    }

    private static void addRawGeneration(BiomeGenerationSettings.Builder builder, ResourceKey<PlacedFeature> feature) {
        builder.addFeature(GenerationStep.Decoration.RAW_GENERATION, feature);
    }

    // creating biomes
    protected static Biome bloodwoodForest(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carvedGetter){
        BiomeGenerationSettings.Builder generationSettings = setupDefaultOverworldGeneration(placedFeatureGetter, carvedGetter);

        generationSettings.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE);
        BiomeDefaultFeatures.addDefaultOres(generationSettings);

        addVegetal(generationSettings, ModPlacedFeatures.BLOODWOOD_TREE);
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        addSpawn(spawnSettings, EntityType.FOX, 4, 2, 6);
        addSpawn(spawnSettings, EntityType.DONKEY, 2, 1, 4);

        generationSettings.addFeature(GenerationStep.Decoration.LAKES, MiscOverworldPlacements.SPRING_WATER);

        float temp = 1.5f;
        return new Biome.BiomeBuilder().hasPrecipitation(false).temperature(temp).downfall(0.2f).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(0x980000).waterFogColor(0x983E3E).grassColorOverride(0xB50000).fogColor(0x690000).skyColor(calculateSkyColor(temp)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).build();
    }

    // if minecrafts makes required stuff private, then i (Video Bot) make it myself (by copying the code XD)
    private static void globalOverworldGeneration(BiomeGenerationSettings.Builder generationSettings) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(generationSettings);
        BiomeDefaultFeatures.addDefaultCrystalFormations(generationSettings);
        BiomeDefaultFeatures.addDefaultMonsterRoom(generationSettings);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(generationSettings);
        BiomeDefaultFeatures.addDefaultSprings(generationSettings);
        BiomeDefaultFeatures.addSurfaceFreezing(generationSettings);
    }

    protected static int calculateSkyColor(float temperature) {
        float $$1 = temperature / 3.0F;
        $$1 = Mth.clamp($$1, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
    }
}

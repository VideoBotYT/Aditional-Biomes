package net.videobot.additional_biomes.worldgen.levelgen.biome;

import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import it.unimi.dsi.fastutil.objects.Reference2ObjectOpenHashMap;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.videobot.additional_biomes.AdditionalBiomesMod;
import net.videobot.additional_biomes.tags.ABTags;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ABBiomes {
    public static final Map<ResourceKey<Biome>, BiomeFactory> BIOME_FACTORIES = new Reference2ObjectOpenHashMap<>();
    public static final Multimap<TagKey<Biome>, ResourceKey<Biome>> BIOMES_BY_TAG = Multimaps.newSetMultimap(new HashMap<>(), HashSet::new);

    public static final ResourceKey<Biome> BLOODWOOD_FOREST = createBiome("bloodwood_forest", ADOverworldBiomes::bloodwoodForest, ABTags.FOREST);

    @SafeVarargs
    private static ResourceKey<Biome> createBiome(String id, BiomeFactory biomeFactory, TagKey<Biome>... tags) {
        ResourceKey<Biome> biomeResourceKey = AdditionalBiomesMod.key(Registries.BIOME, id);
        BIOME_FACTORIES.put(biomeResourceKey, biomeFactory);

        for (TagKey<Biome> tag : tags)
            BIOMES_BY_TAG.put(tag, biomeResourceKey);

        return biomeResourceKey;
    }

    @FunctionalInterface
    public interface BiomeFactory {
        Biome generate(HolderGetter<PlacedFeature> placedFeatureHolderGetter, HolderGetter<ConfiguredWorldCarver<?>> worldCarverHolderGetter);
    }
}

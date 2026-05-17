package net.videobot.additional_biomes.worldgen.levelgen.biome.selector;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import corgitaco.corgilib.serialization.codec.Wrapped;
import corgitaco.corgilib.serialization.jankson.JanksonUtil;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.videobot.additional_biomes.worldgen.levelgen.biome.ABBiomes;
import terrablender.api.Region;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BiomeSelector {
    public static final Wrapped<List<List<ResourceKey<Biome>>>> FOREST_BIOMES = create("forest", "", new ResourceKey[][]{
            {Region.DEFERRED_PLACEHOLDER, ABBiomes.BLOODWOOD_FOREST, Region.DEFERRED_PLACEHOLDER, Region.DEFERRED_PLACEHOLDER, Region.DEFERRED_PLACEHOLDER},
            {Region.DEFERRED_PLACEHOLDER, ABBiomes.BLOODWOOD_FOREST, Region.DEFERRED_PLACEHOLDER, Region.DEFERRED_PLACEHOLDER, ABBiomes.BLOODWOOD_FOREST}
    });

    // helper methods from Oh The Biomes Weve Gone
    public static final Map<String, Pair<Map<String, String>, Wrapped<List<List<ResourceKey<Biome>>>>>> BIOME_LAYOUTS = new HashMap<>();

    protected static Wrapped<List<List<ResourceKey<Biome>>>> create(String id, String header, ResourceKey<Biome>[][] biomeKeys) {
        return create(id, biomeKeys, ImmutableMap.of("", JanksonUtil.HEADER_OPEN + "\n" + header + "*/"));
    }

    protected static Wrapped<List<List<ResourceKey<Biome>>>> create(String id, ResourceKey<Biome>[][] biomeKeys) {
        return create(id, biomeKeys, new HashMap<>());
    }
}

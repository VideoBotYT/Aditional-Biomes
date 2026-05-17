package net.videobot.additional_biomes.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.videobot.additional_biomes.AdditionalBiomesMod;

public class ABTags {
    public static final TagKey<Biome> FOREST = create("forest");
    public static final TagKey<Biome> FLORAL = create("floral");

    private static TagKey<Biome> create(String name) {
        return TagKey.create(Registries.BIOME, AdditionalBiomesMod.id(name));
    }
}

package net.videobot.additional_biomes.worldgen.tree;

import net.minecraft.world.level.block.grower.TreeGrower;
import net.videobot.additional_biomes.AdditionalBiomesMod;
import net.videobot.additional_biomes.worldgen.ModConfiguredFeatures;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower BLOODWOOD = new TreeGrower(AdditionalBiomesMod.MODID + ":bloodwood",
            Optional.empty(), Optional.of(ModConfiguredFeatures.BLOODWOOD_KEY), Optional.empty());
}

package net.videobot.additional_biomes.worldgen;

import dev.corgitaco.ohthetreesyoullgrow.world.level.levelgen.feature.TYGFeatures;
import dev.corgitaco.ohthetreesyoullgrow.world.level.levelgen.feature.configurations.TreeFromStructureNBTConfig;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.BiasedToBottomInt;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.videobot.additional_biomes.AdditionalBiomesMod;
import net.videobot.additional_biomes.block.ModBlocks;

import java.util.Set;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLOODWOOD_KEY = registerKey("bloodwood");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context){
        register(context, BLOODWOOD_KEY, TYGFeatures.TREE_FROM_NBT_V1.get(),
                new TreeFromStructureNBTConfig.Builder()
                        .baseLocation(AdditionalBiomesMod.id("features/trees/bloodwood/bloodwood_trunk1"))
                        .canopyLocation(AdditionalBiomesMod.id("features/trees/bloodwood/bloodwood_canopy1"))
                        .height(ConstantInt.of(7))
                        .logProvider(BlockStateProvider.simple(ModBlocks.BLOODWOOD_LOG.get()))
                        .leavesProvider(BlockStateProvider.simple(ModBlocks.BLOODWOOD_LEAVES.get()))
                        .logTarget(Set.of(Blocks.OAK_LOG))
                        .leavesTarget(Set.of(Blocks.OAK_LEAVES))
                        .growableOn(BlockPredicate.matchesTag(BlockTags.DIRT))
                        .build()
        );
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(AdditionalBiomesMod.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

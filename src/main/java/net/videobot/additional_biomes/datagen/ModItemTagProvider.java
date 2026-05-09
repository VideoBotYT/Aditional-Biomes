package net.videobot.additional_biomes.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.videobot.additional_biomes.AdditionalBiomesMod;
import net.videobot.additional_biomes.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, AdditionalBiomesMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.BLOODWOOD_LOG.get().asItem())
                .add(ModBlocks.BLOODWOOD_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_BLOODWOOD_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_BLOODWOOD_WOOD.get().asItem());
    }
}

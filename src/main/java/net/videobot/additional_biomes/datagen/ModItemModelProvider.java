package net.videobot.additional_biomes.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.videobot.additional_biomes.AdditionalBiomesMod;
import net.videobot.additional_biomes.block.ModBlocks;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AdditionalBiomesMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        saplingItem(ModBlocks.BLOODWOOD_SAPLING);
    }

    private ItemModelBuilder saplingItem(DeferredBlock<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(AdditionalBiomesMod.MODID,"block/" + item.getId().getPath()));
    }
}

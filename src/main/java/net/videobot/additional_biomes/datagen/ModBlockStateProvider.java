package net.videobot.additional_biomes.datagen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.videobot.additional_biomes.AdditionalBiomesMod;
import net.videobot.additional_biomes.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, AdditionalBiomesMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        logBlock(((RotatedPillarBlock) ModBlocks.BLOODWOOD_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.BLOODWOOD_WOOD.get()), blockTexture(ModBlocks.BLOODWOOD_LOG.get()), blockTexture(ModBlocks.BLOODWOOD_LOG.get()));
        logBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_BLOODWOOD_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_BLOODWOOD_WOOD.get()), blockTexture(ModBlocks.STRIPPED_BLOODWOOD_LOG.get()), blockTexture(ModBlocks.STRIPPED_BLOODWOOD_LOG.get()));

        blockItem(ModBlocks.BLOODWOOD_LOG);
        blockItem(ModBlocks.BLOODWOOD_WOOD);
        blockItem(ModBlocks.STRIPPED_BLOODWOOD_LOG);
        blockItem(ModBlocks.STRIPPED_BLOODWOOD_WOOD);

        leavesBlock(ModBlocks.BLOODWOOD_LEAVES);
        saplingBlock(ModBlocks.BLOODWOOD_SAPLING);
    }

    private void leavesBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void saplingBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("additionalbiomes:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("additionalbiomes:block/" + deferredBlock.getId().getPath() + appendix));
    }
}

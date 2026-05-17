package net.videobot.additional_biomes.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.videobot.additional_biomes.block.ModBlocks;
import net.videobot.additional_biomes.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLOODWOOD_WOOD.get())
                .pattern("BB")
                .pattern("BB")
                .define('B', ModBlocks.BLOODWOOD_LOG.get())
                .unlockedBy("has_bloodwood_log", has(ModBlocks.BLOODWOOD_LOG)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLOODWOOD_LOG.get(), 4)
                .requires(ModBlocks.BLOODWOOD_WOOD.get())
                .unlockedBy("had_bloodwood_wood", has(ModBlocks.BLOODWOOD_WOOD)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_BLOODWOOD_WOOD.get())
                .pattern("BB")
                .pattern("BB")
                .define('B', ModBlocks.STRIPPED_BLOODWOOD_LOG.get())
                .unlockedBy("has_stripped_bloodwood_log", has(ModBlocks.STRIPPED_BLOODWOOD_LOG)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_BLOODWOOD_LOG.get(), 4)
                .requires(ModBlocks.STRIPPED_BLOODWOOD_WOOD.get())
                .unlockedBy("had_stripped_bloodwood_wood", has(ModBlocks.STRIPPED_BLOODWOOD_WOOD)).save(recipeOutput);
    }
}

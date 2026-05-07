package net.videobot.additional_biomes.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
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
    }
}

package net.videobot.additional_biomes.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.videobot.additional_biomes.AdditionalBiomesMod;
import net.videobot.additional_biomes.block.ModBlocks;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(PackOutput output) {
        super(output, AdditionalBiomesMod.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("creativetab.additionalbiomes.additional_blocks", "Additional Blocks");

        addBlock(ModBlocks.BLOODWOOD_LOG, "Bloodwood Log");
        addBlock(ModBlocks.BLOODWOOD_WOOD, "Bloodwood Wood");
        addBlock(ModBlocks.STRIPPED_BLOODWOOD_LOG, "Stripped Bloodwood Log");
        addBlock(ModBlocks.STRIPPED_BLOODWOOD_WOOD, "Stripped Bloodwood Wood");
        addBlock(ModBlocks.BLOODWOOD_LEAVES, "Bloodwood Leaves");
        addBlock(ModBlocks.BLOODWOOD_SAPLING, "Bloodwood Sapling");
    }
}

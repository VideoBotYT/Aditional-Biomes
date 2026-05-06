package net.videobot.additional_biomes.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.videobot.additional_biomes.AdditionalBiomesMod;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AdditionalBiomesMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

    }
}

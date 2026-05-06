package net.videobot.additional_biomes.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.videobot.additional_biomes.AdditionalBiomesMod;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(PackOutput output) {
        super(output, AdditionalBiomesMod.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {

    }
}

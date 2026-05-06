package net.videobot.additional_biomes.item;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.videobot.additional_biomes.AdditionalBiomesMod;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AdditionalBiomesMod.MODID);

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}

package net.videobot.additional_biomes.creativetabs;

import net.neoforged.bus.api.IEventBus;
import net.videobot.additional_biomes.creativetabs.list.BlockTab;

public class CreativeList {
    public static void register(IEventBus eventBus){
        BlockTab.BLOCKTAB.register(eventBus);
    }
}

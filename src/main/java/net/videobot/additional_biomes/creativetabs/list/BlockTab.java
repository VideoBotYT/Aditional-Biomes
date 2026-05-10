package net.videobot.additional_biomes.creativetabs.list;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.videobot.additional_biomes.AdditionalBiomesMod;
import net.videobot.additional_biomes.block.ModBlocks;

import java.util.function.Supplier;

public class BlockTab {
    public static final DeferredRegister<CreativeModeTab> BLOCKTAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AdditionalBiomesMod.MODID);

    public static final Supplier<CreativeModeTab> ADDITIONAL_BLOCKS = BLOCKTAB.register("additional_blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.BLOODWOOD_LOG))
                    .title(Component.translatable("creativetab.additionalbiomes.additional_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.BLOODWOOD_LOG);
                        output.accept(ModBlocks.BLOODWOOD_WOOD);
                        output.accept(ModBlocks.STRIPPED_BLOODWOOD_LOG);
                        output.accept(ModBlocks.STRIPPED_BLOODWOOD_WOOD);
                        output.accept(ModBlocks.BLOODWOOD_LEAVES);
                        output.accept(ModBlocks.BLOODWOOD_SAPLING);
                    }).build());
}

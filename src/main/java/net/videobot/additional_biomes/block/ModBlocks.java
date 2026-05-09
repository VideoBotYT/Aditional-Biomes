package net.videobot.additional_biomes.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.ItemAbility;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.videobot.additional_biomes.AdditionalBiomesMod;
import net.videobot.additional_biomes.block.custom.ModFlammableRotatedPillarBlock;
import net.videobot.additional_biomes.item.ModItems;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(AdditionalBiomesMod.MODID);

    public static final DeferredBlock<Block> BLOODWOOD_LOG = registerBlock("bloodwood_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)) {
                @Override
                public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context,
                                                                 ItemAbility itemAbility, boolean simulate) {
                    if(context.getItemInHand().getItem() instanceof AxeItem) {
                        if(state.is(ModBlocks.BLOODWOOD_LOG)) {
                            return ModBlocks.STRIPPED_BLOODWOOD_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
                        }

                        if(state.is(ModBlocks.BLOODWOOD_WOOD)) {
                            return ModBlocks.STRIPPED_BLOODWOOD_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
                        }
                    }

                    return super.getToolModifiedState(state, context, itemAbility, simulate);
                }
            });
    public static final DeferredBlock<Block> BLOODWOOD_WOOD = registerBlock("bloodwood_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)) {
                @Override
                public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context,
                                                                 ItemAbility itemAbility, boolean simulate) {
                    if(context.getItemInHand().getItem() instanceof AxeItem) {
                        if(state.is(ModBlocks.BLOODWOOD_LOG)) {
                            return ModBlocks.STRIPPED_BLOODWOOD_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
                        }

                        if(state.is(ModBlocks.BLOODWOOD_WOOD)) {
                            return ModBlocks.STRIPPED_BLOODWOOD_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
                        }
                    }

                    return super.getToolModifiedState(state, context, itemAbility, simulate);
                }
            });

    public static final DeferredBlock<Block> STRIPPED_BLOODWOOD_LOG = registerBlock("stripped_bloodwood_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final DeferredBlock<Block> STRIPPED_BLOODWOOD_WOOD = registerBlock("stripped_bloodwood_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> BLOODWOOD_LEAVES = registerBlock("bloodwood_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

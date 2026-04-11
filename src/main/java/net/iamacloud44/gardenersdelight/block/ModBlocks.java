package net.iamacloud44.gardenersdelight.block;

import net.iamacloud44.gardenersdelight.GardenersDelight;
import net.iamacloud44.gardenersdelight.item.ModItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
        DeferredRegister.createBlocks(GardenersDelight.MOD_ID);

    public static final DeferredBlock<Block> BUTTER_BLOCK = registerBlock("butter_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.SLIME_BLOCK)));

    public static final DeferredBlock<StairBlock> DIRT_STAIRS = registerBlock("dirt_stairs",
            () -> new StairBlock(Blocks.DIRT.defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.GRASS)));

    public static final DeferredBlock<SlabBlock> DIRT_SLAB = registerBlock("dirt_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.GRASS)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItem.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}

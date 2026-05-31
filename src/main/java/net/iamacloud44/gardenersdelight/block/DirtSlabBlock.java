package net.iamacloud44.gardenersdelight.block;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.Nullable;

public class DirtSlabBlock extends SlabBlock {

    public DirtSlabBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
        if (itemAbility == ItemAbilities.SHOVEL_FLATTEN) {
            if (state.getValue(SlabBlock.TYPE) == SlabType.DOUBLE) {
                return Blocks.DIRT_PATH.defaultBlockState();
            }
            return ModBlocks.PATH_SLAB.get().defaultBlockState()
                    .setValue(SlabBlock.TYPE, state.getValue(SlabBlock.TYPE));
        }
        return null;
    }


}
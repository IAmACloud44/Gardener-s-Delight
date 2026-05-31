package net.iamacloud44.gardenersdelight.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;

public class GrowableDirtSlabBlock extends DirtSlabBlock {

    public GrowableDirtSlabBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (level.getMaxLocalRawBrightness(pos.above()) >= 9) {
            for (int i = 0; i < 4; i++) {
                BlockPos randomPos = pos.offset(
                        random.nextInt(3) - 1,
                        random.nextInt(5) - 3,
                        random.nextInt(3) - 1
                );
                BlockState randomState = level.getBlockState(randomPos);
                if (randomState.is(ModBlocks.GRASS_SLAB.get()) || randomState.is(Blocks.GRASS_BLOCK)) {
                    BlockState above = level.getBlockState(pos.above());
                    if (above.isAir() || !above.isRedstoneConductor(level, pos.above())) {
                        level.setBlockAndUpdate(pos, ModBlocks.GRASS_SLAB.get().defaultBlockState()
                                .setValue(SlabBlock.TYPE, state.getValue(SlabBlock.TYPE)));
                    }
                }
            }
        }
    }
}
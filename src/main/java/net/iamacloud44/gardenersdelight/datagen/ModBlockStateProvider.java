package net.iamacloud44.gardenersdelight.datagen;

import net.iamacloud44.gardenersdelight.GardenersDelight;
import net.iamacloud44.gardenersdelight.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, GardenersDelight.MOD_ID, exFileHelper);
    }

    @Override
    protected  void registerStatesAndModels(){
        blockWithItem(ModBlocks.BUTTER_BLOCK);

        stairsBlock(ModBlocks.DIRT_STAIRS.get(), blockTexture(Blocks.DIRT));
        slabBlock(ModBlocks.DIRT_SLAB.get(), blockTexture(Blocks.DIRT), blockTexture(Blocks.DIRT));

        blockItem(ModBlocks.DIRT_STAIRS);
        blockItem(ModBlocks.DIRT_SLAB);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll((deferredBlock.get())));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("gardenersdelight:block/"+deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("gardenersdelight:block/"+deferredBlock.getId().getPath()));
    }
}

package net.iamacloud44.gardenersdelight.datagen;

import net.iamacloud44.gardenersdelight.GardenersDelight;
import net.iamacloud44.gardenersdelight.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, GardenersDelight.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.BUTTER_BLOCK);

        slabBlock(ModBlocks.DIRT_SLAB.get(),
                blockTexture(Blocks.DIRT),
                blockTexture(Blocks.DIRT));
        slabBlock(ModBlocks.COARSE_DIRT_SLAB.get(),
                blockTexture(Blocks.COARSE_DIRT),
                blockTexture(Blocks.COARSE_DIRT));
        slabBlock(ModBlocks.ROOTED_DIRT_SLAB.get(),
                blockTexture(Blocks.ROOTED_DIRT),
                blockTexture(Blocks.ROOTED_DIRT));

        grassSlabBlock((SlabBlock) ModBlocks.GRASS_SLAB.get());
        pathSlabBlock((SlabBlock) ModBlocks.PATH_SLAB.get());

        blockItem(ModBlocks.DIRT_SLAB);
        blockItem(ModBlocks.COARSE_DIRT_SLAB);
        blockItem(ModBlocks.ROOTED_DIRT_SLAB);
        blockItem(ModBlocks.GRASS_SLAB);
    }

    private void grassSlabBlock(SlabBlock block) {
        ModelFile bottomModel = models().getExistingFile(
                ResourceLocation.fromNamespaceAndPath(GardenersDelight.MOD_ID, "block/grass_slab")
        );
        ModelFile topModel = models().getExistingFile(
                ResourceLocation.fromNamespaceAndPath(GardenersDelight.MOD_ID, "block/grass_slab_top")
        );
        ModelFile doubleModel = models().getExistingFile(
                ResourceLocation.fromNamespaceAndPath(GardenersDelight.MOD_ID, "block/grass_slab_double")
        );
        getVariantBuilder(block)
                .partialState().with(SlabBlock.TYPE, SlabType.BOTTOM).modelForState().modelFile(bottomModel).addModel()
                .partialState().with(SlabBlock.TYPE, SlabType.TOP)   .modelForState().modelFile(topModel).addModel()
                .partialState().with(SlabBlock.TYPE, SlabType.DOUBLE).modelForState().modelFile(doubleModel).addModel();
    }

    private void pathSlabBlock(SlabBlock block) {
        ModelFile bottomModel = models().withExistingParent(
                "dirt_path_slab",
                ResourceLocation.fromNamespaceAndPath(GardenersDelight.MOD_ID, "block/template_path_slab")
        );
        ModelFile topModel = models().withExistingParent(
                "dirt_path_slab_top",
                ResourceLocation.fromNamespaceAndPath(GardenersDelight.MOD_ID, "block/template_path_slab_top")
        );

        getVariantBuilder(block)
                .partialState().with(SlabBlock.TYPE, SlabType.BOTTOM).modelForState().modelFile(bottomModel).addModel()
                .partialState().with(SlabBlock.TYPE, SlabType.TOP)   .modelForState().modelFile(topModel).addModel()
                .partialState().with(SlabBlock.TYPE, SlabType.DOUBLE).modelForState().modelFile(bottomModel).addModel();
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll((deferredBlock.get())));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("gardenersdelight:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("gardenersdelight:block/" + deferredBlock.getId().getPath()));
    }
}
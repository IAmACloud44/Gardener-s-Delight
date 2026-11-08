package net.iamacloud44.gardenersdelight.datagen.client;

import net.iamacloud44.gardenersdelight.GardenersDelight;
import net.iamacloud44.gardenersdelight.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PinkPetalsBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
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
        pinkPetals(ModBlocks.CLOVER_PETALS);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll((deferredBlock.get())));
    }

    private void pinkPetals(DeferredBlock<? extends Block> block) {
        this.getVariantBuilder(block.get()).forAllStates(state -> ConfiguredModel.builder()
                .modelFile(new ModelFile
                        .UncheckedModelFile(modLoc("block/clover_petals_%s"
                        .formatted(state.getValue(PinkPetalsBlock.AMOUNT)))))
                .build());

        this.itemModels().basicItem(block.get().asItem());
    }
}
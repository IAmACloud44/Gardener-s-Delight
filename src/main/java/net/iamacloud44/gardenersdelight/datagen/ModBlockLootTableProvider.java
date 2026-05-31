package net.iamacloud44.gardenersdelight.datagen;

import net.iamacloud44.gardenersdelight.block.ModBlocks;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.BUTTER_BLOCK.get());

        add(ModBlocks.DIRT_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DIRT_SLAB.get()));
        add(ModBlocks.BUTTER_BLOCK.get(),
                block -> createSingleItemTable(Items.GOLD_INGOT));
        add(ModBlocks.COARSE_DIRT_SLAB.get(),
                block ->createSlabItemTable(ModBlocks.COARSE_DIRT_SLAB.get()));
        add(ModBlocks.ROOTED_DIRT_SLAB.get(),
                block ->createSlabItemTable(ModBlocks.ROOTED_DIRT_SLAB.get()));
        add(ModBlocks.PATH_SLAB.get(),
                block ->createSlabItemTable(ModBlocks.DIRT_SLAB.get()));
        add(ModBlocks.GRASS_SLAB.get(),
                block -> createSingleItemTableWithSilkTouch(
                        ModBlocks.GRASS_SLAB.get(),
                        ModBlocks.DIRT_SLAB.get()
                ));

        //SILK TOUCH
        add(ModBlocks.GRASS_SLAB.get(), block -> createGrassSlabTable(block));

    }
    protected LootTable.Builder createGrassSlabTable(Block block) {
        return LootTable.lootTable().withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(applyExplosionDecay(block,
                                LootItem.lootTableItem(ModBlocks.GRASS_SLAB.get())
                                        .when(hasSilkTouch())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))
                                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                .hasProperty(SlabBlock.TYPE, SlabType.DOUBLE))))
                        ))
                        .add(applyExplosionDecay(block,
                                LootItem.lootTableItem(ModBlocks.DIRT_SLAB.get())
                                        .when(hasSilkTouch().invert())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))
                                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                .hasProperty(SlabBlock.TYPE, SlabType.DOUBLE))))
                        ))
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }


}

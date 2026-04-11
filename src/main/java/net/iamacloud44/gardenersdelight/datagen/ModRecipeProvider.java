package net.iamacloud44.gardenersdelight.datagen;

import net.iamacloud44.gardenersdelight.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BUTTER_BLOCK.get())
                .pattern("B B")
                .pattern("B B")
                .pattern("BBB")
                .define('B', Items.GOLD_INGOT)
                .unlockedBy("has_gold", has(Items.GOLD_INGOT)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.GOLD_INGOT, 7)
                .requires(ModBlocks.BUTTER_BLOCK)
                .unlockedBy("has_butter_block", has(ModBlocks.BUTTER_BLOCK)).save(recipeOutput);

        stairBuilder(ModBlocks.DIRT_STAIRS.get(), Ingredient.of(Blocks.DIRT)).group("dirt")
                .unlockedBy("has_dirt", has(Blocks.DIRT)).save(recipeOutput);

        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DIRT_SLAB.get(), Blocks.DIRT);
    }
}

package net.iamacloud44.gardenersdelight.datagen.server.recipe;

import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.iamacloud44.gardenersdelight.item.ModItem;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.Items;
import net.iamacloud44.gardenersdelight.block.ModBlocks;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.RecipeCategory;


public class CraftingRecipes {

    public static void register(RecipeOutput output) {
        recipesBlocks(output);
        recipesItems(output);
    }

    private static void recipesBlocks(RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BUTTER_BLOCK.get())
                .pattern("B B")
                .pattern("B B")
                .pattern("BBB")
                .define('B', Items.GOLD_INGOT)
                .unlockedBy("has_gold", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.GOLD_INGOT, 7)
                .requires(ModBlocks.BUTTER_BLOCK)
                .unlockedBy("has_butter_block", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.BUTTER_BLOCK))
                .save(output);
    }

    private static void recipesItems(RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItem.EMPTY_CUP.get())
                .pattern("B B")
                .pattern(" B ")
                .define('B', Items.QUARTZ)
                .unlockedBy("has_quartz", InventoryChangeTrigger.TriggerInstance.hasItems(Items.QUARTZ))
                .save(output);
    }
}

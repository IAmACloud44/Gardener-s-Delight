package net.iamacloud44.gardenersdelight.datagen.recipe;

import net.iamacloud44.gardenersdelight.item.ModItem;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.Items;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;

public class CookingRecipes {

    public static final int FAST_COOKING = 100;      // 5 seconds
    public static final int NORMAL_COOKING = 200;    // 10 seconds
    public static final int SLOW_COOKING = 400;      // 20 seconds

    public static final float SMALL_EXP = 0.35F;
    public static final float MEDIUM_EXP = 1.0F;
    public static final float LARGE_EXP = 2.0F;

    public static void register(RecipeOutput output) {
        cookIngredients(output);
        cookTeas(output);
    }

    private  static void cookTeas(RecipeOutput output) {
        CookingPotRecipeBuilder.cookingPotRecipe(ModItem.PINK_TEA.get(), 1, FAST_COOKING, SMALL_EXP, ModItem.EMPTY_CUP.get())
                .addIngredient(ModItem.HOT_WATER_BUCKET)
                .addIngredient(Items.PINK_PETALS)
                .unlockedByItems("has_pink_petals", Items.PINK_PETALS)
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(output);

        CookingPotRecipeBuilder.cookingPotRecipe(ModItem.ROSE_TEA.get(), 1, FAST_COOKING, SMALL_EXP, ModItem.EMPTY_CUP.get())
                .addIngredient(ModItem.HOT_WATER_BUCKET)
                .addIngredient(Items.ROSE_BUSH)
                .unlockedByItems("has_rose_bush", Items.ROSE_BUSH)
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(output);

        CookingPotRecipeBuilder.cookingPotRecipe(ModItem.WITHER_ROSE_TEA.get(), 1, FAST_COOKING, SMALL_EXP, ModItem.EMPTY_CUP.get())
                .addIngredient(ModItem.HOT_WATER_BUCKET)
                .addIngredient(Items.WITHER_ROSE)
                .unlockedByItems("has_wither_rose", Items.WITHER_ROSE)
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(output);

        CookingPotRecipeBuilder.cookingPotRecipe(ModItem.CAMOMILE_TEA.get(), 1, FAST_COOKING, SMALL_EXP, ModItem.EMPTY_CUP.get())
                .addIngredient(ModItem.HOT_WATER_BUCKET)
                .addIngredient(Items.OXEYE_DAISY)
                .unlockedByItems("has_daisy", Items.OXEYE_DAISY)
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(output);
    }

    private static void cookIngredients(RecipeOutput output) {
        CookingPotRecipeBuilder.cookingPotRecipe(ModItem.HOT_WATER_BUCKET.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.BUCKET)
                .addIngredient(Items.WATER_BUCKET)
                .unlockedByItems("has_water_bucket", Items.WATER_BUCKET)
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .save(output);
    }
}

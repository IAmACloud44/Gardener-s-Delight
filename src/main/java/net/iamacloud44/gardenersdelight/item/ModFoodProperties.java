package net.iamacloud44.gardenersdelight.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;

public class ModFoodProperties {
    public static final FoodProperties HOT_WATER_BUCKET = new FoodProperties.Builder().usingConvertsTo(Items.BUCKET)
            .nutrition(1).saturationModifier(0.25f).build();
}

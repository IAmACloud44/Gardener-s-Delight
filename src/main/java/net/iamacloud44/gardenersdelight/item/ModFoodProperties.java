package net.iamacloud44.gardenersdelight.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;


public class ModFoodProperties {

    public static final FoodProperties WITHER_ROSE_TEA = new FoodProperties.Builder().usingConvertsTo(ModItem.EMPTY_CUP)
            .nutrition(1).saturationModifier(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.WITHER, 200, 0), 1.0F)
            .fast()
            .alwaysEdible()
            .build();

    public static final FoodProperties CAMOMILE_TEA = new FoodProperties.Builder().usingConvertsTo(ModItem.EMPTY_CUP)
            .nutrition(1).saturationModifier(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 200, 0), 1.0F)
            .fast()
            .alwaysEdible()
            .build();

    public static final FoodProperties PINK_TEA = new FoodProperties.Builder().usingConvertsTo(ModItem.EMPTY_CUP)
            .nutrition(1).saturationModifier(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 0), 1.0F)
            .fast()
            .alwaysEdible()
            .build();

    public static final FoodProperties ROSE_TEA = new FoodProperties.Builder().usingConvertsTo(ModItem.EMPTY_CUP)
            .nutrition(1).saturationModifier(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 200, 0), 1.0F)
            .fast()
            .alwaysEdible()
            .build();

    public static final FoodProperties CLOVER_TEA = new FoodProperties.Builder().usingConvertsTo(ModItem.EMPTY_CUP)
            .nutrition(1).saturationModifier(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.LUCK, 200, 0), 1.0F)
            .fast()
            .alwaysEdible()
            .build();
}

package net.iamacloud44.gardenersdelight.item;

import net.iamacloud44.gardenersdelight.GardenersDelight;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModItem {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(GardenersDelight.MOD_ID);

    //ITEMS
    public static final DeferredItem<Item> EMPTY_CUP = ITEMS.register("empty_cup",
            () -> new Item(new Item.Properties().stacksTo(16)));

    //single food items
    public static final DeferredItem<Item> HOT_WATER_BUCKET = ITEMS.register("hot_water_bucket",
            () -> new Item(new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    //TEAS
    public static final DeferredItem<Item> CAMOMILE_TEA = ITEMS.register("camomile_tea",
            () -> new Item(new Item.Properties().food(ModFoodProperties.CAMOMILE_TEA).stacksTo(16)));
    public static final DeferredItem<Item> PINK_TEA = ITEMS.register("pink_tea",
            () -> new Item(new Item.Properties().food(ModFoodProperties.PINK_TEA).stacksTo(16)));
    public static final DeferredItem<Item> ROSE_TEA = ITEMS.register("rose_tea",
            () -> new Item(new Item.Properties().food(ModFoodProperties.ROSE_TEA).stacksTo(16)));
    public static final DeferredItem<Item> WITHER_ROSE_TEA = ITEMS.register("wither_rose_tea",
            () -> new Item(new Item.Properties().food(ModFoodProperties.WITHER_ROSE_TEA).stacksTo(16)));


    public static void register(IEventBus eventBus) {ITEMS.register(eventBus);
    }
}

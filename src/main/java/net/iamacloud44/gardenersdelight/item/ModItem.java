package net.iamacloud44.gardenersdelight.item;

import net.iamacloud44.gardenersdelight.GardenersDelight;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItem {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(GardenersDelight.MOD_ID);

    //single food items
    public static final DeferredItem<Item> HOT_WATER_BUCKET = ITEMS.register("hot_water_bucket",
            () -> new Item(new Item.Properties().food(ModFoodProperties.HOT_WATER_BUCKET)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

package net.iamacloud44.gardenersdelight.item;

import net.iamacloud44.gardenersdelight.GardenersDelight;
import net.iamacloud44.gardenersdelight.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GardenersDelight.MOD_ID);

    public static final Supplier<CreativeModeTab> GARDENERS_DELIGHT_TAB
            = CREATIVE_MODE_TAB.register("gardeners_delight_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItem.HOT_WATER_BUCKET.get()))
                    .title(Component.translatable("creativetab.gardenersdelight.food"))
                    .displayItems((ItemDisplayParameters, output) -> {
                        output.accept(ModBlocks.BUTTER_BLOCK);
                        output.accept(ModBlocks.DIRT_SLABS);

                        output.accept(ModItem.HOT_WATER_BUCKET);

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}

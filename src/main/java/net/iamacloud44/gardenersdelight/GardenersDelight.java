package net.iamacloud44.gardenersdelight;

import net.iamacloud44.gardenersdelight.block.ModBlocks;
import net.iamacloud44.gardenersdelight.item.ModCreativeModeTabs;
import net.iamacloud44.gardenersdelight.item.ModItem;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.GrassColor;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(net.iamacloud44.gardenersdelight.GardenersDelight.MOD_ID)
public class GardenersDelight {
    public static final String MOD_ID = "gardenersdelight";

    public static final Logger LOGGER = LogUtils.getLogger();

    public GardenersDelight(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for mod loading
        modEventBus.addListener(this::commonSetup);
        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        ModCreativeModeTabs.register(modEventBus);

        ModItem.register(modEventBus);
        ModBlocks.register(modEventBus);

        // Register the de.iamcloud44.clouddelight.item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void clientSetup(RegisterColorHandlersEvent.Block event) {

    }

    private void commonSetup(FMLCommonSetupEvent event) {
    }

    // Add the example block de.iamcloud44.clouddelight.item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
//        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
//            event.accept(ModBlocks.BUTTER_BLOCK);
//            event.accept(ModItem.HOT_WATER_BUCKET);
//        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = GardenersDelight.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
            // Your existing slab registration
            event.register(
                    (state, level, pos, tintIndex) -> {
                        if (tintIndex == 0) {
                            return level != null && pos != null
                                    ? BiomeColors.getAverageGrassColor(level, pos)
                                    : GrassColor.getDefaultColor();
                        }
                        return -1;
                    },
                    ModBlocks.GRASS_SLAB.get()
            );
        }
        @SubscribeEvent
        public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
            event.register(
                    (stack, tintIndex) -> tintIndex == 0 ? GrassColor.getDefaultColor() : -1,
                    ModBlocks.GRASS_SLAB.get().asItem()
            );
        }
    }
}

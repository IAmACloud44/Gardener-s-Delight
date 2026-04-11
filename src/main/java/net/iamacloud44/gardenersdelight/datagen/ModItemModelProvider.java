package net.iamacloud44.gardenersdelight.datagen;

import net.iamacloud44.gardenersdelight.GardenersDelight;
import net.iamacloud44.gardenersdelight.item.ModItem;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, GardenersDelight.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItem.HOT_WATER_BUCKET.get());
    }
}

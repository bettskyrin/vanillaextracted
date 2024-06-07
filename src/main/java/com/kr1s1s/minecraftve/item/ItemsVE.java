package com.kr1s1s.minecraftve.item;

import com.kr1s1s.minecraftve.component.type.FoodComponentsVE;
import com.kr1s1s.minecraftve.VanillaExtracted;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ItemsVE {
    public static Item APPLE_PIE;
    public static Item MILK_BOTTLE;

    static {
        APPLE_PIE = register("apple_pie", new Item((new Item.Settings()).food(FoodComponentsVE.APPLE_PIE)));
        MILK_BOTTLE = register("milk_bottle", new MilkBottleItem((new Item.Settings().maxCount(16))));
    }

    public static Item register(String path, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(VanillaExtracted.MOD_ID, path), item);
    }

    public static void registerItems() {
        VanillaExtracted.LOGGER.info("Registering " + VanillaExtracted.MOD_ID + " items.");
        ItemGroupsVE.updateItemGroups();
        VanillaExtracted.LOGGER.info("Registered " + VanillaExtracted.MOD_ID + " items.");

    }
}

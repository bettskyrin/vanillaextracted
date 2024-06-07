package com.kr1s1s.minecraftve.datagen;

import com.kr1s1s.minecraftve.item.ItemsVE;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class RecipeProviderVE extends FabricRecipeProvider {
    public RecipeProviderVE(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        // Food
        // Apple Pie
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemsVE.APPLE_PIE, 1)
                .input(Items.APPLE)
                .input(Items.SUGAR)
                .input(Items.EGG)
                .criterion(FabricRecipeProvider.hasItem(Items.APPLE), conditionsFromItem(Items.APPLE))
                .offerTo(exporter);
        // Milk Bottle
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemsVE.MILK_BOTTLE, 4)
                .input(Items.GLASS_BOTTLE, 4)
                .input(Items.MILK_BUCKET)
                .criterion(FabricRecipeProvider.hasItem(Items.MILK_BUCKET), FabricRecipeProvider.conditionsFromItem(Items.MILK_BUCKET))
                .offerTo(exporter);
    }
}

package com.axperty.storagedelight;

import com.axperty.storagedelight.registry.BlockEntityTypesRegistry;
import com.axperty.storagedelight.registry.BlocksRegistry;
import com.axperty.storagedelight.registry.ItemsRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class StorageDelight implements ModInitializer {

    public static final String MOD_ID = "storagedelight";
    public static final RegistryKey<ItemGroup> ITEM_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(MOD_ID, "title"));

    @Override
    public void onInitialize() {
        System.out.println("[Storage Delight Fabric]: Registering items and blocks...");
        Registry.register(Registries.ITEM_GROUP, ITEM_GROUP, FabricItemGroup.builder()
                .displayName(Text.translatable("itemGroup.storagedelight.title"))
                .icon(() -> new ItemStack(ItemsRegistry.OAK_DRAWER.get()))
                .build());

        BlocksRegistry.registerAll();
        ItemsRegistry.registerAll();
        BlockEntityTypesRegistry.registerAll();
        System.out.println("[Storage Delight Fabric]: Items and blocks registered successfully!");
        checkFarmersDelight();
    }

    public void checkFarmersDelight() {
        System.out.println("[Storage Delight Fabric]: Checking Farmer's Delight version...");
        try {
            Class.forName("vectorwing.farmersdelight.FarmersDelight");
            System.out.println("[Storage Delight Fabric]: Farmer's Delight Refabricated is loaded.");
        } catch (Exception ignored) {
            System.out.println("[Storage Delight Fabric]: Farmer's Delight [Fabric] has been archived and it will not receive updates anymore, please update to Farmer's Delight Refabricated.");
        }
    }
}
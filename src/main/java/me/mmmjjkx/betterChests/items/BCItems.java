package me.mmmjjkx.betterChests.items;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.mmmjjkx.betterChests.BetterChests;
import me.mmmjjkx.betterChests.items.chests.OnlyInputChest;
import me.mmmjjkx.betterChests.items.chests.OnlyOutputChest;
import me.mmmjjkx.betterChests.items.chests.SimpleChest;
import me.mmmjjkx.betterChests.items.machines.ChestDisassembler;
import me.mmmjjkx.betterChests.items.tools.LocationRecorder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class BCItems {
    public static final LocationRecorder LOCATION_RECORDER = new LocationRecorder(
            new SlimefunItemStack("LOCATION_RECORDER", BCItemStacks.LOCATION_RECORDER),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                    null, new ItemStack(Material.REDSTONE), null,
                    new ItemStack(Material.REDSTONE_TORCH), new ItemStack(Material.COMPASS), new ItemStack(Material.REDSTONE_TORCH),
                    null, new ItemStack(Material.REDSTONE), null
            });

    public static final SimpleChest CHEST_27 = new SimpleChest(
            27,
            new SlimefunItemStack("BC_CHEST_27", Material.CHEST, "&bSimple Chest", "&7Just a simple chest"),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                    null, null, null,
                    new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.CHEST), new ItemStack(Material.OAK_PLANKS),
                    null, null, null
            });

    public static final OnlyInputChest CHEST_INPUT_27 = new OnlyInputChest(
            27,
            new SlimefunItemStack("BC_CHEST_INPUT_27", Material.CHEST, "&bSimple Chest &c&l(Only Input)"),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                    null, new ItemStack(Material.HOPPER), null,
                    null, CHEST_27.getItem().clone(), null,
                    null, new ItemStack(Material.REDSTONE), null
            });

    public static final OnlyOutputChest CHEST_OUTPUT_27 = new OnlyOutputChest(
            27,
            new SlimefunItemStack("BC_CHEST_OUTPUT_27", Material.CHEST, "&bSimple Chest &c&l(Only Output)"),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                    null, new ItemStack(Material.REDSTONE), null,
                    null, CHEST_27.getItem().clone(), null,
                    null, new ItemStack(Material.HOPPER), null
            });
    
    public static final SimpleChest CHEST_36 = new SimpleChest(
            36,
            new SlimefunItemStack("BC_CHEST_36", Material.CHEST, "&bBig Chest", "&7Big chest"),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                    null, null, null,
                    new ItemStack(Material.OAK_PLANKS), CHEST_27.getItem().clone(), new ItemStack(Material.OAK_PLANKS),
                    null, new ItemStack(Material.IRON_INGOT), null
            });

    public static final OnlyInputChest CHEST_INPUT_36 = new OnlyInputChest(
            36,
            new SlimefunItemStack("BC_CHEST_INPUT_36", Material.CHEST, "&bBig Chest &c&l(Only Input)"),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                    null, new ItemStack(Material.HOPPER), null,
                    null, CHEST_36.getItem().clone(), null,
                    null, new ItemStack(Material.REDSTONE), null
            });

    public static final OnlyOutputChest CHEST_OUTPUT_36 = new OnlyOutputChest(
            36,
            new SlimefunItemStack("BC_CHEST_OUTPUT_36", Material.CHEST, "&bBig Chest &c&l(Only Output)"),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                    null, new ItemStack(Material.REDSTONE), null,
                    null, CHEST_36.getItem().clone(), null,
                    null, new ItemStack(Material.HOPPER), null
            });

    public static final SimpleChest CHEST_45 = new SimpleChest(
            45,
            new SlimefunItemStack("BC_CHEST_45", Material.CHEST, "&bBigger Chest", "&7Bigger chest"),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                    null, null, null,
                    new ItemStack(Material.OAK_PLANKS), CHEST_36.getItem().clone(), new ItemStack(Material.OAK_PLANKS),
                    null, new ItemStack(Material.IRON_INGOT), null
            });

    public static final OnlyInputChest CHEST_INPUT_45 = new OnlyInputChest(
            45,
            new SlimefunItemStack("BC_CHEST_INPUT_45", Material.CHEST, "&bBigger Chest &c&l(Only Input)"),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                    null, new ItemStack(Material.HOPPER), null,
                    null, CHEST_45.getItem().clone(), null,
                    null, new ItemStack(Material.REDSTONE), null
            });

    public static final OnlyOutputChest CHEST_OUTPUT_45 = new OnlyOutputChest(
            45,
            new SlimefunItemStack("BC_CHEST_OUTPUT_45", Material.CHEST, "&bBigger Chest &c&l(Only Output)"),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                    null, new ItemStack(Material.REDSTONE), null,
                    null, CHEST_45.getItem().clone(), null,
                    null, new ItemStack(Material.HOPPER), null
            });

    public static final SimpleChest CHEST_54 = new SimpleChest(
            54,
            new SlimefunItemStack("BC_CHEST_54", Material.CHEST, "&bThe Biggest Chest", "&7The biggest chest in just one block!"),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                    null, null, null,
                    new ItemStack(Material.OAK_PLANKS), CHEST_45.getItem().clone(), new ItemStack(Material.OAK_PLANKS),
                    new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT)
            });

    public static final OnlyInputChest CHEST_INPUT_54 = new OnlyInputChest(
            54,
            new SlimefunItemStack("BC_CHEST_INPUT_54", Material.CHEST, "&bThe Biggest Chest &c&l(Only Input)"),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                    null, new ItemStack(Material.HOPPER), null,
                    null, CHEST_54.getItem().clone(), null,
                    null, new ItemStack(Material.REDSTONE), null
            });

    public static final OnlyOutputChest CHEST_OUTPUT_54 = new OnlyOutputChest(
            54,
            new SlimefunItemStack("BC_CHEST_OUTPUT_54", Material.CHEST, "&bThe Biggest Chest &c&l(Only Output)"),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                    null, new ItemStack(Material.REDSTONE), null,
                    null, CHEST_54.getItem().clone(), null,
                    null, new ItemStack(Material.HOPPER), null
            });

    public static final ChestDisassembler CHEST_DISASSEMBLER = new ChestDisassembler(
            new SlimefunItemStack("BC_CHEST_DISASSEMBLER", BCItemStacks.CHEST_DISASSEMBLER),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                    null, new ItemStack(Material.IRON_AXE), null,
                    new ItemStack(Material.IRON_INGOT), new ItemStack(Material.CHEST), new ItemStack(Material.IRON_INGOT),
                    null, new ItemStack(Material.REDSTONE), null
            });

    public static void registerItems() {
        LOCATION_RECORDER.register(BetterChests.INSTANCE);

        CHEST_27.register(BetterChests.INSTANCE);
        CHEST_36.register(BetterChests.INSTANCE);
        CHEST_45.register(BetterChests.INSTANCE);
        CHEST_54.register(BetterChests.INSTANCE);

        CHEST_INPUT_27.register(BetterChests.INSTANCE);
        CHEST_INPUT_36.register(BetterChests.INSTANCE);
        CHEST_INPUT_45.register(BetterChests.INSTANCE);
        CHEST_INPUT_54.register(BetterChests.INSTANCE);

        CHEST_OUTPUT_27.register(BetterChests.INSTANCE);
        CHEST_OUTPUT_36.register(BetterChests.INSTANCE);
        CHEST_OUTPUT_45.register(BetterChests.INSTANCE);
        CHEST_OUTPUT_54.register(BetterChests.INSTANCE);

        CHEST_DISASSEMBLER.register(BetterChests.INSTANCE);
    }
}

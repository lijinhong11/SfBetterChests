package me.mmmjjkx.betterChests.items;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.mmmjjkx.betterChests.BetterChests;
import me.mmmjjkx.betterChests.items.chests.OnlyInputChest;
import me.mmmjjkx.betterChests.items.chests.OnlyOutputChest;
import me.mmmjjkx.betterChests.items.chests.SimpleChest;
import me.mmmjjkx.betterChests.items.machines.ChestDisassembler;
import me.mmmjjkx.betterChests.items.tools.ChestColorer;
import me.mmmjjkx.betterChests.items.tools.LocationRecorder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class BCItems {
    public static final LocationRecorder LOCATION_RECORDER = new LocationRecorder(
            new SlimefunItemStack("LOCATION_RECORDER", BCItemStacks.LOCATION_RECORDER),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                    null, SlimefunItems.SYNTHETIC_SAPPHIRE.clone(), null,
                    null, SlimefunItems.GPS_TRANSMITTER_3, null,
                    null, SlimefunItems.GPS_MARKER_TOOL, null
            });

    public static final SimpleChest CHEST_27 = new SimpleChest(
            27,
            new SlimefunItemStack("BC_CHEST_27", Material.GLASS, "&b&lSimple Chest"),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                    null, null, null,
                    new ItemStack(Material.OAK_PLANKS), new ItemStack(Material.CHEST), new ItemStack(Material.OAK_PLANKS),
                    null, null, null
            });

    public static final OnlyInputChest CHEST_INPUT_27 = new OnlyInputChest(
            27,
            new SlimefunItemStack("BC_CHEST_INPUT_27", Material.GLASS, "&b&lSimple Chest &c&l(Only Input)"),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                    null, new ItemStack(Material.HOPPER), null,
                    null, CHEST_27.getItem().clone(), null,
                    null, new ItemStack(Material.REDSTONE), null
            });

    public static final OnlyOutputChest CHEST_OUTPUT_27 = new OnlyOutputChest(
            27,
            new SlimefunItemStack("BC_CHEST_OUTPUT_27", Material.GLASS, "&b&lSimple Chest &c&l(Only Output)"),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                    null, new ItemStack(Material.REDSTONE), null,
                    null, CHEST_27.getItem().clone(), null,
                    null, new ItemStack(Material.HOPPER), null
            });
    
    public static final SimpleChest CHEST_36 = new SimpleChest(
            36,
            new SlimefunItemStack("BC_CHEST_36", Material.GLASS, "&b&lBig Chest"),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                    null, null, null,
                    new ItemStack(Material.OAK_PLANKS), CHEST_27.getItem().clone(), new ItemStack(Material.OAK_PLANKS),
                    null, new ItemStack(Material.IRON_INGOT), null
            });

    public static final OnlyInputChest CHEST_INPUT_36 = new OnlyInputChest(
            36,
            new SlimefunItemStack("BC_CHEST_INPUT_36", Material.GLASS, "&b&lBig Chest &c&l(Only Input)"),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                    null, new ItemStack(Material.HOPPER), null,
                    null, CHEST_36.getItem().clone(), null,
                    null, new ItemStack(Material.REDSTONE), null
            });

    public static final OnlyOutputChest CHEST_OUTPUT_36 = new OnlyOutputChest(
            36,
            new SlimefunItemStack("BC_CHEST_OUTPUT_36", Material.GLASS, "&b&lBig Chest &c&l(Only Output)"),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                    null, new ItemStack(Material.REDSTONE), null,
                    null, CHEST_36.getItem().clone(), null,
                    null, new ItemStack(Material.HOPPER), null
            });

    public static final SimpleChest CHEST_45 = new SimpleChest(
            45,
            new SlimefunItemStack("BC_CHEST_45", Material.GLASS, "&b&lBigger Chest"),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                    null, null, null,
                    new ItemStack(Material.OAK_PLANKS), CHEST_36.getItem().clone(), new ItemStack(Material.OAK_PLANKS),
                    null, new ItemStack(Material.IRON_INGOT), null
            });

    public static final OnlyInputChest CHEST_INPUT_45 = new OnlyInputChest(
            45,
            new SlimefunItemStack("BC_CHEST_INPUT_45", Material.GLASS, "&b&lBigger Chest &c&l(Only Input)"),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                    null, new ItemStack(Material.HOPPER), null,
                    null, CHEST_45.getItem().clone(), null,
                    null, new ItemStack(Material.REDSTONE), null
            });

    public static final OnlyOutputChest CHEST_OUTPUT_45 = new OnlyOutputChest(
            45,
            new SlimefunItemStack("BC_CHEST_OUTPUT_45", Material.GLASS, "&b&lBigger Chest &c&l(Only Output)"),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                    null, new ItemStack(Material.REDSTONE), null,
                    null, CHEST_45.getItem().clone(), null,
                    null, new ItemStack(Material.HOPPER), null
            });

    public static final SimpleChest CHEST_54 = new SimpleChest(
            54,
            new SlimefunItemStack("BC_CHEST_54", Material.GLASS, "&b&lThe Biggest Chest"),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                    null, null, null,
                    new ItemStack(Material.OAK_PLANKS), CHEST_45.getItem().clone(), new ItemStack(Material.OAK_PLANKS),
                    new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT)
            });

    public static final OnlyInputChest CHEST_INPUT_54 = new OnlyInputChest(
            54,
            new SlimefunItemStack("BC_CHEST_INPUT_54", Material.GLASS, "&b&lThe Biggest Chest &c&l(Only Input)"),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                    null, new ItemStack(Material.HOPPER), null,
                    null, CHEST_54.getItem().clone(), null,
                    null, new ItemStack(Material.REDSTONE), null
            });

    public static final OnlyOutputChest CHEST_OUTPUT_54 = new OnlyOutputChest(
            54,
            new SlimefunItemStack("BC_CHEST_OUTPUT_54", Material.GLASS, "&b&lThe Biggest Chest &c&l(Only Output)"),
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
                    new ItemStack(Material.IRON_INGOT), new ItemStack(Material.GLASS), new ItemStack(Material.IRON_INGOT),
                    null, new ItemStack(Material.REDSTONE), null
            });

    public static final ChestColorer CHEST_COLORER = new ChestColorer(
            new SlimefunItemStack("BC_CHEST_COLORER", BCItemStacks.CHEST_COLOR_CHANGER),
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                    null, new ItemStack(Material.GLASS), null,
                    new ItemStack(Material.WHITE_DYE), new ItemStack(Material.STICK), new ItemStack(Material.BLUE_DYE),
                    new ItemStack(Material.RED_DYE), new ItemStack(Material.REDSTONE_BLOCK), new ItemStack(Material.YELLOW_DYE)
            });

    public static void registerItems() {
        LOCATION_RECORDER.register(BetterChests.INSTANCE);
        CHEST_COLORER.register(BetterChests.INSTANCE);

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

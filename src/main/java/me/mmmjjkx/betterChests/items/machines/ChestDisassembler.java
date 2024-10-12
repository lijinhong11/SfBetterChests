package me.mmmjjkx.betterChests.items.machines;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.mmmjjkx.betterChests.BCGroups;
import me.mmmjjkx.betterChests.items.BCItems;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ChestDisassembler extends AContainer {
    public ChestDisassembler(SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(BCGroups.MAIN, item, recipeType, recipe);

        setProcessingSpeed(1);
    }

    @Override
    protected void registerDefaultRecipes() {
        registerRecipe(5,
                new ItemStack[]{BCItems.CHEST_INPUT_27.getItem().clone()},
                new ItemStack[]{
                        new ItemStack(Material.CHEST, 1),
                        new ItemStack(Material.HOPPER, 1)
        });

        registerRecipe(5,
                new ItemStack[]{BCItems.CHEST_INPUT_36.getItem().clone()},
                new ItemStack[]{
                        new ItemStack(Material.CHEST, 1),
                        new ItemStack(Material.HOPPER, 1)
        });

        registerRecipe(5,
                new ItemStack[]{BCItems.CHEST_INPUT_45.getItem().clone()},
                new ItemStack[]{
                        new ItemStack(Material.CHEST, 1),
                        new ItemStack(Material.HOPPER, 1)
        });

        registerRecipe(5,
                new ItemStack[]{BCItems.CHEST_INPUT_54.getItem().clone()},
                new ItemStack[]{
                        new ItemStack(Material.CHEST, 1),
                        new ItemStack(Material.HOPPER, 1)
        });

        registerRecipe(5,
                new ItemStack[]{BCItems.CHEST_OUTPUT_27.getItem().clone()},
                new ItemStack[]{
                        new ItemStack(Material.CHEST, 1),
                        new ItemStack(Material.HOPPER, 1)
        });

        registerRecipe(5,
                new ItemStack[]{BCItems.CHEST_OUTPUT_36.getItem().clone()},
                new ItemStack[]{
                        new ItemStack(Material.CHEST, 1),
                        new ItemStack(Material.HOPPER, 1)
        });

        registerRecipe(5,
                new ItemStack[]{BCItems.CHEST_OUTPUT_45.getItem().clone()},
                new ItemStack[]{
                        new ItemStack(Material.CHEST, 1),
                        new ItemStack(Material.HOPPER, 1)
        });

        registerRecipe(5,
                new ItemStack[]{BCItems.CHEST_OUTPUT_54.getItem().clone()},
                new ItemStack[]{
                        new ItemStack(Material.CHEST, 1),
                        new ItemStack(Material.HOPPER, 1)
        });
    }

    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.DIAMOND_AXE);
    }

    @Override
    public @NotNull String getMachineIdentifier() {
        return getId();
    }

    @Override
    public int getCapacity() {
        return 128;
    }

    @Override
    public int getEnergyConsumption() {
        return 16;
    }
}

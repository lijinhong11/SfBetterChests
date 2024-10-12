package me.mmmjjkx.betterChests.items.chests;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.mmmjjkx.betterChests.BCGroups;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.interfaces.InventoryBlock;
import org.bukkit.inventory.ItemStack;

import java.util.stream.IntStream;

@SuppressWarnings("deprecation")
public class SimpleChest extends SlimefunItem implements InventoryBlock {
    private final int size;

    public SimpleChest(int size, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(BCGroups.MAIN, item, recipeType, recipe);

        this.size = size;

        createPreset(this, bmp -> bmp.setSize(size));
    }

    @Override
    public int[] getInputSlots() {
        return IntStream.range(0, size).toArray();
    }

    @Override
    public int[] getOutputSlots() {
        return getInputSlots();
    }
}

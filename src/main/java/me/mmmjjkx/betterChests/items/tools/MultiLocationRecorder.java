package me.mmmjjkx.betterChests.items.tools;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import me.mmmjjkx.betterChests.BCGroups;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class MultiLocationRecorder extends SimpleSlimefunItem<ItemUseHandler> implements NotPlaceable {
    public MultiLocationRecorder(SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(BCGroups.TOOLS, item, recipeType, recipe);
    }

    @Override
    public @NotNull ItemUseHandler getItemHandler() {
        return e -> {
            Player p = e.getPlayer();
            boolean gui = !p.isSneaking();
            if (gui) {
                // TODO: Implement GUI
            } else {
                // TODO: Implement recording
            }
        };
    }
}

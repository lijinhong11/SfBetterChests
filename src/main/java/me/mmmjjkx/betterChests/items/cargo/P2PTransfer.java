package me.mmmjjkx.betterChests.items.cargo;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockPlaceHandler;
import me.mmmjjkx.betterChests.BCGroups;
import org.bukkit.block.BlockFace;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class P2PTransfer extends SlimefunItem {
    public P2PTransfer(SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(BCGroups.CARGO, item, recipeType, recipe);

        addItemHandler(new BlockPlaceHandler(false) {
            @Override
            public void onPlayerPlace(@NotNull BlockPlaceEvent e) {
                BlockFace f = e.getPlayer().getFacing();
                BlockFace dest = f.getOppositeFace();
            }
        });
    }
}

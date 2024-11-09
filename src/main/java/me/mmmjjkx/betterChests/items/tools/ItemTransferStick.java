package me.mmmjjkx.betterChests.items.tools;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/*
Plan:
Transfer items from fluffymachine's barrel / IE storage / drawer / BC's IE-like storage / networks' quantum storage to ...
 */

public class ItemTransferStick extends SimpleSlimefunItem<ItemUseHandler> implements NotPlaceable {
    public ItemTransferStick(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public @NotNull ItemUseHandler getItemHandler() {
        return e -> {
            e.cancel();

            Player p = e.getPlayer();
            boolean taking = !p.isSneaking();
            // TODO: Implement transfer logic
        };
    }

    private void transferItems(ItemStack current, SlimefunItem destination) {
        // TODO: Implement transfer logic
    }
}

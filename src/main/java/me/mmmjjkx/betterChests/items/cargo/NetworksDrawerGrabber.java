package me.mmmjjkx.betterChests.items.cargo;

import io.github.sefiraat.networks.NetworkStorage;
import io.github.sefiraat.networks.network.NodeDefinition;
import io.github.sefiraat.networks.slimefun.network.NetworkGrabber;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.mmmjjkx.betterChests.BCGroups;
import me.mmmjjkx.betterChests.items.chests.SimpleDrawer;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class NetworksDrawerGrabber extends NetworkGrabber {
    public NetworksDrawerGrabber(SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(BCGroups.CARGO, item, recipeType, recipe);
    }

    @Override
    protected void onTick(@Nullable BlockMenu blockMenu, @Nonnull Block block) {
        super.onTick(blockMenu, block);
        if (blockMenu != null) {
            this.tryGrabItem(blockMenu);
        }
    }

    private void tryGrabItem(@Nonnull BlockMenu blockMenu) {
        NodeDefinition definition = NetworkStorage.getAllNetworkObjects().get(blockMenu.getLocation());
        if (definition != null && definition.getNode() != null) {
            BlockFace direction = this.getCurrentDirection(blockMenu);
            Location loc = blockMenu.getBlock().getRelative(direction).getLocation();
            SlimefunItem target = BlockStorage.check(loc);
            if (target instanceof SimpleDrawer d) {
                long max = Math.min(d.getStoringItemCount(loc), 64);
                ItemStack stack = d.takeItem(loc, (int) max);
                if (stack != null) {
                    definition.getNode().getRoot().addItemStack(stack);
                    if (stack.getAmount() > 0) {
                        d.addItem(loc, stack);
                    }
                }
            }
        }
    }
}

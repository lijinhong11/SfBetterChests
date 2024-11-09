package me.mmmjjkx.betterChests.items.cargo;

import io.github.sefiraat.networks.NetworkStorage;
import io.github.sefiraat.networks.network.NodeDefinition;
import io.github.sefiraat.networks.network.stackcaches.ItemRequest;
import io.github.sefiraat.networks.slimefun.network.NetworkPusher;
import io.github.sefiraat.networks.utils.StackUtils;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import it.unimi.dsi.fastutil.Pair;
import me.mmmjjkx.betterChests.BCGroups;
import me.mmmjjkx.betterChests.items.chests.SimpleDrawer;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class NetworksDrawerPusher extends NetworkPusher {
    public NetworksDrawerPusher(SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(BCGroups.CARGO, item, recipeType, recipe);
    }

    @Override
    protected void onTick(@Nullable BlockMenu blockMenu, @Nonnull Block block) {
        super.onTick(blockMenu, block);
        if (blockMenu != null) {
            this.tryPushItem(blockMenu);
        }
    }

    private void tryPushItem(@Nonnull BlockMenu blockMenu) {
        final NodeDefinition definition = NetworkStorage.getAllNetworkObjects().get(blockMenu.getLocation());

        if (definition == null || definition.getNode() == null) {
            return;
        }

        final BlockFace direction = getCurrentDirection(blockMenu);
        final Location loc = blockMenu.getBlock().getRelative(direction).getLocation();
        final SlimefunItem target = BlockStorage.check(loc);

        if (target == null) {
            return;
        }

        if (!(target instanceof SimpleDrawer d)) {
            return;
        }

        for (int itemSlot : this.getItemSlots()) {
            final ItemStack testItem = blockMenu.getItemInSlot(itemSlot);

            if (testItem == null || testItem.getType() == Material.AIR) {
                continue;
            }

            final ItemStack clone = testItem.clone();
            clone.setAmount(1);
            final ItemRequest itemRequest = new ItemRequest(clone, clone.getMaxStackSize());

            final ItemStack itemStack = d.getStoringItem(loc);
            if (!StackUtils.itemsMatch(itemRequest.getItemStack(), itemStack)) {
                return;
            }

            ItemStack retrieved = definition.getNode().getRoot().getItemStack(itemRequest);
            if (retrieved != null) {
                Pair<Boolean, Integer> result = d.addItem(loc, retrieved);
                if (definition.getNode().getRoot().isDisplayParticles()) {
                    showParticle(blockMenu.getLocation(), direction);
                }

                if (!result.first() || result.second() > 0) {
                    definition.getNode().getRoot().addItemStack(retrieved);
                }
            }
            break;
        }
    }
}

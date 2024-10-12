package me.mmmjjkx.betterChests;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import me.mmmjjkx.betterChests.items.BCItemStacks;
import org.bukkit.NamespacedKey;

public class BCGroups {
    private static final NamespacedKey MAIN_KEY = new NamespacedKey(BetterChests.INSTANCE, "group_main");

    public static final ItemGroup MAIN = new ItemGroup(MAIN_KEY, BCItemStacks.GROUP_MAIN_ITEM);
}

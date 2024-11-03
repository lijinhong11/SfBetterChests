package me.mmmjjkx.betterChests;

import io.github.thebusybiscuit.slimefun4.api.items.groups.NestedItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import me.mmmjjkx.betterChests.items.BCItemStacks;
import org.bukkit.NamespacedKey;

public class BCGroups {
    private static final NamespacedKey MAIN_KEY = new NamespacedKey(BetterChests.INSTANCE, "group_main");
    public static final NestedItemGroup MAIN = new NestedItemGroup(MAIN_KEY, BCItemStacks.GROUP_MAIN_ITEM, 2);
    private static final NamespacedKey STORAGES_KEY = new NamespacedKey(BetterChests.INSTANCE, "group_storages");
    public static final SubItemGroup STORAGES = new SubItemGroup(STORAGES_KEY, MAIN, BCItemStacks.GROUP_STORAGE_ITEM);
    private static final NamespacedKey TOOLS_KEY = new NamespacedKey(BetterChests.INSTANCE, "group_tools");
    public static final SubItemGroup TOOLS = new SubItemGroup(TOOLS_KEY, MAIN, BCItemStacks.GROUP_TOOL_ITEM);
    private static final NamespacedKey MATERIALS_KEY = new NamespacedKey(BetterChests.INSTANCE, "group_materials");
    public static final SubItemGroup MATERIALS = new SubItemGroup(MATERIALS_KEY, MAIN, BCItemStacks.GROUP_MATERIAL_ITEM);
}

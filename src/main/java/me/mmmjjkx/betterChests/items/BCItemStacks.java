package me.mmmjjkx.betterChests.items;

import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class BCItemStacks {
    public static final ItemStack GROUP_MAIN_ITEM = new CustomItemStack(Material.CHEST, "&6&lBetter Chests");

    public static final ItemStack LOCATION_RECORDER = new CustomItemStack(Material.COMPASS, "&aLocation Recorder", "&bShift + Right-click to record location", "&bRight-click to open the corresponding machine");
    public static final ItemStack CHEST_COLOR_CHANGER = new CustomItemStack(Material.AMETHYST_SHARD, "&aChest Color Changer", "&aRight-click to change the color of the BC chest", "&aShift + Right-click to cycle through colors", "", "&dCurrent color: &6NoColor", "", LoreBuilder.powerCharged(0, 200));

    public static final ItemStack CHEST_DISASSEMBLER = new CustomItemStack(Material.YELLOW_CONCRETE, "&cChest Disassembler", LoreBuilder.powerBuffer(128), LoreBuilder.powerPerSecond(16));
}

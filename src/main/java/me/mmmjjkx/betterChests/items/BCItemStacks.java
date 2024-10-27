package me.mmmjjkx.betterChests.items;

import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class BCItemStacks {
    public static final ItemStack TIP = new CustomItemStack(Material.PAPER, "&6&lTip",
            "&c&lDon't place too many drawers in one chunk! The drawers will spawn 3 entities once they were placed.");

    public static final ItemStack GROUP_MAIN_ITEM = new CustomItemStack(Material.CHEST, "&6&lBetter Chests");

    public static final ItemStack LOCATION_RECORDER = new CustomItemStack(Material.COMPASS, "&aLocation Recorder", "&bShift + Right-click to record location", "&bRight-click to open the corresponding machine");
    public static final ItemStack CHEST_COLOR_CHANGER = new CustomItemStack(Material.AMETHYST_SHARD, "&aChest Color Changer", "&aRight-click to change the color of the BC chest", "&aShift + Right-click to cycle through colors", "", "&dCurrent color: &6NoColor", "", LoreBuilder.powerCharged(0, 200));

    public static final ItemStack CHEST_DISASSEMBLER = new CustomItemStack(Material.YELLOW_CONCRETE, "&cChest Disassembler", "&e&lDisassemble BC chests", LoreBuilder.powerBuffer(128), LoreBuilder.powerPerSecond(16));

    public static final ItemStack DRAWER_1 = new CustomItemStack(Material.BARREL, "&aDrawer &6Lvl 1", "&bRight-click grab 64 items (when your hand is empty)", "&bRight-click to store items that you hand in", "&dCapacity: 1024");
    public static final ItemStack DRAWER_2 = new CustomItemStack(Material.BARREL, "&aDrawer &6Lvl 2", "&bRight-click grab 64 items (when your hand is empty)", "&bRight-click to store items that you hand in", "&dCapacity: 4096");
    public static final ItemStack DRAWER_3 = new CustomItemStack(Material.BARREL, "&aDrawer &6Lvl 3", "&bRight-click grab 64 items (when your hand is empty)", "&bRight-click to store items that you hand in", "&dCapacity: 16384");
    public static final ItemStack DRAWER_4 = new CustomItemStack(Material.BARREL, "&aDrawer &6Lvl 4", "&bRight-click grab 64 items (when your hand is empty)", "&bRight-click to store items that you hand in", "&dCapacity: 262K");
    public static final ItemStack DRAWER_5 = new CustomItemStack(Material.BARREL, "&aDrawer &6Lvl 5", "&bRight-click grab 64 items (when your hand is empty)", "&bRight-click to store items that you hand in", "&dCapacity: 1M");
    public static final ItemStack DRAWER_6 = new CustomItemStack(Material.BARREL, "&aDrawer &6Lvl 6", "&bRight-click grab 64 items (when your hand is empty)", "&bRight-click to store items that you hand in", "&dCapacity: 4M");
    public static final ItemStack DRAWER_7 = new CustomItemStack(Material.BARREL, "&aDrawer &6Lvl 7", "&bRight-click grab 64 items (when your hand is empty)", "&bRight-click to store items that you hand in", "&dCapacity: 16M");
    public static final ItemStack DRAWER_8 = new CustomItemStack(Material.BARREL, "&aDrawer &6Lvl 8", "&bRight-click grab 64 items (when your hand is empty)", "&bRight-click to store items that you hand in", "&dCapacity: 64M");
    public static final ItemStack DRAWER_9 = new CustomItemStack(Material.BARREL, "&aDrawer &6Lvl 9", "&bRight-click grab 64 items (when your hand is empty)", "&bRight-click to store items that you hand in", "&dCapacity: 256M");
    public static final ItemStack DRAWER_10 = new CustomItemStack(Material.BARREL, "&aDrawer &6Lvl 10", "&bRight-click grab 64 items (when your hand is empty)", "&bRight-click to store items that you hand in", "&dCapacity: 1B");
    public static final ItemStack DRAWER_MAX = new CustomItemStack(Material.BARREL, "&aDrawer &6MAX", "&bRight-click grab 64 items (when your hand is empty)", "&bRight-click to store items that you hand in", "&dCapacity: 2.14B");
}

package me.mmmjjkx.betterChests.items;

import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactivity;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import me.mmmjjkx.betterChests.BetterChests;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class BCItemStacks {
    public static final ItemStack TIP = new CustomItemStack(Material.PAPER, BetterChests.INSTANCE.getLang().getMsg("items.tip.name"),
            BetterChests.INSTANCE.getLang().getMsgList("items.tip.lore"));

    public static final ItemStack GROUP_MAIN_ITEM = new CustomItemStack(Material.CHEST, BetterChests.INSTANCE.getLang().getMsg("groups.main"));
    public static final ItemStack GROUP_STORAGE_ITEM = new CustomItemStack(Material.BARREL, BetterChests.INSTANCE.getLang().getMsg("groups.storages"));
    public static final ItemStack GROUP_TOOL_ITEM = new CustomItemStack(Material.BLAZE_ROD, BetterChests.INSTANCE.getLang().getMsg("groups.tool_machines"));
    public static final ItemStack GROUP_MATERIAL_ITEM = new CustomItemStack(Material.IRON_INGOT, BetterChests.INSTANCE.getLang().getMsg("groups.materials"));
    public static final ItemStack GROUP_CARGO_ITEM = new CustomItemStack(Material.CHEST, BetterChests.INSTANCE.getLang().getMsg("groups.cargo"));

    public static final ItemStack GEAR_WHEEL = new CustomItemStack(Material.REDSTONE, BetterChests.INSTANCE.getLang().getMsg("items.gear_wheel.name"), BetterChests.INSTANCE.getLang().getMsg("items.gear_wheel.lore"));
    public static final ItemStack TIGHTLY_BLISTERING_INGOT = new CustomItemStack(Material.IRON_INGOT, BetterChests.INSTANCE.getLang().getMsg("items.tightly_blistering_ingot.name"), BetterChests.INSTANCE.getLang().getMsg("items.tightly_blistering_ingot.lore"), LoreBuilder.radioactive(Radioactivity.VERY_HIGH));
    public static final ItemStack TIGHTLY_BLISTERING_PLATE = new CustomItemStack(Material.IRON_BLOCK, "&eTightly Blistering Plate", "&7A high-hardness metal plate", LoreBuilder.radioactive(Radioactivity.HIGH));

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

    public static final ItemStack IE_STORAGE_UNIT_1 = new CustomItemStack(Material.OAK_LOG, "&eIE Storage Unit &6Lvl 1", "&bInfinityExpansion-like storage unit", "&dCapacity: 32,000");
    public static final ItemStack IE_STORAGE_UNIT_2 = new CustomItemStack(Material.DARK_OAK_LOG, "&eIE Storage Unit &6Lvl 2", "&bInfinityExpansion-like storage unit", "&dCapacity: 128,000");
    public static final ItemStack IE_STORAGE_UNIT_3 = new CustomItemStack(Material.ACACIA_LOG, "&eIE Storage Unit &6Lvl 3", "&bInfinityExpansion-like storage unit", "&dCapacity: 1,000,000");
    public static final ItemStack IE_STORAGE_UNIT_4 = new CustomItemStack(Material.BIRCH_LOG, "&eIE Storage Unit &6Lvl 4", "&bInfinityExpansion-like storage unit", "&dCapacity: 4,000,000");
    public static final ItemStack IE_STORAGE_UNIT_5 = new CustomItemStack(Material.JUNGLE_LOG, "&eIE Storage Unit &6Lvl 5", "&bInfinityExpansion-like storage unit", "&dCapacity: 64,000,000");
    public static final ItemStack IE_STORAGE_UNIT_6 = new CustomItemStack(Material.MANGROVE_LOG, "&eIE Storage Unit &6Lvl 6", "&bInfinityExpansion-like storage unit", "&dCapacity: 256,000,000");
    public static final ItemStack IE_STORAGE_UNIT_7 = new CustomItemStack(Material.CRIMSON_STEM, "&eIE Storage Unit &6Lvl 7", "&bInfinityExpansion-like storage unit", "&dCapacity: 1,000,000,000");
    public static final ItemStack IE_STORAGE_UNIT_8 = new CustomItemStack(Material.WARPED_STEM, "&eIE Storage Unit &6Lvl 8", "&bInfinityExpansion-like storage unit", "&dCapacity: 2,140,000,000");

    public static final ItemStack POINT_TO_POINT_TRANSFER = new CustomItemStack(Material.END_ROD, "&aPoint-to-Point Transfer", "&b&lA great tool for transferring items between two blocks");
}

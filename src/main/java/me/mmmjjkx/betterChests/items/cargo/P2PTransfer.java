package me.mmmjjkx.betterChests.items.cargo;

import io.github.bakedlibs.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockPlaceHandler;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mmmjjkx.betterChests.BCGroups;
import me.mmmjjkx.betterChests.BetterChests;
import me.mmmjjkx.betterChests.items.chests.SimpleDrawer;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ClickAction;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.interfaces.InventoryBlock;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@SuppressWarnings("deprecation")
public class P2PTransfer extends SlimefunItem implements InventoryBlock {
    private final BlockFace[] FACES = {BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST, BlockFace.UP, BlockFace.DOWN, BlockFace.SELF};

    private final List<Integer> TAKEN_SLOTS = List.of(0,18,1,19,9,11,10);

    private final ItemStack UP = new CustomItemStack(Material.PURPLE_STAINED_GLASS_PANE, BetterChests.INSTANCE.getLang().getMsg("items.p2p_transfer.up"));
    private final ItemStack DOWN = new CustomItemStack(Material.PURPLE_STAINED_GLASS_PANE, BetterChests.INSTANCE.getLang().getMsg("items.p2p_transfer.down"));
    private final ItemStack WEST = new CustomItemStack(Material.PURPLE_STAINED_GLASS_PANE, BetterChests.INSTANCE.getLang().getMsg("items.p2p_transfer.west"));
    private final ItemStack EAST = new CustomItemStack(Material.PURPLE_STAINED_GLASS_PANE, BetterChests.INSTANCE.getLang().getMsg("items.p2p_transfer.east"));
    private final ItemStack NORTH = new CustomItemStack(Material.PURPLE_STAINED_GLASS_PANE, BetterChests.INSTANCE.getLang().getMsg("items.p2p_transfer.north"));
    private final ItemStack SOUTH = new CustomItemStack(Material.PURPLE_STAINED_GLASS_PANE, BetterChests.INSTANCE.getLang().getMsg("items.p2p_transfer.south"));
    private final ItemStack STOP_TRANSFER = new CustomItemStack(Material.RED_STAINED_GLASS_PANE, BetterChests.INSTANCE.getLang().getMsg("items.p2p_transfer.stop_transfer"));

    public P2PTransfer(SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(BCGroups.CARGO, item, recipeType, recipe);

        addItemHandler(new BlockPlaceHandler(false) {
            @Override
            public void onPlayerPlace(@NotNull BlockPlaceEvent e) {
                BlockFace f = e.getPlayer().getFacing();
                BlockFace dest = f.getOppositeFace();
                Block self = e.getBlockPlaced();
                BlockStorage.addBlockInfo(self, "p2p_dest", String.valueOf(dest.ordinal()));
                BlockStorage.addBlockInfo(self, "p2p_origin", String.valueOf(f.ordinal()));
            }
        }, new BlockBreakHandler(false, false) {
            @Override
            public void onPlayerBreak(BlockBreakEvent e, ItemStack itemStack, List<ItemStack> list) {
                Location loc = e.getBlock().getLocation();
                BlockStorage.clearBlockInfo(loc);
            }
        });

        addItemHandler(new BlockTicker() {
            @Override
            public boolean isSynchronized() {
                return false;
            }

            @Override
            public void tick(Block block, SlimefunItem slimefunItem, Config config) {
                P2PTransfer.this.tick(block);
            }
        });

        createPreset(this, bmp -> {
            bmp.addItem(0, UP, (p, s, i, a) -> {
                Location machine = p.getOpenInventory().getTopInventory().getLocation();
                setDest(machine, BlockFace.UP);
                return false;
            });
            bmp.addItem(18, DOWN, new ChestMenu.AdvancedMenuClickHandler() {
                @Override
                public boolean onClick(Player player, int i, ItemStack itemStack, ClickAction clickAction) {
                    return false;
                }

                @Override
                public boolean onClick(InventoryClickEvent e, Player player, int i, ItemStack itemStack, ClickAction clickAction) {
                    Location machine = e.getInventory().getLocation();
                    setDest(machine, BlockFace.DOWN);
                    return false;
                }
            });
            bmp.addItem(1, NORTH, (p, s, i, a) -> {
                Location machine = p.getOpenInventory().getTopInventory().getLocation();
                setDest(machine, BlockFace.NORTH);
                return false;
            });
            bmp.addItem(19, SOUTH, (p, s, i, a) -> {
                Location machine = p.getOpenInventory().getTopInventory().getLocation();
                setDest(machine, BlockFace.SOUTH);
                return false;
            });
            bmp.addItem(9, WEST, (p, s, i, a) -> {
                Location machine = p.getOpenInventory().getTopInventory().getLocation();
                setDest(machine, BlockFace.WEST);
                return false;
            });
            bmp.addItem(11, EAST, new ChestMenu.AdvancedMenuClickHandler() {
                @Override
                public boolean onClick(InventoryClickEvent e, Player player, int i, ItemStack itemStack, ClickAction clickAction) {
                    Location machine = e.getInventory().getLocation();
                    setDest(machine, BlockFace.EAST);
                    return false;
                }

                @Override
                public boolean onClick(Player player, int i, ItemStack itemStack, ClickAction clickAction) {
                    return false;
                }
            });
            bmp.addItem(10, STOP_TRANSFER, (p, s, i, a) -> {
                Location machine = p.getOpenInventory().getTopInventory().getLocation();
                setDest(machine, BlockFace.SELF);
                return false;
            });

            for (int t : IntStream.range(0, 27).filter(i -> !TAKEN_SLOTS.contains(i)).toArray()) {
                bmp.addItem(t, ChestMenuUtils.getBackground(), (p, s, i, a) -> false);
            }
        });
    }

    private void tick(Block block) {
        BlockMenu menu = BlockStorage.getInventory(block);
        if (menu == null) {
            return;
        }

        int destOrdinal = Integer.parseInt(BlockStorage.getLocationInfo(block.getLocation(), "p2p_dest"));
        BlockFace dest = FACES[destOrdinal];

        if (dest == BlockFace.SELF) {
            return;
        }

        BlockFace originOrdinal = FACES[Integer.parseInt(BlockStorage.getLocationInfo(block.getLocation(), "p2p_origin"))];
        List<ItemStack> items = new ArrayList<>();
        Block origin = block.getRelative(originOrdinal);
        SlimefunItem sfItem = BlockStorage.check(origin);
        if (sfItem instanceof InventoryBlock inv) {
            int[] out = inv.getOutputSlots();
            BlockMenu originMenu = BlockStorage.getInventory(block.getRelative(originOrdinal));
            for (int slot : out) {
                if (originMenu.getItemInSlot(slot) != null) {
                    items.add(originMenu.getItemInSlot(slot));
                }
            }
        } else if (sfItem instanceof SimpleDrawer sd) {
            items.add(sd.getStoringItem(origin.getLocation()).asQuantity(sd.getStoringItemCountSafely(origin.getLocation())));
        }

        for (ItemStack it : items) {
            SlimefunItem destSfItem = BlockStorage.check(block.getRelative(dest));
            if (destSfItem instanceof InventoryBlock destInv) {
                int[] in = destInv.getInputSlots();
                BlockMenu destMenu = BlockStorage.getInventory(block.getRelative(dest));
                for (int slot : in) {
                    if (destMenu.fits(it, slot)) {
                        destMenu.pushItem(it, slot);
                        menu.consumeItem(slot, it.getAmount());
                    }
                }
            } else if (destSfItem instanceof SimpleDrawer sd) {
                sd.addItem(block.getLocation(), it);
            }
        }
    }

    private void setDest(Location loc, BlockFace face) {
        int destOrdinal = face.ordinal();
        if (face == BlockFace.SELF) {
            destOrdinal = 6;
        }
        BlockStorage.addBlockInfo(loc, "p2p_dest", String.valueOf(destOrdinal));
    }

    @Override
    public int[] getInputSlots() {
        return new int[0];
    }

    @Override
    public int[] getOutputSlots() {
        return new int[0];
    }
}

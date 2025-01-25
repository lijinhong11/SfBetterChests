package me.mmmjjkx.betterChests.items.tools;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.attributes.Rechargeable;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.data.persistent.PersistentDataAPI;
import io.github.thebusybiscuit.slimefun4.libraries.dough.protection.Interaction;
import me.mmmjjkx.betterChests.BCGroups;
import me.mmmjjkx.betterChests.BetterChests;
import me.mmmjjkx.betterChests.items.chests.SimpleChest;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

public class ChestColorer extends SimpleSlimefunItem<ItemUseHandler> implements NotPlaceable, Rechargeable {
    private static final ColorMaterials DEFAULT_COLOR = ColorMaterials.NoColor;
    private static final NamespacedKey COLOR_KEY = new NamespacedKey(BetterChests.INSTANCE, "color");

    public ChestColorer(SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(BCGroups.TOOLS, item, recipeType, recipe);
    }

    @Override
    public float getMaxItemCharge(ItemStack itemStack) {
        return 200;
    }

    @Override
    public @NotNull ItemUseHandler getItemHandler() {
        return e -> {
            e.cancel();

            Player p = e.getPlayer();
            boolean cycle = p.isSneaking();
            ItemStack item = e.getItem();

            Optional<Block> block = e.getClickedBlock();
            if (block.isPresent()) {
                if (!Slimefun.getProtectionManager().hasPermission(p, block.get(), Interaction.INTERACT_BLOCK)) {
                    p.sendMessage("§cYou don't have permission to interact with this block.");
                    return;
                }
            }

            if (cycle) {
                int index = PersistentDataAPI.getOptionalInt(item.getItemMeta(), COLOR_KEY).orElse(DEFAULT_COLOR.ordinal());

                int nextIndex = index + 1;
                if (nextIndex >= ColorMaterials.values().length) {
                    nextIndex = DEFAULT_COLOR.ordinal();
                }

                ColorMaterials color = ColorMaterials.values()[nextIndex];

                ItemMeta meta = item.getItemMeta();

                Component lore = LegacyComponentSerializer.legacyAmpersand().deserialize("&dCurrent color: &6" + color.name())
                        .decoration(TextDecoration.ITALIC, false);
                List<Component> loreList = item.lore();

                loreList.set(3, lore);

                meta.lore(loreList);

                PersistentDataAPI.setInt(meta, COLOR_KEY, nextIndex);
                item.setItemMeta(meta);

                p.sendActionBar(lore);
            } else {
                if (block.isPresent()) {
                    Block b = block.get();
                    SlimefunItem sfItem = BlockStorage.check(b);
                    if (sfItem instanceof SimpleChest) {
                        if (getItemCharge(item) >= 10) {
                            removeItemCharge(item, 10);
                            int index = PersistentDataAPI.getOptionalInt(item.getItemMeta(), COLOR_KEY).orElse(DEFAULT_COLOR.ordinal());
                            ColorMaterials color = ColorMaterials.values()[index];
                            b.setType(color.getMaterial());
                        } else {
                            p.sendMessage("§cThe item is out of charge.");
                        }
                    }
                } else {
                    p.sendMessage("§cYou need to right-click at a block to use this item.");
                }
            }
        };
    }

    private enum ColorMaterials {
        NoColor(Material.GLASS),
        White(Material.WHITE_STAINED_GLASS),
        Yellow(Material.YELLOW_STAINED_GLASS),
        Orange(Material.ORANGE_STAINED_GLASS),
        Red(Material.RED_STAINED_GLASS),
        Blue(Material.BLUE_STAINED_GLASS),
        Green(Material.GREEN_STAINED_GLASS),
        Lime(Material.LIME_STAINED_GLASS),
        Pink(Material.PINK_STAINED_GLASS),
        Purple(Material.PURPLE_STAINED_GLASS),
        Brown(Material.BROWN_STAINED_GLASS),
        Black(Material.BLACK_STAINED_GLASS),
        Gray(Material.GRAY_STAINED_GLASS),
        LightGray(Material.LIGHT_GRAY_STAINED_GLASS),
        Cyan(Material.CYAN_STAINED_GLASS),
        Magenta(Material.MAGENTA_STAINED_GLASS),
        LightBlue(Material.LIGHT_BLUE_STAINED_GLASS);

        private final Material material;

        ColorMaterials(Material material) {
            this.material = material;
        }

        public Material getMaterial() {
            return material;
        }
    }
}

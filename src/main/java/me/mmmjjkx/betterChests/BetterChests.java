package me.mmmjjkx.betterChests;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.updater.BlobBuildUpdater;
import me.mmmjjkx.betterChests.items.BCItems;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class BetterChests extends JavaPlugin implements SlimefunAddon {

    public static BetterChests INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;

        BCItems.registerItems();

        getLogger().info("BetterChests has been enabled.");

        BlobBuildUpdater updater = new BlobBuildUpdater(this, getFile(), "BetterChests");
        updater.start();
    }

    @Override
    public void onDisable() {
        getLogger().info("BetterChests has been disabled.");
    }

    @Override
    public @NotNull JavaPlugin getJavaPlugin() {
        return this;
    }

    @Override
    public String getBugTrackerURL() {
        return "https://github.com/lijinhong11/SfBetterChests/issues";
    }
}

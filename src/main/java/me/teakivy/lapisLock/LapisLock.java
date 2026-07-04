package me.teakivy.lapisLock;

import me.teakivy.lapisLock.pack.Listeners;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class LapisLock extends JavaPlugin {

    @Override
    public void onEnable() {
        if (!checkTeaksTweaks()) {
            getLogger().warning("TeaksTweaks is installed and has Lapis Lock enabled. Disabling LapisLock to avoid conflicts.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        Bukkit.getPluginManager().registerEvents(new Listeners(), this);
        getLogger().info("LapisLock has been enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static LapisLock getInstance() {
        return JavaPlugin.getPlugin(LapisLock.class);
    }

    private boolean checkTeaksTweaks() {
        Plugin tt = getServer().getPluginManager().getPlugin("TeaksTweaks");
        if (tt == null) return true;
        FileConfiguration config = tt.getConfig();
        return !config.getBoolean("packs.lapis-lock.enabled", false);
    }
}

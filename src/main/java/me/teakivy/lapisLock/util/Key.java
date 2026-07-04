package me.teakivy.lapisLock.util;

import me.teakivy.lapisLock.LapisLock;
import org.bukkit.NamespacedKey;

public class Key {
    /**
     * Get a NamespacedKey
     * @param key The key
     * @return The NamespacedKey
     */
    public static NamespacedKey get(String key) {
        return new NamespacedKey(LapisLock.getInstance(), key);
    }
}

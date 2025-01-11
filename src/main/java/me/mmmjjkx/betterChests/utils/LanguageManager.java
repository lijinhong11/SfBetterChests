package me.mmmjjkx.betterChests.utils;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.JarURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

@SuppressWarnings("deprecation")
public final class LanguageManager {
    private final Plugin plugin;

    private YamlConfiguration configuration;

    public LanguageManager(Plugin plugin) {
        this.plugin = plugin;

        loadLanguages();
    }

    private void loadLanguages() {
        File pluginFolder = plugin.getDataFolder();

        URL fileURL = Objects.requireNonNull(plugin.getClass().getClassLoader().getResource("language/"));
        String jarPath = fileURL.toString().substring(0, fileURL.toString().indexOf("!/") + 2);

        try {
            URL jar = new URL(jarPath);
            JarURLConnection jarCon = (JarURLConnection) jar.openConnection();
            JarFile jarFile = jarCon.getJarFile();
            Enumeration<JarEntry> jarEntries = jarFile.entries();

            while (jarEntries.hasMoreElements()) {
                JarEntry entry = jarEntries.nextElement();
                String name = entry.getName();
                if (name.startsWith("language/") && !entry.isDirectory()) {
                    String realName = name.replaceAll("language/", "");
                    try (InputStream stream = plugin.getClass().getClassLoader().getResourceAsStream(name)) {
                        File destinationFile = new File(pluginFolder, "language/" + realName);

                        if (!destinationFile.exists() && stream != null) {
                            plugin.saveResource("language/" + realName, false);
                        }

                        completeLangFile(plugin, "language/" + realName);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String lang = plugin.getConfig().getString("language");
        if (lang == null || lang.isBlank()) {
            lang = "en-US";
        }

        File langFile = new File(pluginFolder, "language/" + lang + ".yml");

        if (!langFile.exists()) {
            lang = "en-US";
            langFile = new File(pluginFolder, "language/" + lang + ".yml");
            if (!langFile.exists()) {
                plugin.saveResource("language/en-US.yml", false);
            }
        }

        configuration = YamlConfiguration.loadConfiguration(langFile);
    }

    public String getMsg(String key, MessageReplacement... args) {
        String msg = configuration.getString(key);
        if (msg == null) {
            return key;
        }

        for (MessageReplacement arg : args) {
            msg = arg.parse(msg);
        }

        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public List<String> getMsgList(String key, MessageReplacement... args) {
        List<String> msgList = configuration.getStringList(key);
        for (MessageReplacement arg : args) {
            msgList.replaceAll(s -> ChatColor.translateAlternateColorCodes('&', arg.parse(s)));
        }

        return msgList;
    }

    private void completeLangFile(Plugin plugin, String resourceFile) {
        InputStream stream = plugin.getResource(resourceFile);
        File file = new File(plugin.getDataFolder(), resourceFile);

        if (!file.exists()) {
            if (stream != null) {
                plugin.saveResource(resourceFile, false);
                return;
            }
            plugin.getLogger().warning("File completion of '" + resourceFile + "' is failed.");
            return;
        }

        if (stream == null) {
            plugin.getLogger().warning("File completion of '" + resourceFile + "' is failed.");
            return;
        }

        try {
            Reader reader = new InputStreamReader(stream, StandardCharsets.UTF_8);
            YamlConfiguration configuration = YamlConfiguration.loadConfiguration(reader);
            YamlConfiguration configuration2 = YamlConfiguration.loadConfiguration(file);

            Set<String> keys = configuration.getKeys(true);
            for (String key : keys) {
                Object value = configuration.get(key);
                if (value instanceof List<?>) {
                    List<?> list2 = configuration2.getList(key);
                    if (list2 == null) {
                        configuration2.set(key, value);
                        continue;
                    }
                }
                if (!configuration2.contains(key)) {
                    configuration2.set(key, value);
                }
                if (!configuration.getComments(key).equals(configuration2.getComments(key))) {
                    configuration2.setComments(key, configuration.getComments(key));
                }
            }
            for (String key : configuration2.getKeys(true)) {
                if (configuration2.contains(key) & !configuration.contains(key)) {
                    configuration2.set(key, null);
                }
            }
            configuration2.save(file);
        } catch (Exception e) {
            e.printStackTrace();
            plugin.getLogger().warning("File completion of '" + resourceFile + "' is failed.");
        }
    }
}
package com.jeancalistro.essentials.utils;

import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class FileUtil {

    public static boolean saveData(File file, Map<String, Object> data) throws IOException {
        if(!file.exists()) {
            file.createNewFile();
        }
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        for(Map.Entry<String, Object> entry: data.entrySet()) {
            config.set(entry.getKey(), entry.getValue());
        }
        config.save(file);
        return true;
    }

    public static Map<String, Object> readData(File file) {
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        return config.getValues(true);
    }

    public static boolean deleteData(File file) {
        return true;
    }

    public static String addExtension(String filename, String extension) {
        return String.format("%s.%s", filename, extension);
    }

    public static String removeExtension(String filename, String extension) {
        return filename.replaceAll(String.format(".%s", extension), "");
    }
}

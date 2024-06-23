package com.jeancalistro.essentials.utils;

import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class FileUtil {

    public static boolean saveData(File file, Map<String, Object> data) throws IOException {
        if(!file.exists()) {
            if(!file.createNewFile()) {
                throw new IOException();
            }
        }
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        for(Map.Entry<String, Object> entry: data.entrySet()) {
            config.set(entry.getKey(), entry.getValue());
        }
        config.save(file);
        return true;
    }

    public static Map<String, Object> readData(File file) throws FileNotFoundException {
        if(file.exists()) {
            YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
            return config.getValues(true);
        }
        throw new FileNotFoundException();
    }

    public static File[] listFiles(File directory) throws FileNotFoundException {
        if(directory.exists()) {
            return directory.listFiles();
        }
        throw new FileNotFoundException();
    }

    public static boolean deleteData(File file) throws FileNotFoundException {
        if(file.exists()) {
            if(file.delete()) {
                return true;
            }
        }
        throw new FileNotFoundException();
    }

    public static String addExtension(String filename, String extension) {
        return String.format("%s.%s", filename, extension);
    }

    public static String removeExtension(String filename, String extension) {
        return filename.replaceAll(String.format(".%s", extension), "");
    }
}

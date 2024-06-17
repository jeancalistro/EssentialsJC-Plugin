package com.jeancalistro.essentials.utils;

import org.yaml.snakeyaml.Yaml;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;

public class FileUtils {

    public static Map<String, Object> read(Path filePath) throws IOException {
        InputStream inputStream = Files.newInputStream(filePath, StandardOpenOption.READ);
        Yaml yaml = new Yaml();
        return yaml.load(inputStream);
    }

    public static void write(Map<String, Object> data, File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file, false);
        Yaml yaml = new Yaml();
        yaml.dump(data, fileWriter);
    }

    public static boolean exists(Path path) {
        return Files.exists(path);
    }

    public static Path createFile(String filePath, String fileName) throws IOException {
        Path path = Paths.get(filePath, fileName);
        return Files.createFile(path);
    }

    public static Path createDirectory(String directoryPath, String directoryName) throws IOException {
        Path path = Paths.get(directoryPath, directoryName);
        return Files.createDirectory(path);
    }
}

package com.github.spacemex.yamlapi;

import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.nio.file.*;
import java.util.Map;

public class YamlFileUtils {

    private static final Yaml yaml = new Yaml();

    // Create a new YAML file
    public static void makeYaml(Path directory, String name, Map<String, Object> content) throws IOException {
        if (!Files.exists(directory)) {
            Files.createDirectories(directory);
        }
        Path filePath = directory.resolve(name);
        try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
            yaml.dump(content, writer);
        }
    }

    // Load a YAML file and return content as a Map
    public static Map<String, Object> loadYaml(File yamlFile) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(yamlFile)) {
            return yaml.load(fileInputStream);
        }
    }
}
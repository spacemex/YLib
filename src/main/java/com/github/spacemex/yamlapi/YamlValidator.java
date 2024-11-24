package com.github.spacemex.yamlapi;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.ConstructorException;
import org.yaml.snakeyaml.parser.ParserException;

import java.io.InputStream;
import java.util.Map;

public class YamlValidator {

    private final Yaml yaml;

    public YamlValidator() {
        this.yaml = new Yaml();
    }

    public boolean isValidYaml(InputStream inputStream) {
        try {
            yaml.load(inputStream);
            return true;
        } catch (ParserException | ConstructorException e) {
            return false;
        }
    }

    public boolean isValidYaml(String yamlContent) {
        try {
            yaml.load(yamlContent);
            return true;
        } catch (ParserException | ConstructorException e) {
            return false;
        }
    }

    public boolean hasKey(Map<String, Object> yamlContent, String key) {
        return yamlContent.containsKey(key);
    }

    public boolean hasNestedKey(Map<String, Object> yamlContent, String... keys) {
        Map<String, Object> currentMap = yamlContent;
        boolean keyExists = true;

        for (String key : keys) {
            Object value = currentMap.get(key);

            if (value instanceof Map) {
                currentMap = (Map<String, Object>) value;
            } else {
                keyExists = false;
                break;
            }
        }

        return keyExists;
    }

    public boolean isType(Map<String, Object> yamlContent, String key, Class<?> type) {
        Object value = yamlContent.get(key);
        return value != null && type.isInstance(value);
    }
}
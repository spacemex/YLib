package com.github.spacemex.yamlapi;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.ConstructorException;
import org.yaml.snakeyaml.parser.ParserException;

import java.io.*;
import java.util.List;
import java.util.Map;

public class YamlLoader {

    private final Yaml yaml;
    private Map<String, Object> data;

    public YamlLoader() {
        this.yaml = new Yaml();
    }

    public YamlLoader(InputStream inputStream) {
        this.yaml = new Yaml();
        this.data = yaml.load(inputStream);
    }

    public YamlLoader(String yamlContent) {
        this.yaml = new Yaml();
        this.data = yaml.load(yamlContent);
    }

    public YamlLoader(File yamlFile) throws IOException {
        this.yaml = new Yaml();
        try (FileInputStream fileInputStream = new FileInputStream(yamlFile)) {
            this.data = yaml.load(fileInputStream);
        }
    }

    public Map<String, Object> loadYaml(InputStream inputStream) {
        return yaml.load(inputStream);
    }

    public Map<String, Object> loadYaml(String yamlContent) {
        return yaml.load(yamlContent);
    }

    public boolean isValidYaml(String yamlContent) {
        try {
            yaml.load(yamlContent);
            return true;
        } catch (ParserException | ConstructorException e) {
            return false;
        }
    }

    public boolean hasKey(String path) {
        return get(path) != null;
    }

    public boolean hasNestedKey(String path) {
        String[] keys = path.split("\\.");
        return getNestedValue(data, keys) != null;
    }

    public boolean isType(String path, Class<?> type) {
        Object value = get(path);
        return value != null && type.isInstance(value);
    }

    private Object getNestedValue(Map<String, Object> yamlContent, String[] keys) {
        Map<String, Object> currentMap = yamlContent;
        Object value = null;

        for (String key : keys) {
            value = currentMap.get(key);

            if (value instanceof Map) {
                currentMap = (Map<String, Object>) value;
            } else {
                break;
            }
        }

        return value;
    }

    private Object getParsedValue(String path) {
        String[] keys = path.split("\\.");
        return getNestedValue(data, keys);
    }

    public Object get(String path) {
        return getParsedValue(path);
    }

    // Integer operations
    public Integer getInt(String path) {
        Object value = getParsedValue(path);
        return value instanceof Integer ? (Integer) value : null;
    }

    public Integer getInt(String path, int defaultValue) {
        Integer value = getInt(path);
        return value != null ? value : defaultValue;
    }

    public boolean isInt(String path) {
        Object value = getParsedValue(path);
        return value instanceof Integer;
    }

    // Boolean operations
    public Boolean getBoolean(String path) {
        Object value = getParsedValue(path);
        return value instanceof Boolean ? (Boolean) value : null;
    }

    public Boolean getBoolean(String path, boolean defaultValue) {
        Boolean value = getBoolean(path);
        return value != null ? value : defaultValue;
    }

    public boolean isBoolean(String path) {
        Object value = getParsedValue(path);
        return value instanceof Boolean;
    }

    // String operations
    public String getString(String path) {
        Object value = getParsedValue(path);
        return value != null ? value.toString() : null;
    }

    public String getString(String path, String defaultValue) {
        String value = getString(path);
        return value != null ? value : defaultValue;
    }

    public boolean isString(String path) {
        return getParsedValue(path) instanceof String;
    }

    // Double operations
    public Double getDouble(String path) {
        Object value = getParsedValue(path);
        return value instanceof Double ? (Double) value : null;
    }

    public Double getDouble(String path, double defaultValue) {
        Double value = getDouble(path);
        return value != null ? value : defaultValue;
    }

    public boolean isDouble(String path) {
        Object value = getParsedValue(path);
        return value instanceof Double;
    }

    // Long operations
    public Long getLong(String path) {
        Object value = getParsedValue(path);
        return value instanceof Long ? (Long) value : null;
    }

    public Long getLong(String path, long defaultValue) {
        Long value = getLong(path);
        return value != null ? value : defaultValue;
    }

    public boolean isLong(String path) {
        Object value = getParsedValue(path);
        return value instanceof Long;
    }

    // Float operations
    public Float getFloat(String path) {
        Object value = getParsedValue(path);
        return value instanceof Float ? (Float) value : null;
    }

    public Float getFloat(String path, float defaultValue) {
        Float value = getFloat(path);
        return value != null ? value : defaultValue;
    }

    public boolean isFloat(String path) {
        Object value = getParsedValue(path);
        return value instanceof Float;
    }

    // Short operations
    public Short getShort(String path) {
        Object value = getParsedValue(path);
        return value instanceof Short ? (Short) value : null;
    }

    public Short getShort(String path, short defaultValue) {
        Short value = getShort(path);
        return value != null ? value : defaultValue;
    }

    public boolean isShort(String path) {
        Object value = getParsedValue(path);
        return value instanceof Short;
    }

    // List operations
    public List<?> getList(String path) {
        Object value = getParsedValue(path);
        return value instanceof List ? (List<?>) value : null;
    }

    public boolean isList(String path) {
        return getParsedValue(path) instanceof List;
    }

    // Pretty-print the loaded YAML data
    public String prettyPrint() {
        if (data == null) return null;

        StringWriter writer = new StringWriter();
        yaml.dump(data, writer);
        return writer.toString();
    }
}
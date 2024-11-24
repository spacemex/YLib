package com.github.spacemex.yamlapi;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.StringWriter;
import java.util.Map;

public class YamlDumper {
    public String dumpYaml(Map<String, Object> data) {
        DumperOptions options = new DumperOptions();
        options.setIndent(2);
        options.setPrettyFlow(true);
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);

        Yaml yaml = new Yaml(options);
        StringWriter writer = new StringWriter();
        yaml.dump(data, writer);
        return writer.toString();
    }
}
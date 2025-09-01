package com.pars.yaml;

import com.pars.ReadFromFile;
import org.yaml.snakeyaml.Yaml;

import java.util.Map;

public class YamlParce {
    public static void main(String[] args) {
        Yaml yaml = new Yaml();
        // from Yaml to String
        String yamlStr = ReadFromFile.readToString("/Users/oleksandrstepurko/IdeaProjects/HillelSummer2024_upd/mvnProjects/pars/src/main/resources/user.yaml");
        Map<String, Object> obj = yaml.load(yamlStr); // from String to Yaml
        System.out.println(obj);
        // from String to Yaml
        System.out.println(yaml.dump(obj)); // from Yaml to String
    }
}

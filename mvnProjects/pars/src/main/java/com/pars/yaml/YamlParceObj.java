package com.pars.yaml;

import com.pars.ReadFromFile;
import com.pars.UserExt;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.extensions.compactnotation.CompactConstructor;

import java.util.Map;

public class YamlParceObj {
    public static void main(String[] args) {
        Yaml yaml = new Yaml(new Constructor(UserExt.class, new LoaderOptions()));
        String yamlStr = ReadFromFile.readToString("/Users/oleksandrstepurko/IdeaProjects/HillelJavaWinter2024/mvnProjects/pars/src/main/resources/userClass.yaml");
        UserExt user = yaml.load(yamlStr);
        System.out.println(user);
    }
}

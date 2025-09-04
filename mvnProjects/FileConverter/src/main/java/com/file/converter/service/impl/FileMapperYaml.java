package com.file.converter.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.file.converter.service.FileMapper;
import com.file.converter.service.FileProcessor;
import java.util.HashMap;
import lombok.SneakyThrows;
import org.yaml.snakeyaml.Yaml;

public class FileMapperYaml implements FileMapper {

    @SneakyThrows
    @Override
    public String convertFile(String content) {
       ObjectMapper mapper = new ObjectMapper();
       HashMap hashMap = mapper.readValue(content, HashMap.class);

       Yaml yaml = new Yaml();
       return yaml.dumpAsMap(hashMap);
    }
}

package org.demo.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import lombok.SneakyThrows;

import java.io.File;

import static org.demo.utils.Utils.getPathToResourcesByFileName;

public class YamlConfigurationLoader {
    /**
     * yamlFileName - file from resources folder
     */
    @SneakyThrows
    public static <T> T load(String yamlFileName, Class<T> cls) {
        ObjectMapper objectMapper =
                new ObjectMapper(new YAMLFactory())
                        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.findAndRegisterModules();
        String path = getPathToResourcesByFileName(yamlFileName);
        return objectMapper.readValue(new File(path), cls);
    }
}

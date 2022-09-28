package org.demo.utils;

import lombok.SneakyThrows;

import java.util.Objects;

public class Utils {
    @SneakyThrows
    public static String getPathToResourcesByFileName(String filename) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return Objects.requireNonNull(classLoader.getResource(filename).toURI().getPath());
    }
}

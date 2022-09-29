package org.demo.config;

import io.github.cdimascio.dotenv.Dotenv;

public class TestConfiguration {
    public static String BASE_URL = "https://selenide.org";
    public static String SELENOID_URL = System.getProperty("SELENOID_URL", "http://host.docker.internal:4444/wd/hub");
    public static boolean USE_LOCAL_BROWSER = Boolean.parseBoolean(System.getProperty("USE_LOCAL_BROWSER", "true"));


}

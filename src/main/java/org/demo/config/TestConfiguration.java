package org.demo.config;

public class TestConfiguration {
    public static String BASE_URL = "https://selenide.org";
    public static String SELENOID_URL = System.getProperty("SELENOID_URL", "http://192.168.0.110:4444/wd/hub");
    public static boolean USE_LOCAL_BROWSER = Boolean.parseBoolean(System.getProperty("USE_LOCAL_BROWSER", "true"));


}

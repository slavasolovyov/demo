package org.demo.config;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.Getter;

import static org.demo.constants.Constants.APPLICATION_YAML_FILENAME;

public class Configuration {

    private static Config config = YamlConfigurationLoader.load(APPLICATION_YAML_FILENAME, Config.class);
    public static Dotenv environmentVariables = Dotenv.configure().systemProperties().load();

    static {
        String environment = environmentVariables.get("env");

        if(environment.equalsIgnoreCase("dev")) {
            System.out.println("environment dev");
        } else if (environment.equalsIgnoreCase("qa")) {
            System.out.println("environment qa");
        }
        TestConfiguration.USE_LOCAL_BROWSER = Boolean.parseBoolean(environmentVariables.get("USE_LOCAL_BROWSER"));
    }

    public static Config getConfig() {
        return config;
    }

    @Getter
    public static class Config {
       private TestDataConfig testDataConfig;

    }

    @Getter
    public static class TestDataConfig{
        private String baseUrl;
        private String login;
        private String pass;
    }
}

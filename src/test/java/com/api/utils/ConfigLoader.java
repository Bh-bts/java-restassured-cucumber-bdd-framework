package com.api.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    Properties properties;

    public ConfigLoader() {
        properties = new Properties();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties")) {

                properties.load(inputStream);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getBaseUrl() {
        return properties.getProperty("baseUrl");
    }
}

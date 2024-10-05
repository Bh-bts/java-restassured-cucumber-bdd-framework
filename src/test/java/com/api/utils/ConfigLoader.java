package com.api.utils;

import java.io.InputStream;
import java.util.Properties;

/**
 * Utility class to load configuration properties from a properties file.
 * Provides methods to access base URLs and other configuration details.
 */
public class ConfigLoader {
    Properties properties;

    /**
     * Loads the configuration properties from the 'config.properties' file.
     */
    public ConfigLoader() {
        properties = new Properties();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new RuntimeException("Unable to find 'config.properties' file.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration properties.", e);
        }
    }

    /**
     * Retrieves the value of 'baseUrl' from the properties file.
     * 
     * @return The base URL as a string.
     */
    public String getBaseUrl() {
        return properties.getProperty("baseUrl");
    }

    /**
     * Retrieves the value of 'baseUrl1' from the properties file.
     * 
     * @return The alternate base URL as a string.
     */
    public String getBaseUrl1() {
        return properties.getProperty("baseUrl1");
    }
}
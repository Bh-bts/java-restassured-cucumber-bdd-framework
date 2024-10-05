package com.api.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Utility class for reading and parsing JSON files using Gson.
 */
public class ReadJSONFile {

    private static JsonObject jsonObject = null;
    private static final String jsonFilePath= null;

    /**
     * Constructor that initializes the JSON object by reading the provided JSON file path.
     */
    public ReadJSONFile() {
        jsonObject = readJson(jsonFilePath).getAsJsonObject();
    }

    /**
     * Reads the JSON file from the given path and returns the parsed JsonObject.
     *
     * @param jsonFilePath The path to the JSON file.
     * @return The parsed JsonObject.
     */
    public static JsonObject readJson(String jsonFilePath) {
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(jsonFilePath));
            String jsonFile = new String(encoded, StandardCharsets.UTF_8);
            return JsonParser.parseString(jsonFile).getAsJsonObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Retrieves a nested value from the JSON object by specifying the top-level and nested keys.
     *
     * @param topLevelKey The top-level key in the JSON structure.
     * @param nestedKey The nested key within the top-level key.
     * @return The value associated with the nested key as a string.
     */
    public static String getNestedValueFromJson(String topLevelKey, String nestedKey) {
        return jsonObject.getAsJsonObject(topLevelKey).get(nestedKey).getAsString();
    }
}
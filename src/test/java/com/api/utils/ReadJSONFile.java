package com.api.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadJSONFile {

    private static JsonObject jsonObject = null;
    private static final String jsonFilePath= null;

    public ReadJSONFile() {
        jsonObject = readJson(jsonFilePath).getAsJsonObject();
    }

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

    public static String getNestedValueFromJson(String topLevelKey, String nestedKey) {
        return jsonObject.getAsJsonObject(topLevelKey).get(nestedKey).getAsString();
    }
}
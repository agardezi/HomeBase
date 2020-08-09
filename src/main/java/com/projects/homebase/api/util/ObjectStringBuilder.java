package com.projects.homebase.api.util;

/**
 * Code from: https://stackoverflow.com/questions/31847080/how-to-convert-any-object-to-string/31847637
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class ObjectStringBuilder {
    public static String convertMapToString(Map<String, String> data) {
        //convert Map  to String
        return new GsonBuilder().setPrettyPrinting().create().toJson(data);
    }
    public static <T> List<T> convertStringToList(String strListObj) {
        //convert string json to object List
        return new Gson().fromJson(strListObj, new TypeToken<List<Object>>() {
        }.getType());
    }
    public static <T> T convertStringToObj(String strObj, Class<T> classOfT) {
        //convert string json to object
        return new Gson().fromJson(strObj, (Type) classOfT);
    }

    public static JsonObject convertStringToJsonObj(String strObj) {
        //convert string json to object
        return new Gson().fromJson(strObj, JsonObject.class);
    }

    public static <T> String convertListObjToString(List<T> listObj) {
        //convert object list to string json for
        return new Gson().toJson(listObj, new TypeToken<List<T>>() {
        }.getType());
    }

    public static String convertObjToString(Object clsObj) {
        //convert object  to string json
        String jsonSender = new Gson().toJson(clsObj, new TypeToken<Object>() {
        }.getType());
        return jsonSender;
    }
}

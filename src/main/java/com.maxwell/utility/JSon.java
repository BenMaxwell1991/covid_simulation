package com.maxwell.utility;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSon {


    public static Object readFromJson(Object obj, String filePath) {
        Gson gson = new Gson();
        Class<?> objClass = obj.getClass();
        Object readObj = new Object();

        try {
            FileReader reader = new FileReader(filePath);
            readObj = gson.fromJson(reader, objClass);
            if (objClass.isInstance(readObj.getClass())) {
                throw new Exception("The class [" + objClass.toString() + "] does not match [" + readObj.getClass().toString() + "]");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return readObj;
    }

    // Write group data/parameters to JSON file (For testing only)
    public static void writeToJson(Object obj, String filePath) {

        FileWriter writer;
        try {
            writer = new FileWriter(filePath);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(obj, writer);

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Write object to string in Json format
    public static String writeToJsonString(Object obj) {
        StringBuilder sb = new StringBuilder();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        gson.toJson(obj, sb);
        return sb.toString();
    }

    public static Object readFromJsonString(Object obj, String JSonString) {
        Gson gson = new Gson();
        Class<?> objClass = obj.getClass();
        Object readObj = new Object();

        try {
            readObj = gson.fromJson(JSonString, objClass);
            if (objClass.isInstance(readObj.getClass())) {
                throw new Exception("The class [" + objClass.toString() + "] does not match [" + readObj.getClass().toString() + "]");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return readObj;
    }

    // Reads a Json file, checking the data is of the correct object class
    public static String readFromJsonToString(Class objClass, String filePath) {
        Gson gson = new Gson();
        Object readObj;
        StringBuilder sb = new StringBuilder();
        String jsonAsString = "";

        try {
            FileReader reader = new FileReader(filePath);
            readObj = gson.fromJson(reader, objClass);
            if (objClass.isInstance(readObj.getClass())) {
                throw new Exception("The class [" + objClass.toString() + "] does not match [" + readObj.getClass().toString() + "]");
            }
            gson.toJson(readObj, sb);
            jsonAsString = sb.toString();
            if (jsonAsString.isEmpty()) {
                throw new Exception("File Contains No Data.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonAsString;
    } 
}

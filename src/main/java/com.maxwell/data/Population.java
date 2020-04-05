package com.maxwell.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Population {

    public ArrayList<Group> groups = new ArrayList<>();

    // Add a Group to the population
    public void add(Group g) {
        this.groups.add(g);
    }

    // Read in all group data from a JSON file
    public void read(String filePath) {
        Gson gson = new Gson();

        try {
            FileReader reader = new FileReader(Constants.inputPath);
            ArrayList<Group> groupsInit = gson.fromJson(reader, new TypeToken<ArrayList<Group>>(){}.getType());
            groups = groupsInit;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Write group data/parameters to JSON file (For testing only)
    public void write(String filePath) {

        FileWriter writer = null;
        try {
            writer = new FileWriter(filePath);

            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

            gson.toJson(groups, writer);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

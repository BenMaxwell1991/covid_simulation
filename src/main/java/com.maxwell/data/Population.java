package com.maxwell.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Population {

    public ArrayList<Group> groups = new ArrayList<>();

    public void add(Group g) {
        this.groups.add(g);
    }

    public void read(String filePath) {
        Type listType = new TypeToken<ArrayList<Group>>() {}.getType();
        Gson gson = new Gson();
    }
}

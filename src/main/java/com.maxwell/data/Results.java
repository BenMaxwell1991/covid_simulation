package com.maxwell.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Results {

    private ArrayList<SIR> sirArray = new ArrayList<>();
    private ArrayList<Double> time = new ArrayList<>();

    // Add a set of data to the results
    public void addData(SIR sir, double t) {
        sirArray.add(sir);
        time.add(t);
    }

    // Returns Susceptibility vs Time
    public Double[] getS () {
        ArrayList<Double> s = new ArrayList<>();
        for (int i = 0; i < sirArray.size(); i++) {
            s.add(time.get(i));
            s.add(sirArray.get(i).s.get());
        }
        return s.toArray(new Double[0]);
    }

    // Returns Infection vs Time
    public Double[] getI () {
        ArrayList<Double> i = new ArrayList<>();
        for (int j = 0; j < sirArray.size(); j++) {
            i.add(time.get(j));
            i.add(sirArray.get(j).i.get());
        }
        return i.toArray(new Double[0]);
    }

    // Returns Recovered vs Time
    public Double[] getR () {
        ArrayList<Double> r = new ArrayList<>();
        for (int i = 0; i < sirArray.size(); i++) {
            r.add(time.get(i));
            r.add(sirArray.get(i).r.get());
        }
        return r.toArray(new Double[0]);
    }

    // Writes data to filePath in JSON format
    public void write(String filePath) {

        FileWriter writer = null;
        try {
            writer = new FileWriter(filePath);

            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

            gson.toJson(this, writer);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

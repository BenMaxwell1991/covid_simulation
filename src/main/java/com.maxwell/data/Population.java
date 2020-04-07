package com.maxwell.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// This class contains the information on all of the groups that constitute a population
public class Population {

    public ArrayList<Group> groups = new ArrayList<>();
    public ArrayList<ArrayList<Double>> transmissionRates = new ArrayList<>(); // Transmission rate between groups (includes internal transmission rate)

    public Population() {

    }

    public Population(ArrayList<ArrayList<Double>> transmissionRate) {
        this.transmissionRates = transmissionRate;
    }

    // Add a Group to the population
    public void add(Group g) {
        this.groups.add(g);
    }

    public void normalise() {
        double total = 0.0;
        for (Group g : groups) {
            total += g.parameters.sirValues.s.get();
            total += g.parameters.sirValues.i.get();
            total += g.parameters.sirValues.r.get();
        }
        for (Group g : groups) {
            g.parameters.sirValues.s.set(g.parameters.sirValues.s.get() / total);
            g.parameters.sirValues.i.set(g.parameters.sirValues.i.get() / total);
            g.parameters.sirValues.r.set(g.parameters.sirValues.r.get() / total);
        }
    }

    public SIR getNormalisedSIR() {
        SIR sir = new SIR(0.0, 0.0, 0.0);
        for (Group g : groups) {
            sir.add(g.parameters.sirValues);
        }
        return sir.normalise();
    }

    // Read in all group data from a JSON file
    public void read(String filePath) {
        Gson gson = new Gson();

        try {
            FileReader reader = new FileReader(Constants.populationParams);
            Population population = gson.fromJson(reader, Population.class);
            this.groups = population.groups;
            this.transmissionRates = population.transmissionRates;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Write group data/parameters to JSON file (For testing only)
    public void write(String filePath) {

        FileWriter writer;
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

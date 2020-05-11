package com.maxwell.data.population;

import com.google.gson.Gson;
import com.maxwell.data.Constants;
import com.maxwell.utility.JSon;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

// This class contains the information on all of the groups that constitute a population
public class Population implements Cloneable {

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

    public SIR getSIR() {
        SIR sir = new SIR(0.0, 0.0, 0.0);
        for (Group g : groups) {
            sir.add(g.parameters.sirValues);
        }
        return sir;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}

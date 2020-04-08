package com.maxwell.data.population;

import java.util.ArrayList;

public class GroupData {

    public ArrayList<SIR> sirArray = new ArrayList<>();
    public ArrayList<Double> time = new ArrayList<>();
    public String name;

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
}

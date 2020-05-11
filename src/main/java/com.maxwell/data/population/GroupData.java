package com.maxwell.data.population;

import java.util.ArrayList;

public class GroupData {

    public String groupName;
    public ArrayList<Double> S = new ArrayList<>();
    public ArrayList<Double> I = new ArrayList<>();
    public ArrayList<Double> R = new ArrayList<>();
    public ArrayList<Double> T = new ArrayList<>();

    // Returns Susceptibility vs Time
    public Double[] getS () {
        ArrayList<Double> s = new ArrayList<>();
        for (int i = 0; i < T.size(); i++) {
            s.add(T.get(i));
            s.add(S.get(i));
        }
        return s.toArray(new Double[0]);
    }

    // Returns Infection vs Time
    public Double[] getI () {
        ArrayList<Double> i = new ArrayList<>();
        for (int j = 0; j < T.size(); j++) {
            i.add(T.get(j));
            i.add(I.get(j));
        }
        return i.toArray(new Double[0]);
    }

    // Returns Recovered vs Time
    public Double[] getR () {
        ArrayList<Double> r = new ArrayList<>();
        for (int i = 0; i < T.size(); i++) {
            r.add(T.get(i));
            r.add(R.get(i));
        }
        return r.toArray(new Double[0]);
    }
}

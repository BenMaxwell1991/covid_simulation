package com.maxwell.data;

import java.util.ArrayList;

public class Results {

    private ArrayList<Double> s = new ArrayList<>();
    private ArrayList<Double> i = new ArrayList<>();
    private ArrayList<Double> r = new ArrayList<>();

    public void addData(double S, double I, double R, double t) {
        s.add(t);
        i.add(t);
        r.add(t);

        s.add(S);
        i.add(I);
        r.add(R);
    }

    public ArrayList<Double> getS () {return s;}
    public ArrayList<Double> getI () {return i;}
    public ArrayList<Double> getR () {return r;}
}

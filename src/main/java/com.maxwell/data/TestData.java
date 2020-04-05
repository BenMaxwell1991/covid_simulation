package com.maxwell.data;

import java.util.ArrayList;

public class TestData {

    public static Population getTestData() {
        double beta = 0.23; // Recovery rate
        double initS = 0.99; // Initial number of susceptible people
        double initI = 0.01; // Initial number of infected people
        double initR = 0.0; // Initial number of recovered people

        SIR sir = new SIR(initS, initI, initR);
        GroupParameters gp = new GroupParameters(beta, sir);

        Population p = new Population();
        ArrayList<Double> transmission = getTransmissionRates();
        Group g = new Group(gp, transmission, "Whole Population");
        p.add(g);
        return p;
    }

    private static ArrayList<Double> getTransmissionRates() {
        ArrayList<Double> array = new ArrayList<>();
        array.add(3.2);
        return array;
    }
}

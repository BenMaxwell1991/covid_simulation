package com.maxwell.data;

import java.util.ArrayList;

public class TestData {

    public static Population getTestData() {
        ArrayList<ArrayList<Double>> transmissionRates = getTransmissionRates();
        Population p = new Population(transmissionRates);

        p.add(getGroup1());
        p.add(getGroup2());

        return p;
    }

    private static Group getGroup1() {
        double recoveryRate = 0.23; // Recovery rate
        double initS = 0.99; // Initial number of susceptible people
        double initI = 0.01; // Initial number of infected people
        double initR = 0.0; // Initial number of recovered people
        SIR sir = new SIR(initS, initI, initR);
        GroupParameters gp = new GroupParameters(recoveryRate, sir);

        return new Group(gp, "Group 1");
    }

    private static Group getGroup2() {
        double recoveryRate = 0.23; // Recovery rate
        double initS = 0.95; // Initial number of susceptible people
        double initI = 0.05; // Initial number of infected people
        double initR = 0.0; // Initial number of recovered people
        SIR sir = new SIR(initS, initI, initR);
        GroupParameters gp = new GroupParameters(recoveryRate, sir);

        return new Group(gp, "Group 1");
    }

    private static ArrayList<ArrayList<Double>> getTransmissionRates() {
        ArrayList<Double> innerArray = new ArrayList<>();
        ArrayList<ArrayList<Double>> outerArray = new ArrayList<>();

        innerArray.add(1.2);
        innerArray.add(1.2);
        outerArray.add(innerArray);
        innerArray.clear();
        innerArray.add(1.2);
        innerArray.add(1.2);
        outerArray.add(innerArray);

        return outerArray;
    }
}

package com.maxwell.data;

public class GroupParameters {

    public double alpha = 3.2; // Internal Transmission rate
    public double beta = 0.23; // Recovery rate

    public double initS = 0.99; // Initial number of susceptible people
    public double initI = 0.01; // Initial number of infected people
    public double initR = 0.0; // Initial number of recovered people

    public GroupParameters(){};
}

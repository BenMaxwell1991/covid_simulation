package com.maxwell.simulation;

// Holds details of the simulation, how long it will run for, the resolution of the solution and so forth
public class SimulationParameters {
    public double t; // Init time
    public double dt; // Timestep
    public double maxt; // End of simulation
    public int outputRes; // Only print data every nth iteration
    public String rungeKuttaClassName; // Name of the runge kutta class to be used as integrator

    public SimulationParameters() {
        this(0.0, 0.0, 0.0, 0, "");
    }

    // Constructor
    public SimulationParameters(double t, double dt, double maxt, int outputRes, String RKClassName) {
        this.t = t;
        this.dt = dt;
        this.maxt = maxt;
        this.outputRes = outputRes;
        this.rungeKuttaClassName = RKClassName;
    }

    // Sets the parameters of this class to those of another instance of this class
    public void set(SimulationParameters sp) {
        this.t = sp.t;
        this.dt = sp.dt;
        this.maxt = sp.maxt;
        this.outputRes = sp.outputRes;
        this.rungeKuttaClassName = sp.rungeKuttaClassName;
    }
}

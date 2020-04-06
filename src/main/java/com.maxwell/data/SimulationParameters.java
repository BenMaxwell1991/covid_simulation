package com.maxwell.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// Holds details of the simulation, how long it will run for, the resolution of the solution and so forth
public class SimulationParameters {
    public double t; // Init time
    public double dt; // Timestep
    public double maxt; // End of simulation
    public int outputRes; // Only print data every nth iteration
    public String rungeKuttaClassName; // Name of the runge kutta class to be used as integrator

    public SimulationParameters() {
        this(0.0, 0.001, 20.0, 100, Constants.EulerCN);
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

    // Read in an instance of this class from a Json file, then set the parameters of this class to those read in.
    public void read() {
        Gson gson = new Gson();

        try {
            FileReader reader = new FileReader(Constants.simulationParams);
            SimulationParameters params = gson.fromJson(reader, new TypeToken<SimulationParameters>(){}.getType());
            set(params);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Write this class to JSON file (For testing only)
    public void write() {
        FileWriter writer;
        try {
            writer = new FileWriter(Constants.simulationParams);

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

package com.maxwell.simulation;

import com.maxwell.data.*;

public class Simulation {

    public SimulationParameters simParams;
    public Results results = new Results();

    public Simulation(){
        this(0.0, 0.001, 20.0, 100);
    }

    public Simulation(double startTime, double timeStep, double endTime, int outputRes) {
        this.simParams = new SimulationParameters(startTime, timeStep, endTime, outputRes);
    }

// Runs the simulation from t to maxt
    public void run(SIR sir, Population pop) {

        simParams.read();
        double t = simParams.t;
        double dt = simParams.dt;
        double maxt = simParams.maxt;
        int outputRes = simParams.outputRes;

        try {
            results.addData((SIR)sir.clone(), t);
            RungeKutta theIterator = new SimpleEuler();

            int loopCount = 0;
            for (double i = t; i < maxt; i = i + dt) {
                theIterator.stepForward(sir, pop, dt);
                t = t + dt;
                loopCount++;

                if (loopCount % outputRes == 0) {
                    results.addData((SIR)sir.clone(), t);
                }
            }
            results.write(Constants.outputPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Results getResults() {
        return results;
    }
}

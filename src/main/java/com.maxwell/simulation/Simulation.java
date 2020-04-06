package com.maxwell.simulation;

import com.maxwell.data.*;

import java.lang.reflect.Constructor;

public class Simulation {

    public SimulationParameters simParams;
    public Results results = new Results();

    public Simulation(){
        this(0.0, 0.001, 20.0, 100, Constants.EulerCN);
    }

    public Simulation(double startTime, double timeStep, double endTime, int outputRes, String RKClassName) {
        this.simParams = new SimulationParameters(startTime, timeStep, endTime, outputRes, RKClassName);
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
            RungeKutta RKMethod = getMethod(simParams.rungeKuttaClassName);

            int loopCount = 0;
            for (double i = t; i < maxt; i = i + dt) {
                RKMethod.stepForward(sir, pop, dt);
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

    // Get the Runge Kutta implementation from class name
    private RungeKutta getMethod(String className) {
        RungeKutta RKMethod = null;
        try {
            Class<?> aClass = Class.forName(className);
            Constructor<?> ctor = aClass.getConstructor();
            Object object = ctor.newInstance();

            if (!RungeKutta.class.isInstance(object)) {
                throw new Exception("The class [" + className + "] does not implement [" + RungeKutta.class.getName() + "]");
            }
            RKMethod = (RungeKutta)object;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RKMethod;
    }
}

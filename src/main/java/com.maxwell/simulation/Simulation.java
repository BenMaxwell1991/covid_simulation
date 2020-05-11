package com.maxwell.simulation;

import com.maxwell.Config;
import com.maxwell.data.*;
import com.maxwell.data.population.Population;
import com.maxwell.simulation.methods.RungeKutta;
import com.maxwell.utility.JSon;

import java.lang.reflect.Constructor;

public class Simulation {

    public SimulationParameters simParams;
    public Results results;

    public Simulation(Config config){
        simParams = config.simulationParameters;
        results = new Results(config);
    }

    // Runs the simulation from t to maxt
    public void run(Population pop) {
        double t = simParams.t;
        double dt = simParams.dt;
        double maxt = simParams.maxt;
        int outputRes = simParams.outputRes;

        try {
            results.addDatanew(pop, t);
            RungeKutta RKMethod = getMethod(simParams.rungeKuttaClassName);

            int loopCount = 0;
            for (double i = t; i < maxt; i = i + dt) {
                RKMethod.stepForward(pop, dt);
                t = t + dt;
                loopCount++;
                if (loopCount % outputRes == 0) {
                    results.addDatanew(pop, t);
                }
            }
            JSon.writeToJson(results, Constants.outputPath);
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

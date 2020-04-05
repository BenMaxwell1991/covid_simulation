package com.maxwell.simulation;

import com.maxwell.data.*;
import com.maxwell.maths.Infected;
import com.maxwell.maths.Recovered;
import com.maxwell.maths.Susceptible;
import com.maxwell.utility.PrintHelper;

import java.io.File;

public class Simulation {

    public double t = 0.0; // Init time
    public double dt = 0.001; // Timestep
    public double maxt = 20.0; // End of simulation
    public int printRes = 100; // Only print data every nth iteration
    public Results results = new Results();

    public Simulation(){
        this(0.0, 0.001, 20.0);
    }

    public Simulation(double startTime, double timeStep, double endTime) {
        this.t = startTime;
        this.dt = timeStep;
        this.maxt = endTime;
    }

//    public void run(Susceptible S, Infected I, Recovered R, GroupParameters gp) {
    public void run(SIR sir, Population pop) {
        try {
//            File myFile = new File(Constants.outputPath);
//            if (myFile.exists()) {
//                myFile.delete();
//            }
//            myFile.createNewFile();

            PrintHelper.printHeader();
//            PrintHelper.printData(sir, myFile);
            results.addData((SIR)sir.clone(), t);

            Iterator theIterator = new SimpleEuler();

            int loopCount = 0;
            for (double i = t; i < maxt; i = i + dt) {

                theIterator.stepForward(sir, pop, dt);
                t = t + dt;
                loopCount++;

                if (loopCount % printRes == 0) {
//                    PrintHelper.printData(sir, myFile);
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

package com.maxwell.simulation;

import com.maxwell.data.Constants;
import com.maxwell.data.GroupParameters;
import com.maxwell.maths.Infected;
import com.maxwell.maths.Recovered;
import com.maxwell.maths.Susceptible;
import com.maxwell.utility.PrintHelper;

import java.io.File;

public class Simulation {

    public double t = 0.0; // Init time
    public double dt = 0.001; // Timestep
    public double maxt = 20.0; // End of simulation
    public int printRes = 500; // Only print data every nth iteration

    public Simulation(){
        this(0.0, 0.001, 20.0);
    }

    public Simulation(double startTime, double timeStep, double endTime) {
        this.t = startTime;
        this.dt = timeStep;
        this.maxt = endTime;
    }

    public void run(Susceptible S, Infected I, Recovered R, GroupParameters gp) {
        try {
            File myFile = new File(Constants.outputPath);
            if (myFile.exists()) {
                myFile.delete();
            }
            myFile.createNewFile();

            PrintHelper.printHeader();
            PrintHelper.printData(S, I, R, myFile);

            Iterator theIterator = new SimpleEuler();

            int loopCount = 0;
            for (double i = t; i < maxt; i = i + dt) {

                theIterator.stepForward(S, I, R, gp, dt);
                loopCount++;

                if (loopCount % printRes == 0) {
                    PrintHelper.printData(S, I, R, myFile);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

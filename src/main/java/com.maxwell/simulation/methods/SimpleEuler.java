package com.maxwell.simulation.methods;

import com.maxwell.data.population.GroupParameters;
import com.maxwell.data.population.Population;
import com.maxwell.data.population.SIR;
import com.maxwell.simulation.methods.RungeKutta;

// Implements the runge kutta model under the assumption the rate of change is constant.
// This is the simplest solution to the problem but not always as accurate for exponential curves.
public class SimpleEuler implements RungeKutta {

    public SimpleEuler(){}

    // Calculates the rate of change of s, i and r with respect to t, then steps forward
    // assuming this rate is constant for a small timestep dt
    public void stepForward(Population pop, double dt){

        int n = pop.groups.size();
        double[] dSdT = new double[n];
        double[] dIdT = new double[n];
        double[] dRdT = new double[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // i loops through independent group parameters
                // j loops through dependant group parameters

                GroupParameters indGP = pop.groups.get(i).parameters;
                GroupParameters depGP = pop.groups.get(j).parameters;

                SIR indSIR = indGP.sirValues;
                SIR depSIR = depGP.sirValues;

                double outTransRate = pop.transmissionRates.get(i).get(j);
                double inTransRate = pop.transmissionRates.get(j).get(i);

                dSdT[i] = dSdT[i] + indSIR.s.rate(inTransRate, depSIR.i.get());
                dRdT[i] = dRdT[i] + indSIR.r.rate(indGP.recoveryRate, indSIR.i.get()) / n;

                if (i != j) {
                    dSdT[j] = dSdT[j] + depSIR.s.rate(outTransRate, indSIR.i.get());
                    dRdT[j] = dRdT[j] + depSIR.r.rate(depGP.recoveryRate, depSIR.i.get()) / n;
                }
            }
        }

        for (int i = 0; i < n; i++){
            dIdT[i] = pop.groups.get(i).parameters.sirValues.i.rate(dSdT[i], dRdT[i]);
        }

        for (int i = 0; i < n; i++) {
            SIR sir = pop.groups.get(i).parameters.sirValues;
            sir.s.set(sir.s.get() + (dSdT[i] * dt));
            sir.i.set(sir.i.get() + (dIdT[i] * dt));
            sir.r.set(sir.r.get() + (dRdT[i] * dt));
        }
    }
}

package com.maxwell.simulation;

import com.maxwell.data.Group;
import com.maxwell.data.GroupParameters;
import com.maxwell.data.Population;
import com.maxwell.data.SIR;

// Implements the runge kutta model under the assumption the rate of change is constant.
// This is the simplest solution to the problem but not always as accurate for exponential curves.
public class SimpleEuler implements RungeKutta {

    public SimpleEuler(){}

    // Calculates the rate of change of s, i and r with respect to t, then steps forward
    // assuming this rate is constant for a small timestep dt
    public void stepForward(SIR sir, Population pop, double dt){
        Group g = pop.groups.get(0);
        GroupParameters gp = g.parameters;
        double transRate = g.transmissionRate.get(0);

        double dSdT = sir.s.rate(transRate, sir.i.get());
        double dRdT = sir.r.rate(gp.recoveryRate, sir.i.get());
        double dIdT = sir.i.rate(dSdT, dRdT);

        sir.s.set(sir.s.get() + (dSdT * dt));
        sir.i.set(sir.i.get() + (dIdT * dt));
        sir.r.set(sir.r.get() + (dRdT * dt));
    }
}

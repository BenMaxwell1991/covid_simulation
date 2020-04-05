package com.maxwell.simulation;

import com.maxwell.data.Group;
import com.maxwell.data.GroupParameters;
import com.maxwell.data.Population;
import com.maxwell.data.SIR;
import com.maxwell.maths.Infected;
import com.maxwell.maths.Recovered;
import com.maxwell.maths.Susceptible;

public class SimpleEuler implements Iterator {

    public SimpleEuler(){}

    public void stepForward(SIR sir, Population pop, double dt){
        Group g = pop.groups.get(0);
        GroupParameters gp = g.parameters;
        double transRate = g.transmissionRate.get(0);

        double dSdT = sir.s.rate(transRate, sir.i.get());
        double dIdT = sir.i.rate(sir.s.rate(transRate, sir.i.get()), sir.r.rate(gp.beta, sir.i.get()));
        double dRdT = sir.r.rate(gp.beta, sir.i.get());

        sir.s.set(sir.s.get() + (dSdT * dt));
        sir.i.set(sir.i.get() + (dIdT * dt));
        sir.r.set(sir.r.get() + (dRdT * dt));
    }
}

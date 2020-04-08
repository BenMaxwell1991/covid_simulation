package com.maxwell.simulation.methods;

import com.maxwell.data.population.Group;
import com.maxwell.data.population.GroupParameters;
import com.maxwell.data.population.Population;
import com.maxwell.data.population.SIR;
import com.maxwell.simulation.methods.RungeKutta;

public class ClassicRungeKutta implements RungeKutta {

    public ClassicRungeKutta() {
    }

    public void stepForward(Population pop, double dt) {
        SIR sir = pop.groups.get(0).parameters.sirValues;
        double k1S, k1I, k1R;
        double k2S, k2I, k2R;
        double k3S, k3I, k3R;
        double k4S, k4I, k4R;
        double I2, I3, I4;
        Group g = pop.groups.get(0);
        GroupParameters gp = g.parameters;
        double transRate = pop.transmissionRates.get(0).get(0);
        double recovRate = gp.recoveryRate;

        k1S = sir.s.rate(transRate, sir.i.get());
        k1R = sir.r.rate(recovRate, sir.i.get());
        k1I = sir.i.rate(k1S, k1R);

        I2 = sir.i.get() + k1I / 2.0;

        k2S = sir.s.rate(transRate, I2);
        k2R = sir.r.rate(recovRate, I2);
        k2I = sir.i.rate(k2S, k2R);

        I3 = sir.i.get() + k2I / 2.0;

        k3S = sir.s.rate(transRate, I3);
        k3R = sir.r.rate(recovRate, I3);
        k3I = sir.i.rate(k3S, k3R);

        I4 = sir.i.get() + k3I;

        k4S = sir.s.rate(transRate, I4);
        k4R = sir.r.rate(recovRate, I4);
        k4I = sir.i.rate(k4S, k4R);

        sir.s.set(sir.s.get() + (k1S + 2*k2S + 2*k3S + k4S) * dt / 6);
        sir.i.set(sir.i.get() + (k1I + 2*k2I + 2*k3I + k4I) * dt / 6);
        sir.r.set(sir.r.get() + (k1R + 2*k2R + 2*k3R + k4R) * dt / 6);
    }
}

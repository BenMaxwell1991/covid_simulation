package com.maxwell.simulation;

import com.maxwell.data.GroupParameters;
import com.maxwell.maths.Infected;
import com.maxwell.maths.Recovered;
import com.maxwell.maths.Susceptible;

public class SimpleEuler implements Iterator {

    public SimpleEuler(){}

    public void stepForward(Susceptible S, Infected I, Recovered R, GroupParameters gp, double dt){
        double dSdT = S.rate(gp.alpha, I.get());
        double dIdT = I.rate(S.rate(gp.alpha, I.get()), R.rate(gp.beta, I.get()));
        double dRdT = R.rate(gp.beta, I.get());

        S.set(S.get() + (dSdT * dt));
        I.set(I.get() + (dIdT * dt));
        R.set(R.get() + (dRdT * dt));
    }
}

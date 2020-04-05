package com.maxwell.data;

import com.maxwell.maths.Infected;
import com.maxwell.maths.Recovered;
import com.maxwell.maths.Susceptible;

public class SIR {
    public Susceptible s;
    public Infected i;
    public Recovered r;

    public SIR(double S, double I, double R){
        s = new Susceptible(S);
        i = new Infected(I);
        r = new Recovered(R);
    }
}

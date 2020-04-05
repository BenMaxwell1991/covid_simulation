package com.maxwell.data;

import com.maxwell.maths.Infected;
import com.maxwell.maths.Recovered;
import com.maxwell.maths.Susceptible;

public class SIR implements Cloneable{
    public Susceptible s;
    public Infected i;
    public Recovered r;

    public SIR(double S, double I, double R){
        s = new Susceptible(S);
        i = new Infected(I);
        r = new Recovered(R);
    }

    public Object clone() throws CloneNotSupportedException {
        SIR cloned = (SIR)super.clone();
        cloned.s = (Susceptible)s.clone();
        cloned.i = (Infected) i.clone();
        cloned.r = (Recovered) r.clone();
        return cloned;
    }
}

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

    // Add another set of sir values to this one
    public void add(SIR sir) {
        this.s.set(this.s.get() + sir.s.get());
        this.i.set(this.i.get() + sir.i.get());
        this.r.set(this.r.get() + sir.r.get());
    }

    // Normalise the sir values so that their total is 1
    public SIR normalise() {
        double total = this.s.get() + this.i.get() + this.r.get();
        this.s.set(this.s.get() / total);
        this.i.set(this.i.get() / total);
        this.r.set(this.r.get() / total);
        return this;
    }

    public Object clone() throws CloneNotSupportedException {
        SIR cloned = (SIR)super.clone();
        cloned.s = (Susceptible)s.clone();
        cloned.i = (Infected) i.clone();
        cloned.r = (Recovered) r.clone();
        return cloned;
    }
}

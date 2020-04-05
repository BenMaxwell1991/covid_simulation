package com.maxwell.maths;

public class Susceptible extends ContinuousValue {

    public Susceptible(double x) {super.set(x);}

    public double rate(double alpha, double I) {
        return -(alpha * this.get() * I);
    }
}

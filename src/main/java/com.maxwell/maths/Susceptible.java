package com.maxwell.maths;

public class Susceptible extends ContinuousValue {

    public Susceptible(double x) {super.set(x);}

    public double rate(double transmissionRate, double I) {
        return -(transmissionRate * this.get() * I);
    }
}

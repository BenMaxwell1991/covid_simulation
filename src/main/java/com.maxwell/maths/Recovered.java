package com.maxwell.maths;

public class Recovered extends ContinuousValue {

    public Recovered(double x) {super.set(x);}

    public double rate(double beta, double I) {
        return (beta * I);
    }
}

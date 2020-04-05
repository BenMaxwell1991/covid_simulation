package com.maxwell.maths;

public class Infected extends ContinuousValue {

    public Infected(double x) {super.set(x);}

    public double rate(double dSdT, double dRdT) {
        return -(dSdT + dRdT);
    }
}

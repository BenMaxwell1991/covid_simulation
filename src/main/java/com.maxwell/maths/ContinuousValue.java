package com.maxwell.maths;

// This class should to implemented by an object that is continuous to the order of 2.
public abstract class ContinuousValue implements Cloneable {

    private double value;

    public double get() {return value;}

    public void set(double x) {value = x;}

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

package com.maxwell.data;

public class GroupParameters {

    public double beta; // Recovery rate
    public SIR sirInit;

    public GroupParameters() {
        this(0.23, new SIR (0.99, 0.01, 0.00));
    }

    public GroupParameters(double b, SIR sir){
        this.beta = b;
        this.sirInit = sir;
    };
}

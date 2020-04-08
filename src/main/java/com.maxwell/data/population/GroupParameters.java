package com.maxwell.data.population;

// Contains the parameters internal to a group: the recovery rate of an individual and the SIR distribution
public class GroupParameters {

    public double recoveryRate; // Recovery rate
    public SIR sirValues; // Initial SIR values within group

    public GroupParameters() {
        this(0.23, new SIR (0.99, 0.01, 0.00));
    }

    public GroupParameters(double recoveryRate, SIR sirInit){
        this.recoveryRate = recoveryRate;
        this.sirValues = sirInit;
    };
}

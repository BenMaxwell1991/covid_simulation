package com.maxwell.data;

import com.maxwell.maths.Susceptible;

import java.util.ArrayList;

public class Group {

    public String name;
    public GroupParameters parameters;
    public ArrayList<Double> transmissionRate; // Transmission rate between groups (includes internal transmission rate)

    public Group() {
        this(new GroupParameters(), new ArrayList<>(), "EmptyGroupName");
    }

    public Group(GroupParameters gp, ArrayList<Double> a, String aName) {
        parameters = gp;
        transmissionRate = a;
        name = aName;
    }
}

package com.maxwell.data;

import java.util.ArrayList;

public class Group {
    public GroupParameters parameters;
    public ArrayList<Double> alpha; // Transmission rate between groups (includes internal transmission rate)

    public Group() {
        this(new GroupParameters(), new ArrayList<>());
    }

    public Group(GroupParameters gp, ArrayList<Double> a) {
        parameters = gp;
        alpha = a;
    }
}

package com.maxwell.data;

import com.maxwell.maths.Susceptible;

import java.util.ArrayList;

public class Group {

    public String name;
    public GroupParameters parameters;

    public Group() {
        this(new GroupParameters(), "EmptyGroupName");
    }

    public Group(GroupParameters gp, String aName) {
        parameters = gp;
        name = aName;
    }
}

package com.maxwell.data.population;

public class Group {

    public String name;
    public GroupParameters parameters;
    public GroupData data;

    public Group(GroupParameters gp, String aName) {
        parameters = gp;
        name = aName;
        data = new GroupData(); //initialises to empty
    }
}

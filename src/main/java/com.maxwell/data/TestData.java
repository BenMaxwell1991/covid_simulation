package com.maxwell.data;

public class TestData {

    public static Population getTestData() {
        Population p = new Population();
        Group g = new Group();
        p.add(g);
        return p;
    }
}

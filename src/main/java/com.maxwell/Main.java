package com.maxwell;

import com.maxwell.charts.MyGraphDrawer;
import com.maxwell.data.Population;
import com.maxwell.data.TestData;
import com.maxwell.maths.Infected;
import com.maxwell.maths.Recovered;
import com.maxwell.maths.Susceptible;
import com.maxwell.simulation.Simulation;

public class Main {

    public static void main(String[] args) {
        Population population = TestData.getTestData();

        Susceptible S = new Susceptible(population.groups.get(0).parameters.initS);
        Infected I = new Infected(population.groups.get(0).parameters.initI);
        Recovered R = new Recovered(population.groups.get(0).parameters.initR);

        Simulation simulation = new Simulation();
        simulation.run(S, I, R, population.groups.get(0).parameters);

        MyGraphDrawer mgd = new MyGraphDrawer(simulation.getResults());
    }
}
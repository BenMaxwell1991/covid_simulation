package com.maxwell;

import com.maxwell.charts.MyGraphDrawer;
import com.maxwell.data.Constants;
import com.maxwell.data.Population;
import com.maxwell.simulation.Simulation;

public class Main {

    public static void main(String[] args) {
        Population population = new Population();
        population.read(Constants.populationParams);
        population.normalise();

        Simulation simulation = new Simulation();
        simulation.run(population);

        MyGraphDrawer mgd = new MyGraphDrawer(simulation.getResults());
    }
}
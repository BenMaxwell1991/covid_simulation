package com.maxwell;

import com.maxwell.charts.MyGraphDrawer;
import com.maxwell.data.Constants;
import com.maxwell.data.Population;
import com.maxwell.data.SIR;
import com.maxwell.simulation.Simulation;

public class Main {

    public static void main(String[] args) {
        Population population = new Population();
        population.read(Constants.groupParams);

        SIR sir = population.groups.get(0).parameters.sirInit;
        Simulation simulation = new Simulation();

        simulation.run(sir, population);

        MyGraphDrawer mgd = new MyGraphDrawer(simulation.getResults());
    }
}
package com.maxwell;

import com.maxwell.charts.MyGraphDrawer;
import com.maxwell.data.Constants;
import com.maxwell.data.population.Population;
import com.maxwell.simulation.Simulation;
import com.maxwell.utility.JSon;

public class Main {

    public static void main(String[] args) {
        Population p = new Population();
        p = (Population)JSon.readFromJson(p, Constants.populationParams);
        p.normalise();

        Simulation simulation = new Simulation(p.groups.size() + 1);
        simulation.run(p);

        MyGraphDrawer mgd = new MyGraphDrawer(p, simulation.getResults());
    }
}
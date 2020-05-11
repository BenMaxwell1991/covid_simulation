package com.maxwell;

import com.maxwell.charts.MyGraphDrawer;
import com.maxwell.simulation.Simulation;

public class Main {

    public static void main(String[] args) {
        Config config = Config.loadConfigFromFile();
        Simulation simulation = new Simulation(config);
        simulation.run(config.populationParameters);
//         MyGraphDrawer mgd = new MyGraphDrawer(config.populationParameters, simulation.getResults());
    }
}
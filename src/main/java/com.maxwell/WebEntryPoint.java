package com.maxwell;

import com.maxwell.simulation.Simulation;

public class WebEntryPoint {

    public static void main(String jsonConfig) {
        Config config = Config.loadConfigFromJSON(jsonConfig);
        Simulation simulation = new Simulation(config);
        simulation.run(config.populationParameters);
    }
}
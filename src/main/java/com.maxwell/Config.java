package com.maxwell;

import com.maxwell.data.Constants;
import com.maxwell.data.population.Population;
import com.maxwell.simulation.SimulationParameters;
import com.maxwell.utility.JSon;

public class Config {

    public SimulationParameters simulationParameters;
    public Population populationParameters;

    Config() {
        simulationParameters = new SimulationParameters();
        populationParameters = new Population();
    }

    static Config loadConfigFromFile() {
        Config config = (Config) JSon.readFromJson(new Config(), Constants.config);
        return config;
    }

    static Config loadConfigFromJSON(String jsonConfig) {
        Config config = (Config) JSon.readFromJsonString(new Config(), jsonConfig);
        return config;
    }
}

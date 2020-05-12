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
        Config config = (Config) JSon.readFromJson(Config.class, Constants.config);
        return config;
    }

    static Config loadConfigFromJSON(String jsonConfig) {
        Config config = null;
        Object object = JSon.readFromJsonString(Config.class, jsonConfig);
        if (object instanceof Config) { 
            config = (Config) object;
        } else {
            
        }
        return config;
    }
}

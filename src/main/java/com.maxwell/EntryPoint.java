package com.maxwell;

import com.maxwell.charts.MyGraphDrawer;
import com.maxwell.simulation.Simulation;
import com.maxwell.utility.JSon;

import java.io.OutputStream;

public class EntryPoint {

    public static void getResultStream(String jsonConfig, OutputStream outputStream) {
        Config config = Config.loadConfigFromJSON(jsonConfig);
        Simulation simulation = new Simulation(config);
        simulation.run(config.populationParameters);
        JSon.writeToJsonStream(simulation.results, outputStream);
    }

    public static String getResultString(String jsonConfig) {
        Config config = Config.loadConfigFromJSON(jsonConfig);
        Simulation simulation = new Simulation(config);
        simulation.run(config.populationParameters);
        return JSon.writeToJsonString(simulation.results);
    }

    public static void getResultImages(String jsonConfig) {
        Config config = Config.loadConfigFromJSON(jsonConfig);
        Simulation simulation = new Simulation(config);
        simulation.run(config.populationParameters);
        MyGraphDrawer mgd = new MyGraphDrawer(config.populationParameters, simulation.getResults());
    }
}
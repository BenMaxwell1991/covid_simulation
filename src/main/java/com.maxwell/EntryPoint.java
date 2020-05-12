package com.maxwell;

import com.maxwell.charts.MyGraphDrawer;
import com.maxwell.data.Results;
import com.maxwell.simulation.Simulation;
import com.maxwell.utility.JSon;

import java.io.OutputStream;

// This interfaces with the Spring Boot Application
public class EntryPoint {
    
    // Returns the results object as a stream
    public static void getResultStream(String jsonConfig, OutputStream outputStream) {
        Results results = getResults(jsonConfig);
        JSon.writeToJsonStream(results, outputStream);
    }

    
    // Returns the results object as a string
    public static String getResultString(String jsonConfig) {
        Results results = getResults(jsonConfig);
        return JSon.writeToJsonString(results);
    }

    
    // Produces graphs of each population using the results object
    public static void getResultImages(String jsonConfig) {
        Config config = Config.loadConfigFromJSON(jsonConfig);
        Results results = getResults(jsonConfig);
        MyGraphDrawer mgd = new MyGraphDrawer(config.populationParameters, results);
    }
    
    
    // Runs the simulation using the jsonConfig input and returns the Results object
    private static Results getResults(String jsonConfig) {
        Config config = Config.loadConfigFromJSON(jsonConfig);
        Simulation simulation = new Simulation(config);
        simulation.run(config.populationParameters);
        return simulation.results;
    }
}
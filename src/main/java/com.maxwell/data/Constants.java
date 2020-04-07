package com.maxwell.data;

public class Constants {

    private Constants(){}

    public static String populationParams = "PopulationParameters.json";
    public static String simulationParams = "SimulationParameters.json";
    public static String outputPath = "OutputData.json";

    public static String EulerCN = "com.maxwell.simulation.SimpleEuler";
    public static String RK4CN = "com.maxwell.simulation.ClassicRungeKutta";
}

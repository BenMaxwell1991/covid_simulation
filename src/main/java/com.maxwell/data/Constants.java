package com.maxwell.data;

public class Constants {

    private Constants(){}

    public static String configDir = "config/";
    public static String config = configDir + "Config.json";
    public static String outputPath = "OutputData.json";

    public static String EulerCN = "com.maxwell.simulation.methods.SimpleEuler";
    public static String RK4CN = "com.maxwell.simulation.methods.ClassicRungeKutta";
}

package com.maxwell.simulation.methods;

import com.maxwell.data.population.Population;

public interface RungeKutta {

    void stepForward(Population pop, double dt);
}

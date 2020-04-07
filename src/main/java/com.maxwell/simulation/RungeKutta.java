package com.maxwell.simulation;

import com.maxwell.data.Population;

public interface RungeKutta {

    void stepForward(Population pop, double dt);
}

package com.maxwell.simulation;

import com.maxwell.data.Population;
import com.maxwell.data.SIR;

public interface RungeKutta {

    void stepForward(SIR sir, Population pop, double dt);
}

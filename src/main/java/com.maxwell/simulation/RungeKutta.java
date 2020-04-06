package com.maxwell.simulation;

import com.maxwell.data.GroupParameters;
import com.maxwell.data.Population;
import com.maxwell.data.SIR;
import com.maxwell.maths.Infected;
import com.maxwell.maths.Recovered;
import com.maxwell.maths.Susceptible;

public interface RungeKutta {

    void stepForward(SIR sir, Population pop, double dt);
}

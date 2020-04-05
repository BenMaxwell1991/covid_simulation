package com.maxwell.simulation;

import com.maxwell.data.GroupParameters;
import com.maxwell.maths.Infected;
import com.maxwell.maths.Recovered;
import com.maxwell.maths.Susceptible;

public interface Iterator {

    void stepForward(Susceptible S, Infected I, Recovered R, GroupParameters gp, double dt);
}

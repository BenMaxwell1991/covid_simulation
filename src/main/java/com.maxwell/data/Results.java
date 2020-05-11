package com.maxwell.data;

import com.maxwell.Config;
import com.maxwell.data.population.Group;
import com.maxwell.data.population.GroupData;
import com.maxwell.data.population.Population;
import com.maxwell.data.population.SIR;
import com.maxwell.simulation.SimulationParameters;

import java.util.ArrayList;

public class Results {

    public Config config;
    public ArrayList<GroupData> groupDataResults = new ArrayList<>();

    public Results(Config config) {
        this.config = config;
        ArrayList<Group> g = config.populationParameters.groups;
        for (int i = 0; i < g.size() + 1; i++) {
            groupDataResults.add(new GroupData());
            groupDataResults.get(i).groupName = i == 0 ? "Whole Population" : g.get(i - 1).name;
        }
    }

    // Add a set of data to the results
    public void addDatanew(Population p, double t) {
        try {
            double totalS = 0.0;
            double totalI = 0.0;
            double totalR = 0.0;
            for (int i = 0; i < p.groups.size(); i++) {
                SIR clonedSIR = ((SIR)p.groups.get(i).parameters.sirValues.clone());
                totalS += clonedSIR.s.get();
                totalI += clonedSIR.i.get();
                totalR += clonedSIR.r.get();
                groupDataResults.get(i + 1).S.add(clonedSIR.s.get());
                groupDataResults.get(i + 1).I.add(clonedSIR.i.get());
                groupDataResults.get(i + 1).R.add(clonedSIR.r.get());
                groupDataResults.get(i + 1).T.add(t);
            }
            groupDataResults.get(0).S.add(totalS);
            groupDataResults.get(0).I.add(totalI);
            groupDataResults.get(0).R.add(totalR);
            groupDataResults.get(0).T.add(t);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

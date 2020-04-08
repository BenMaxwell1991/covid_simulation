package com.maxwell.data;

import com.maxwell.data.population.GroupData;
import com.maxwell.data.population.Population;
import com.maxwell.data.population.SIR;

import java.util.ArrayList;

public class Results {

    private GroupData totalData = new GroupData();
    public ArrayList<GroupData> groupData = new ArrayList<>();

    public Results(int n) {
        for (int i = 0; i < n; i++) {
            groupData.add(new GroupData());
        }
    }

    public GroupData getTotalData() { return totalData; }

    public ArrayList<GroupData> getGroupData() { return groupData; }

    // Add a set of data to the results
    public void addData(Population p, double t) {
        try {
            double totalS = 0.0;
            double totalI = 0.0;
            double totalR = 0.0;
            for (int i = 0; i < p.groups.size(); i++) {
                SIR clonedSIR = ((SIR)p.groups.get(i).parameters.sirValues.clone());
                totalS += clonedSIR.s.get();
                totalI += clonedSIR.i.get();
                totalR += clonedSIR.r.get();
                groupData.get(i).sirArray.add(clonedSIR);
                groupData.get(i).time.add(t);
            }
            totalData.sirArray.add(new SIR(totalS, totalI, totalR));
            totalData.time.add(t);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

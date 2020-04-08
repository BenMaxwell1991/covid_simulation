package com.maxwell.charts;

import com.maxwell.data.Results;
import com.maxwell.data.population.Group;
import com.maxwell.data.population.GroupData;
import com.maxwell.data.population.Population;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.title.TextTitle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyGraphDrawer {

    ArrayList<Double[]> S = new ArrayList<>();
    ArrayList<Double[]> I = new ArrayList<>();
    ArrayList<Double[]> R = new ArrayList<>();
    ArrayList<XYSeriesCollection> dataset = new ArrayList<>();

    // Get result data vs time and initialise the UI
    public MyGraphDrawer(Population pop, Results results) {

        // Add data for chart of total population
        S.add(results.getTotalData().getS());
        I.add(results.getTotalData().getI());
        R.add(results.getTotalData().getR());

        // Add data for charts of every sub population
        for (GroupData g : results.groupData) {
            S.add(g.getS());
            I.add(g.getI());
            R.add(g.getR());
        }
        ArrayList<JFreeChart> charts = getCharts(results, pop.groups);
        for (int i = 0; i < pop.groups.size() + 1; i ++) {
            JFrame aChart = initCharts(charts.get(i), i);
            aChart.setVisible(true);
        }
    }

    private ArrayList<JFreeChart> getCharts(Results results, ArrayList<Group> grps) {
        ArrayList<JFreeChart> charts = new ArrayList<>();
        for (int i = 0; i < results.groupData.size() + 1; i++) {
            String name = i == 0 ? "Whole Population" : grps.get(i - 1).name;
            dataset.add(new XYSeriesCollection());
            dataset.get(i).addSeries(createDataSet(S.get(i), "Susceptible"));
            dataset.get(i).addSeries(createDataSet(I.get(i), "Infected"));
            dataset.get(i).addSeries(createDataSet(R.get(i), "Recovered"));
            JFreeChart chart = createChart(dataset.get(i), name, "Time", "population (%)");
            charts.add(chart);
        }
        return charts;
    }

    // Initialise the User Inteface
    private JFrame initCharts(JFreeChart chart, int chartNumber) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        ChartPanel chartPanel = new ChartPanel(chart,
                (screenSize.width / 3),
                (screenSize.height / 4),
                300,
                200,
                1920,
                1080,
                true, true,
                true, true,
                true, true);

        chartPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        chartPanel.setBackground(Color.white);
        JFrame frame = new JFrame("Covid-19 Simulation");
        frame.add(chartPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setLocation(screenSize.width / 3, chartNumber * screenSize.height * 2 / 7);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }

    // take an array of data and convert it into a dataset
    public XYSeries createDataSet(Double[] xyData, String key) {

        XYSeries series = new XYSeries(key);
        for (int i = 0; i < xyData.length - 2; i = i + 2) {
            series.add(xyData[i], xyData[i+1]);
        }

        var dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        return series;
    }

    // Create and draw the chart
    private JFreeChart createChart(XYSeriesCollection data, String title, String xLabel, String yLabel) {

        JFreeChart chart = ChartFactory.createXYLineChart(
                title,
                xLabel,
                yLabel,
                data,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();

        plot.getRenderer().setSeriesStroke(0, new BasicStroke(2.0f));
        plot.getRenderer().setSeriesStroke(1, new BasicStroke(2.0f));
        plot.getRenderer().setSeriesStroke(2, new BasicStroke(2.0f));
        plot.setBackgroundPaint(Color.white);
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);
        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        chart.getLegend().setFrame(BlockBorder.NONE);
        chart.setTitle(new TextTitle(title, new Font("Serif", java.awt.Font.BOLD, 18)));

        return chart;
    }
}
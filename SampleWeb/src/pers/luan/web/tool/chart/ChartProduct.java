package pers.luan.web.tool.chart;

import org.jfree.chart.plot.PlotOrientation;

public abstract class ChartProduct {

	public abstract String create3DChart(PlotOrientation orientation, String title, String xLabel, String yLabel);
	public abstract String create2DChart(PlotOrientation orientation, String title, String xLabel, String yLabel);
	
}

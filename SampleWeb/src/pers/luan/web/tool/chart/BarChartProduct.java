package pers.luan.web.tool.chart;

import javax.servlet.http.HttpServletRequest;

import org.jfree.chart.plot.PlotOrientation;

public class BarChartProduct extends ChartProduct {

	private final HttpServletRequest request;
	private final ChartBuilder builder;
	
	private String name, url;
	
	public BarChartProduct(HttpServletRequest request, ChartBuilder builder) {
		this.request = request;
		this.builder = builder;
	}

	@Override
	public String create3DChart(PlotOrientation orientation, String title,
					String xLabel, String yLabel) {
		name = builder.createBar3DChart(orientation,
						title, xLabel, yLabel,
						true, true, true);
		url = request.getContextPath() + "/servlet/displaychart?filename="
						+ name;
		return url;
	}

	@Override
	public String create2DChart(PlotOrientation orientation, String title,
					String xLabel, String yLabel) {
		name = builder.createBar2DChart(orientation,
						title, xLabel, yLabel,
						true, true, true);
		url = request.getContextPath() + "/servlet/displaychart?filename="
						+ name;
		return url;
	}

}

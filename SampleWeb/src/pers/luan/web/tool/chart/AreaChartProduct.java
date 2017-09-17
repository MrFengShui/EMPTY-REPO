package pers.luan.web.tool.chart;

import javax.servlet.http.HttpServletRequest;

import org.jfree.chart.plot.PlotOrientation;

public class AreaChartProduct extends ChartProduct {

	private final HttpServletRequest request;
	private final ChartBuilder builder;
	
	private String name, url;
	
	public AreaChartProduct(HttpServletRequest request, ChartBuilder builder) {
		this.request = request;
		this.builder = builder;
	}

	@Override
	public String create3DChart(PlotOrientation orientation, String title,
					String xLabel, String yLabel) {
		
		return null;
	}

	@Override
	public String create2DChart(PlotOrientation orientation, String title,
					String xLabel, String yLabel) {
		name = builder.createAreaChart(title, xLabel, yLabel);
		url = request.getContextPath() + "/servlet/displaychart?filename="
						+ name;
		return url;
	}

}

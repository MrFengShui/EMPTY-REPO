package pers.luan.web.tool.chart;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jfree.chart.plot.PlotOrientation;

import pers.luan.web.tool.Point2D;
import pers.luan.web.tool.Point3D;

public class ChartFactory {

	private final HttpServletRequest request;
	private final ChartBuilder builder;
	
	private List<String> list;

	private String name, url;

	public ChartFactory(HttpServletRequest request, ChartBuilder builder) {
		this.request = request;
		this.builder = builder;
		init();
	}
	
	private void init() {
		list = new ArrayList<>();
	}

	public void showBarChart() {
		name = builder.createBar3DChart(PlotOrientation.HORIZONTAL, "Sample 3D-Bar Chart",
						"X-Axis Label", "Y-Axis Label", true, true, true);
		url = request.getContextPath() + "/servlet/displaychart?filename="
						+ name;
		list.add(url);

		name = builder.createBar2DChart(PlotOrientation.HORIZONTAL, "Sample Bar Chart",
						"X-Axis Label", "Y-Axis Label", true, true, true);
		url = request.getContextPath() + "/servlet/displaychart?filename="
						+ name;
		list.add(url);
	}

	public void showLineChart() {
		name = builder.createAreaChart("Sample Area Chart",
						"X-Axis Label", "Y-Axis Label");
		url = request.getContextPath() + "/servlet/displaychart?filename="
						+ name;
		list.add(url);

		name = builder.createLine3DChart(PlotOrientation.HORIZONTAL, "Sample 3D-Line Chart",
						"X-Axis Label", "Y-Axis Label", true, true, true);
		url = request.getContextPath() + "/servlet/displaychart?filename="
						+ name;
		list.add(url);

		name = builder.createLine2DChart(PlotOrientation.HORIZONTAL, "Sample Line Chart",
						"X-Axis Label", "Y-Axis Label", true, true, true);
		url = request.getContextPath() + "/servlet/displaychart?filename="
						+ name;
		list.add(url);
	}

	public void showPieChart() {
		name = builder.createPie3DChart("Sample 3D-Pie Chart", true, true, true);
		url = request.getContextPath() + "/servlet/displaychart?filename="
						+ name;
		list.add(url);

		name = builder.createPie2DChart("Sample Pie Chart", true, true, true);
		url = request.getContextPath() + "/servlet/displaychart?filename="
						+ name;
		list.add(url);

		name = builder.createRingChart("Sample Ring Chart", true, true, true);
		url = request.getContextPath() + "/servlet/displaychart?filename="
						+ name;
		list.add(url);
	}

	public void showXYChart(List<List<Point2D>> dataArray) {
		name = builder.createScatterChart(PlotOrientation.HORIZONTAL, "Sample Scatter Chart",
						"X-Axis Label", "Y-Axis Label", true, true, true);
		url = request.getContextPath() + "/servlet/displaychart?filename="
						+ name;
		list.add(url);

		name = builder.createHistogramChart(PlotOrientation.HORIZONTAL,
						"Sample Higtogram Chart", "X-Axis Label",
						"Y-Axis Label", true, true, true);
		url = request.getContextPath() + "/servlet/displaychart?filename="
						+ name;
		list.add(url);
		
//		name = builder.createHighLowChart(ohlcDataset,
//						"Sample Higtogram Chart", "X-Axis Label",
//						"Y-Axis Label", session);
//		url = request.getContextPath() + "/servlet/displaychart?filename="
//						+ name;
//		list.add(url);
	}
	
	public void showXYZChart(List<List<Point3D>> dataArray) {
		name = builder.createBubbleChart(PlotOrientation.HORIZONTAL, 
						"Sample Bubble Chart", "X-Axis Label", 
						"Y-Axis Label", true, true, true);
		url = request.getContextPath() + "/servlet/displaychart?filename="
						+ name;
		list.add(url);
	}
	
	public List<String> fetch() {
		return list;
	}

}

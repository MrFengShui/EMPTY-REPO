package pers.luan.web.tool.chart;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jfree.chart.plot.PlotOrientation;

import pers.luan.web.bean.ChartLayoutBean;
import pers.luan.web.tool.Point2D;
import pers.luan.web.tool.Point3D;

public class ChartFactory {

	public static final String H2D = "2dh";
	public static final String V2D = "2dv";
	public static final String H3D = "3dh";
	public static final String V3D = "3dv";
	public static final String C2D = "2d";
	public static final String C3D = "3d";
	
	private final HttpServletRequest request;
	private final ChartBuilder builder;
	
	private ChartProduct product;
	private ChartLayoutBean bean;

	private List<String> list;

	private String name, url;

	public ChartFactory(HttpServletRequest request, ChartBuilder builder) {
		this.request = request;
		this.builder = builder;
	}

	public String showBarChart(ChartProduct product, String type) {
		switch (type) {
			case H2D:
				return product.create2DChart(PlotOrientation.HORIZONTAL,
								"Sample 2D-Bar Chart Horizontal", "X-Axis Label",
								"Y-Axis Label");
			case V2D:
				return product.create2DChart(PlotOrientation.VERTICAL,
								"Sample 2D-Bar Chart Vertical", "X-Axis Label",
								"Y-Axis Label");
			case H3D:
				return product.create3DChart(PlotOrientation.HORIZONTAL,
								"Sample 3D-Bar Chart Horizontal", "X-Axis Label",
								"Y-Axis Label");
			case V3D:
				return product.create3DChart(PlotOrientation.VERTICAL,
								"Sample 3D-Bar Chart Vertical", "X-Axis Label",
								"Y-Axis Label");
			default:
				return null;
		}
	}

	public String showLineChart(ChartProduct product, String type) {
		switch (type) {
			case H2D:
				return product.create2DChart(PlotOrientation.HORIZONTAL,
								"Sample 2D-Bar Chart Horizontal", "X-Axis Label",
								"Y-Axis Label");
			case V2D:
				return product.create2DChart(PlotOrientation.VERTICAL,
								"Sample 2D-Bar Chart Vertical", "X-Axis Label",
								"Y-Axis Label");
			case H3D:
				return product.create3DChart(PlotOrientation.HORIZONTAL,
								"Sample 3D-Bar Chart Horizontal", "X-Axis Label",
								"Y-Axis Label");
			case V3D:
				return product.create3DChart(PlotOrientation.VERTICAL,
								"Sample 3D-Bar Chart Vertical", "X-Axis Label",
								"Y-Axis Label");
			default:
				return null;
		}
	}
	
	public String showAreaChart(ChartProduct product) {
		return product.create2DChart(null, 
						"Sample 2D-Area Chart", "X-Axis Label", "Y-Axis Label");
	}
	
	public String showPieChart(ChartProduct product, String type) {
		switch (type) {
			case C2D:
				return product.create2DChart(null,
								"Sample 2D-Pie Chart Horizontal", "X-Axis Label",
								"Y-Axis Label");
			case C3D:
				return product.create3DChart(null,
								"Sample 3D-Pie Chart Horizontal", "X-Axis Label",
								"Y-Axis Label");
			default:
				return null;
		}
	}
	
	public String showRingChart(ChartProduct product) {
		return product.create2DChart(null,
								"Sample 2D-Ring Chart Horizontal", "X-Axis Label",
								"Y-Axis Label");
	}

	public List<ChartLayoutBean> produceAllCharts() {
		List<ChartLayoutBean> beanList = new ArrayList<>();
		
		product = new BarChartProduct(request, builder);
		list = new ArrayList<>();
		list.add(showBarChart(product, "2dh"));
		list.add(showBarChart(product, "2dv"));
		list.add(showBarChart(product, "3dh"));
		list.add(showBarChart(product, "3dv"));
		bean = new ChartLayoutBean();
		bean.setName("Bar Chart Display");
		bean.setList(list);
		beanList.add(bean);
		
		product = new LineChartProduct(request, builder);
		list = new ArrayList<>();
		list.add(showLineChart(product, H2D));
		list.add(showLineChart(product, V2D));
		list.add(showLineChart(product, H3D));
		list.add(showLineChart(product, V3D));
		bean = new ChartLayoutBean();
		bean.setName("Line Chart Display");
		bean.setList(list);
		beanList.add(bean);
		
		product = new AreaChartProduct(request, builder);
		list = new ArrayList<>();
		list.add(showAreaChart(product));
		bean = new ChartLayoutBean();
		bean.setName("Area Chart Display");
		bean.setList(list);
		beanList.add(bean);
		
		product = new PieChartProduct(request, builder);
		list = new ArrayList<>();
		list.add(showPieChart(product, C2D));
		list.add(showPieChart(product, C3D));
		bean = new ChartLayoutBean();
		bean.setName("Pie Chart Display");
		bean.setList(list);
		beanList.add(bean);
		
		product = new RingChartProduct(request, builder);
		list = new ArrayList<>();
		list.add(showRingChart(product));
		bean = new ChartLayoutBean();
		bean.setName("Ring Chart Display");
		bean.setList(list);
		beanList.add(bean);
		return beanList;
	}

	public void showXYChart(List<List<Point2D>> dataArray) {
		name = builder.createScatterChart(PlotOrientation.HORIZONTAL,
						"Sample Scatter Chart", "X-Axis Label", "Y-Axis Label",
						true, true, true);
		url = request.getContextPath() + "/servlet/displaychart?filename="
						+ name;
		list.add(url);

		name = builder.createHistogramChart(PlotOrientation.HORIZONTAL,
						"Sample Higtogram Chart", "X-Axis Label",
						"Y-Axis Label", true, true, true);
		url = request.getContextPath() + "/servlet/displaychart?filename="
						+ name;
		list.add(url);

		// name = builder.createHighLowChart(ohlcDataset,
		// "Sample Higtogram Chart", "X-Axis Label",
		// "Y-Axis Label", session);
		// url = request.getContextPath() + "/servlet/displaychart?filename="
		// + name;
		// list.add(url);
	}

	public void showXYZChart(List<List<Point3D>> dataArray) {
		name = builder.createBubbleChart(PlotOrientation.HORIZONTAL,
						"Sample Bubble Chart", "X-Axis Label", "Y-Axis Label",
						true, true, true);
		url = request.getContextPath() + "/servlet/displaychart?filename="
						+ name;
		list.add(url);
	}

	public ChartProduct fetchProduct(String type) {
		switch (type) {
			case "AREA":
				return new AreaChartProduct(request, builder);
			case "BAR":
				return new BarChartProduct(request, builder);
			case "LINE":
				return new LineChartProduct(request, builder);
			case "PIE":
				return new PieChartProduct(request, builder);
			case "RING":
				return new RingChartProduct(request, builder);
			default:
				return null;
		}
	}

}

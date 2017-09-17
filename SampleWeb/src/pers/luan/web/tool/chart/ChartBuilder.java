package pers.luan.web.tool.chart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.OHLCDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYZDataset;

import pers.luan.web.tool.Point2D;
import pers.luan.web.tool.Point3D;
import pers.luan.web.tool.data.DataCreator;
import pers.luan.web.tool.data.DatasetFactory;

public class ChartBuilder {

	private final HttpSession session;

	private final DataCreator creator;

	private DatasetFactory factory;

	private final int width, height;

	public ChartBuilder(HttpSession session, DataCreator creator, int width,
					int height) {
		this.session = session;
		this.creator = creator;
		this.width = width;
		this.height = height;
		init();
	}
	
	private void init() {
		List<Double> list = creator.createRandomData();
		List<List<Double>> lists = creator.createRandomArray();
		List<List<Point2D>> point2DList = new ArrayList<>();
		List<List<Point3D>> point3DList = new ArrayList<>();
		
		for (int i = 0; i < list.size(); i ++) {
			point2DList.add(creator.createRandom2DPoints());
			point3DList.add(creator.createRandom3DPoints());
		}
		
		factory = new DatasetFactory(list, lists, point2DList, point3DList);
	}

	public String createBar3DChart(PlotOrientation orientation, String title,
					String xLabel, String yLabel, boolean legend, boolean tip,
					boolean url) {
		try {
			CategoryDataset dataset = factory.produceBarData();
			JFreeChart chart = ChartFactory.createBarChart3D(title, xLabel,
							yLabel, dataset, orientation, legend, tip, url);
			String name = ServletUtilities.saveChartAsPNG(chart, width, height,
							null, session);
			return name;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public String createBar2DChart(PlotOrientation orientation, String title,
					String xLabel, String yLabel, boolean legend, boolean tip,
					boolean url) {
		try {
			CategoryDataset dataset = factory.produceBarData();
			JFreeChart chart = ChartFactory.createBarChart(title, xLabel,
							yLabel, dataset, orientation, legend, tip, url);
			String name = ServletUtilities.saveChartAsPNG(chart, width, height,
							null, session);
			return name;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public String createLine3DChart(PlotOrientation orientation, String title,
					String xLabel, String yLabel, boolean legend, boolean tip,
					boolean url) {
		try {
			CategoryDataset dataset = factory.produceLineData();
			JFreeChart chart = ChartFactory.createLineChart3D(title, xLabel,
							yLabel, dataset, orientation, legend, tip, url);
			String name = ServletUtilities.saveChartAsPNG(chart, width, height,
							null, session);
			return name;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public String createLine2DChart(PlotOrientation orientation, String title,
					String xLabel, String yLabel, boolean legend, boolean tip,
					boolean url) {
		try {
			CategoryDataset dataset = factory.produceLineData();
			JFreeChart chart = ChartFactory.createLineChart(title, xLabel,
							yLabel, dataset, orientation, legend, tip, url);
			String name = ServletUtilities.saveChartAsPNG(chart, width, height,
							null, session);
			return name;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public String createAreaChart(String title, String xLabel, String yLabel) {
		try {
			CategoryDataset dataset = factory.produceAreaData();
			JFreeChart chart = ChartFactory.createAreaChart(title, xLabel,
							yLabel, dataset, PlotOrientation.VERTICAL, true,
							true, false);
			String name = ServletUtilities.saveChartAsPNG(chart, width, height,
							null, session);
			return name;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public String createPie3DChart(String title, boolean legend, boolean tip,
					boolean url) {
		try {
			PieDataset dataset = factory.producePieData();
			JFreeChart chart = ChartFactory.createPieChart3D(title, dataset,
							legend, tip, url);
			PiePlot3D plot = (PiePlot3D) chart.getPlot();
			plot.setStartAngle(90);
			plot.setForegroundAlpha(0.5f);
			plot.setInteriorGap(0.05);
			plot.setSimpleLabels(true);
			String name = ServletUtilities.saveChartAsPNG(chart, width, height,
							null, session);
			return name;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public String createPie2DChart(String title, boolean legend, boolean tip,
					boolean url) {
		try {
			PieDataset dataset = factory.producePieData();
			JFreeChart chart = ChartFactory.createPieChart(title, dataset,
							legend, tip, url);
			String name = ServletUtilities.saveChartAsPNG(chart, width, height,
							null, session);
			return name;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public String createRingChart(String title, boolean legend, boolean tip,
					boolean url) {
		try {
			PieDataset dataset = factory.produceRingData();
			JFreeChart chart = ChartFactory.createRingChart(title, dataset,
							legend, tip, url);
			String name = ServletUtilities.saveChartAsPNG(chart, width, height,
							null, session);
			return name;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public String createScatterChart(PlotOrientation orientation, String title,
					String xLabel, String yLabel, boolean legend, boolean tip,
					boolean url) {
		try {
			XYDataset dataset = factory.produceXYData();
			JFreeChart chart = ChartFactory.createScatterPlot(title, xLabel,
							yLabel, dataset, PlotOrientation.VERTICAL, legend,
							tip, url);
			String name = ServletUtilities.saveChartAsPNG(chart, width, height,
							null, session);
			return name;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public String createHistogramChart(PlotOrientation orientation,
					String title, String xLabel, String yLabel, boolean legend,
					boolean tip, boolean url) {
		try {
			IntervalXYDataset dataset = (IntervalXYDataset) factory.produceXYData();
			JFreeChart chart = ChartFactory.createHistogram(title, xLabel,
							yLabel, dataset, orientation, legend, tip, url);

			String name = ServletUtilities.saveChartAsPNG(chart, width, height,
							null, session);
			return name;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public String createBubbleChart(PlotOrientation orientation, String title,
					String xLabel, String yLabel, boolean legend, boolean tip,
					boolean url) {
		try {
			XYZDataset dataset = factory.produceXYZData();
			JFreeChart chart = ChartFactory.createBubbleChart(title, xLabel,
							yLabel, dataset, orientation, legend, tip, url);
			String name = ServletUtilities.saveChartAsPNG(chart, width, height,
							null, session);
			return name;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public String createHighLowChart(OHLCDataset dataset, String title,
					String xLabel, String yLabel, HttpSession session) {
		try {
			JFreeChart chart = ChartFactory.createHighLowChart(title, xLabel,
							yLabel, dataset, null, true);

			String name = ServletUtilities.saveChartAsPNG(chart, width, height,
							null, session);
			return name;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}

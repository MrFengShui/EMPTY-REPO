package pers.luan.web.tool;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class ChartBuilder {

	public CategoryDataset createDataset(List<Float> list, boolean flag) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		int cycle = list.size();
		
		for (int i = 0; i < cycle; i ++) {
			if (flag) {
				list = DataBuilder.createRandomData(cycle);
				String label = "Item_" + i;
				
				for (int j = 0; j < list.size(); j ++) {
					dataset.addValue(list.get(j), label, "Label_" + j);
				}
			} else {
				dataset.addValue(list.get(i), "Item_" + i, "");
			}
		}
		
		return dataset;
	}
	
	@SuppressWarnings("unchecked")
	public XYDataset createXYDataset(List<Float>... lists) {
		XYSeriesCollection dataset = new XYSeriesCollection();
		
		for (int i = 0; i < lists.length; i ++) {
			XYSeries series = new XYSeries("Item_" + i);
			List<Float> item = lists[i];
			List<Float> list = DataBuilder.createRandomData(item.size());
			
			for (int j = 0; j < item.size(); j ++) {
				series.add(list.get(j), item.get(j));
			}
			
			dataset.addSeries(series);
		}
		
		return dataset;
	}
	
	public PieDataset createPieDateset(List<Float> list) {
		DefaultPieDataset dataset = new DefaultPieDataset( );
		int cycle = list.size();	
		
		for (int i = 0; i < cycle; i ++) {
			dataset.setValue("Item_" + i, list.get(i));
		}
		
		return dataset;		
	}
	
	public String createBar3DChart(CategoryDataset dataset, String title, String xLabel, String yLabel, HttpSession session) {
		try {
			JFreeChart chart = ChartFactory.createBarChart3D(
					title, xLabel, yLabel, 
					dataset,
					PlotOrientation.VERTICAL,
					true, true, false
				);
			
			String name = ServletUtilities.saveChartAsPNG(chart, 480, 360, null, session);
			return name;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String createBarChart(CategoryDataset dataset, String title, String xLabel, String yLabel, HttpSession session) {
		try {
			JFreeChart chart = ChartFactory.createBarChart(
					title, xLabel, yLabel, 
					dataset,
					PlotOrientation.VERTICAL,
					true, true, false
				);
			
			String name = ServletUtilities.saveChartAsPNG(chart, 480, 360, null, session);
			return name;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String createLine3DChart(CategoryDataset dataset, String title, String xLabel, String yLabel, HttpSession session) {
		try {
			JFreeChart chart = ChartFactory.createLineChart3D(
						title, xLabel, yLabel, 
						dataset,
						PlotOrientation.VERTICAL,
						true, true, false
					);
			
			String name = ServletUtilities.saveChartAsPNG(chart, 480, 360, null, session);
			return name;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String createLineChart(CategoryDataset dataset, String title, String xLabel, String yLabel, HttpSession session) {
		try {
			JFreeChart chart = ChartFactory.createLineChart(
						title, xLabel, yLabel, 
						dataset,
						PlotOrientation.VERTICAL,
						true, true, false
					);
			
			String name = ServletUtilities.saveChartAsPNG(chart, 480, 360, null, session);
			return name;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String createPie3DChart(PieDataset dataset, String title, HttpSession session) {
		try {
			JFreeChart chart = ChartFactory.createPieChart3D(
					title,  
					dataset,
					true, true, false
				);
			
			PiePlot3D plot = (PiePlot3D) chart.getPlot();
			plot.setStartAngle(90);
			plot.setForegroundAlpha(0.5f);
			plot.setInteriorGap(0.05);
			plot.setSimpleLabels(true);
			String name = ServletUtilities.saveChartAsPNG(chart, 480, 360, null, session);
			return name;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String createPieChart(PieDataset dataset, String title, HttpSession session) {
		try {
			JFreeChart chart = ChartFactory.createPieChart(
					title,
					dataset,
					true, true, false
				);
			
			String name = ServletUtilities.saveChartAsPNG(chart, 480, 360, null, session);
			return name;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String createAreaChart(CategoryDataset dataset, String title, String xLabel, String yLabel, HttpSession session) {
		try {
			JFreeChart chart = ChartFactory.createAreaChart(
					title, xLabel, yLabel, 
					dataset, 
					PlotOrientation.VERTICAL, 
					true, true, false
				);
			
			String name = ServletUtilities.saveChartAsPNG(chart, 480, 360, null, session);
			return name;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String createScatterChart(XYDataset dataset, String title, String xLabel, String yLabel, HttpSession session) {
		try {
			JFreeChart chart = ChartFactory.createScatterPlot(
					title, xLabel, yLabel, 
					dataset, 
					PlotOrientation.VERTICAL, 
					true, true, false
				);
			
			String name = ServletUtilities.saveChartAsPNG(chart, 480, 360, null, session);
			return name;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String createRingChart(PieDataset dataset, String title, HttpSession session) {
		try {
			JFreeChart chart = ChartFactory.createRingChart(
					title, 
					dataset, 
					true, true, false
				);
			
			String name = ServletUtilities.saveChartAsPNG(chart, 480, 360, null, session);
			return name;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String createHistogramChart(IntervalXYDataset dataset, String title, String xLabel, String yLabel, HttpSession session) {
		try {
			JFreeChart chart = ChartFactory.createHistogram(
					title, xLabel, yLabel,
					dataset, 
					PlotOrientation.VERTICAL,
					true, true, false
				);
			
			String name = ServletUtilities.saveChartAsPNG(chart, 480, 360, null, session);
			return name;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}

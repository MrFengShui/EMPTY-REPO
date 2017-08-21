package pers.luan.web.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pers.luan.web.tool.ChartBuilder;
import pers.luan.web.tool.DataBuilder;

@Controller
public class MainAction {

	private CategoryDataset dataset;
	private XYDataset xyDataset;
	private PieDataset pieDataset;
	
	private String name, url;
	
	@RequestMapping("/demo/chart")
	public String left(HttpServletRequest request, Model model) throws IOException {
		HttpSession session = request.getSession();
		List<Float> dataList = DataBuilder.createRandomData(-1);
		List<String> pathList = new ArrayList<>();
		
		ChartBuilder builder = new ChartBuilder();		
		showBarChart(request, builder, dataList, pathList, session);
		showLineChart(request, builder, dataList, pathList, session);		
		showPieChart(request, builder, dataList, pathList, session);
		showXYChart(request, builder, dataList, pathList, session);
		
		model.addAttribute("list", pathList);
		return "demo/chart";
	}
	
//	@RequestMapping("/demo/chart")
//	public String right(@RequestParam(name="img", required=true) String imgurl, Model model) {
//		model.addAttribute("charturl", imgurl);
//		return "demo/chart";
//	}
	
	private void showBarChart(HttpServletRequest request, ChartBuilder builder, List<Float> dataList, List<String> pathList, HttpSession session) {
		dataset = builder.createDataset(dataList, false);
		
		name = builder.createBar3DChart(
					dataset, 
					"Sample 3D-Bar Chart", "X-Axis Label", "y-Axis Label", 
					session
				);
		url = request.getContextPath() + "/servlet/displaychart?filename=" + name;
		pathList.add(url);
		
		name = builder.createBarChart(
					dataset, 
					"Sample Bar Chart", "X-Axis Label", "Y-Axis Label", 
					session
				);
		url = request.getContextPath() + "/servlet/displaychart?filename=" + name;
		pathList.add(url);
	}
	
	private void showLineChart(HttpServletRequest request, ChartBuilder builder, List<Float> dataList, List<String> pathList, HttpSession session) {
		dataset = builder.createDataset(dataList, true);	

		name = builder.createAreaChart(
				dataset, 
				"Sample Area Chart", "X-Axis Label", "Y-Axis Label", 
				session
			);
		url = request.getContextPath() + "/servlet/displaychart?filename=" + name;
		pathList.add(url);
		
		name = builder.createLine3DChart(
				dataset, 
				"Sample 3D-Line Chart", "X-Axis Label", "Y-Axis Label", 
				session
			);
		url = request.getContextPath() + "/servlet/displaychart?filename=" + name;
		pathList.add(url);
		
		name = builder.createLineChart(
				dataset, 
				"Sample Line Chart", "X-Axis Label", "Y-Axis Label", 
				session
			);
		url = request.getContextPath() + "/servlet/displaychart?filename=" + name;
		pathList.add(url);
	}
	
	private void showPieChart(HttpServletRequest request, ChartBuilder builder, List<Float> dataList, List<String> pathList, HttpSession session) {
		pieDataset = builder.createPieDateset(dataList);
		
		name = builder.createPie3DChart(pieDataset, "Sample 3D-Pie Chart", session);
		url = request.getContextPath() + "/servlet/displaychart?filename=" + name;
		pathList.add(url);
		
		name = builder.createPieChart(pieDataset, "Sample Pie Chart", session);
		url = request.getContextPath() + "/servlet/displaychart?filename=" + name;
		pathList.add(url);
		
		name = builder.createRingChart(pieDataset, "Sample Ring Chart", session);
		url = request.getContextPath() + "/servlet/displaychart?filename=" + name;
		pathList.add(url);
	}
	
	private void showXYChart(HttpServletRequest request, ChartBuilder builder, List<Float> dataList, List<String> pathList, HttpSession session) {
		xyDataset = builder.createXYDataset(DataBuilder.createRandomArray(-1));
		
		name = builder.createScatterChart(xyDataset, "Sample Scatter Chart", "X-Axis Label", "Y-Axis Label", session);
		url = request.getContextPath() + "/servlet/displaychart?filename=" + name;
		pathList.add(url);
		
		name = builder.createHistogramChart((IntervalXYDataset) xyDataset, "Sample Higtogram Chart", "X-Axis Label", "Y-Axis Label", session);
		url = request.getContextPath() + "/servlet/displaychart?filename=" + name;
		pathList.add(url);
	}
	
}

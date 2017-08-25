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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pers.luan.web.bean.form.ChartFormBean;
import pers.luan.web.tool.ChartBuilder;
import pers.luan.web.tool.DataBuilder;

@Controller
public class ChartAction {

	private CategoryDataset dataset;
	private XYDataset xyDataset;
	private PieDataset pieDataset;

	private String name, url;

	@RequestMapping(value = "/demo/chart", method = RequestMethod.GET)
	public ModelAndView doGetForm(HttpServletRequest request,
					@RequestParam(name = "layout", required = true) String layout,
					@RequestParam(name = "type", required = true) String type, 
					@RequestParam(name = "method", required = false) String method,
					ModelMap map)
					throws IOException {
		HttpSession session = request.getSession();
		
		switch (type) {
			case "bar":
				break;
			default:
				List<Float>[] dataArray = DataBuilder.createRandomArray(-1, 40, 80);
				List<Float> dataList = DataBuilder.createRandomData(-1, 40, 80);
				List<String> pathList = new ArrayList<>();
	
				ChartBuilder builder = new ChartBuilder(40, 80);
				showBarChart(request, builder, dataList, pathList, session);
				showLineChart(request, builder, dataList, pathList, session);
				showPieChart(request, builder, dataList, pathList, session);
				showXYChart(request, builder, dataArray, pathList, session);
	
				map.addAttribute("list", pathList);
				break;
		}
		
		map.addAttribute("condition", layout);
		return new ModelAndView("demo/chart", "chartFormBean", new ChartFormBean());
	}
	
	@RequestMapping(value = "/demo/chart", method = RequestMethod.POST)
	public void doPostForm(HttpServletRequest request,
					@ModelAttribute("chartFormBean") ChartFormBean bean,
					ModelMap map) {
		int count = Integer.valueOf(bean.getCount());
		float minBound = Float.valueOf(bean.getMinBound());
		float maxBound = Float.valueOf(bean.getMaxBound());
		
		if (minBound < maxBound) {
			HttpSession session = request.getSession();
			List<Float> dataList = DataBuilder.createRandomData(count, minBound, maxBound);
			ChartBuilder builder = new ChartBuilder(minBound, maxBound);
			
			dataset = builder.createDataset(dataList, false);
	
			name = builder.createBar3DChart(dataset, "Sample 3D-Bar Chart", "X-Axis Label",
							"y-Axis Label", session);
			url = request.getContextPath() + "/servlet/displaychart?filename=" + name;
			map.addAttribute("img3d", url);
	
			name = builder.createBarChart(dataset, "Sample 2D-Bar Chart", "X-Axis Label", "Y-Axis Label",
							session);
			url = request.getContextPath() + "/servlet/displaychart?filename=" + name;
			map.addAttribute("img2d", url);
			map.addAttribute("condition", "both");
		}
	}

	private void showBarChart(HttpServletRequest request, ChartBuilder builder,
					List<Float> dataList, List<String> pathList, HttpSession session) {
		dataset = builder.createDataset(dataList, false);

		name = builder.createBar3DChart(dataset, "Sample 3D-Bar Chart", "X-Axis Label",
						"y-Axis Label", session);
		url = request.getContextPath() + "/servlet/displaychart?filename=" + name;
		pathList.add(url);

		name = builder.createBarChart(dataset, "Sample Bar Chart", "X-Axis Label", "Y-Axis Label",
						session);
		url = request.getContextPath() + "/servlet/displaychart?filename=" + name;
		pathList.add(url);
	}

	private void showLineChart(HttpServletRequest request, ChartBuilder builder,
					List<Float> dataList, List<String> pathList, HttpSession session) {
		dataset = builder.createDataset(dataList, true);

		name = builder.createAreaChart(dataset, "Sample Area Chart", "X-Axis Label", "Y-Axis Label",
						session);
		url = request.getContextPath() + "/servlet/displaychart?filename=" + name;
		pathList.add(url);

		name = builder.createLine3DChart(dataset, "Sample 3D-Line Chart", "X-Axis Label",
						"Y-Axis Label", session);
		url = request.getContextPath() + "/servlet/displaychart?filename=" + name;
		pathList.add(url);

		name = builder.createLineChart(dataset, "Sample Line Chart", "X-Axis Label", "Y-Axis Label",
						session);
		url = request.getContextPath() + "/servlet/displaychart?filename=" + name;
		pathList.add(url);
	}

	private void showPieChart(HttpServletRequest request, ChartBuilder builder,
					List<Float> dataList, List<String> pathList, HttpSession session) {
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

	private void showXYChart(HttpServletRequest request, ChartBuilder builder, List<Float>[] dataArray,
					List<String> pathList, HttpSession session) {
		xyDataset = builder.createXYDataset(dataArray);

		name = builder.createScatterChart(xyDataset, "Sample Scatter Chart", "X-Axis Label",
						"Y-Axis Label", session);
		url = request.getContextPath() + "/servlet/displaychart?filename=" + name;
		pathList.add(url);

		name = builder.createHistogramChart((IntervalXYDataset) xyDataset, "Sample Higtogram Chart",
						"X-Axis Label", "Y-Axis Label", session);
		url = request.getContextPath() + "/servlet/displaychart?filename=" + name;
		pathList.add(url);
	}

}

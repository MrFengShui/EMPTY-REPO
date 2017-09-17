package pers.luan.web.action.chart;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jfree.chart.plot.PlotOrientation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pers.luan.web.bean.form.ChartFormBean;
import pers.luan.web.tool.chart.ChartBuilder;
import pers.luan.web.tool.data.DataCreator;

@Controller
public class LoadingChartAction {

	private String name, url;

	@RequestMapping(value = "/demo/chart/loading-chart",
					method = RequestMethod.GET)
	public ModelAndView doGetForm(ModelMap map) throws IOException {
		map.addAttribute("condition", "two");
		return new ModelAndView("demo/chart/loading-chart", "chartFormBean",
						new ChartFormBean());
	}

	@RequestMapping(value = "/demo/chart/loading-chart",
					method = RequestMethod.POST)
	public void doPostForm(HttpServletRequest request,
					@RequestParam("type") String type,
					@ModelAttribute("chartFormBean") ChartFormBean bean,
					ModelMap map) {
		int width = 480;
		int height = 270;
		int count = bean.getCount();
		float minBound = bean.getMinBound();
		float maxBound = bean.getMaxBound();

		if (minBound < maxBound) {
			HttpSession session = request.getSession();
			DataCreator creator = new DataCreator(count, minBound, maxBound);
			ChartBuilder builder = new ChartBuilder(session, creator, width,
							height);

			map.addAttribute("width", width);
			map.addAttribute("height", height);
			
			switch (type) {
				case "bar-chart":
					showBarChart(request, builder, map);
					map.addAttribute("condition", "two");
					break;
				case "line-chart":
					showLineChart();
					map.addAttribute("condition", "two");
					break;
			}
		}
	}

	private void showBarChart(HttpServletRequest request, ChartBuilder builder,
					ModelMap map) {
		name = builder.createBar2DChart(PlotOrientation.HORIZONTAL,
						"Sample 2D-Bar Chart Horizontal", "X-Axis Label",
						"Y-Axis Label", true, true, true);
		url = request.getContextPath() + "/servlet/displaychart?filename="
						+ name;
		map.addAttribute("img2dh", url);

		name = builder.createBar2DChart(PlotOrientation.VERTICAL,
						"Sample 2D-Bar Chart Vertical", "X-Axis Label",
						"Y-Axis Label", true, true, true);
		url = request.getContextPath() + "/servlet/displaychart?filename="
						+ name;
		map.addAttribute("img2dv", url);

		name = builder.createBar3DChart(PlotOrientation.HORIZONTAL,
						"Sample 3D-Bar Chart Horizontal", "X-Axis Label",
						"y-Axis Label", true, true, true);
		url = request.getContextPath() + "/servlet/displaychart?filename="
						+ name;
		map.addAttribute("img3dh", url);

		name = builder.createBar3DChart(PlotOrientation.VERTICAL,
						"Sample 3D-Bar Chart Vertical", "X-Axis Label",
						"y-Axis Label", true, true, true);
		url = request.getContextPath() + "/servlet/displaychart?filename="
						+ name;
		map.addAttribute("img3dv", url);
	}
	
	private void showLineChart() {
		
	}

}

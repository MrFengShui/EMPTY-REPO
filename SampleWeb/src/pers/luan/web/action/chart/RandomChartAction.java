package pers.luan.web.action.chart;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pers.luan.web.bean.form.ChartFormBean;
import pers.luan.web.tool.chart.ChartBuilder;
import pers.luan.web.tool.chart.ChartFactory;
import pers.luan.web.tool.chart.ChartProduct;
import pers.luan.web.tool.data.DataCreator;

@Controller
public class RandomChartAction {

	private ChartProduct product;
	
	@RequestMapping(value = "/demo/chart/random-chart",
					method = RequestMethod.GET)
	public ModelAndView doGetForm(ModelMap map) throws IOException {
		map.addAttribute("condition", "two");
		return new ModelAndView("demo/chart/random-chart", "chartFormBean",
						new ChartFormBean());
	}

	@RequestMapping(value = "/demo/chart/random-chart",
					method = RequestMethod.POST)
	public void doPostForm(HttpServletRequest request,
					@RequestParam("type") String type,
					@ModelAttribute("chartFormBean") ChartFormBean bean,
					ModelMap map) {
		int width = 400;
		int height = 300;
		int count = bean.getCount();
		float minBound = bean.getMinBound();
		float maxBound = bean.getMaxBound();

		if (minBound < maxBound) {
			HttpSession session = request.getSession();
			DataCreator creator = new DataCreator(count, minBound, maxBound);
			ChartBuilder builder = new ChartBuilder(session, creator, width,
							height);
			ChartFactory factory = new ChartFactory(request, builder);

			map.addAttribute("width", width);
			map.addAttribute("height", height);

			switch (type) {
				case "bar-chart":
					product = factory.fetchProduct("BAR");
					map.addAttribute("img2dh", factory.showBarChart(product, ChartFactory.H2D));
					map.addAttribute("img2dv", factory.showBarChart(product, ChartFactory.V2D));
					map.addAttribute("img3dh", factory.showBarChart(product, ChartFactory.H3D));
					map.addAttribute("img3dv", factory.showBarChart(product, ChartFactory.V3D));
					map.addAttribute("condition", "two");
					break;
				case "line-chart":
					product = factory.fetchProduct("LINE");
					map.addAttribute("img2dh", factory.showLineChart(product, ChartFactory.H2D));
					map.addAttribute("img2dv", factory.showLineChart(product, ChartFactory.V2D));
					map.addAttribute("img3dh", factory.showLineChart(product, ChartFactory.H3D));
					map.addAttribute("img3dv", factory.showLineChart(product, ChartFactory.V3D));
					map.addAttribute("condition", "two");
					break;
				case "pie-chart":
					product = factory.fetchProduct("PIE");
					map.addAttribute("img2d", factory.showPieChart(product, ChartFactory.C2D));
					map.addAttribute("img3d", factory.showPieChart(product, ChartFactory.C3D));
					map.addAttribute("condition", "one");
					break;
			}
		}
	}

}

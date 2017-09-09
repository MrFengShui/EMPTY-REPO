package pers.luan.web.action.chart;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pers.luan.web.bean.form.ChartFormBean;
import pers.luan.web.tool.chart.ChartBuilder;
import pers.luan.web.tool.chart.ChartFactory;
import pers.luan.web.tool.chart.DataCreator;

@Controller
public class AllChartAction {

	@RequestMapping(value = "/demo/chart/all-chart", method = RequestMethod.GET)
	public ModelAndView doGetForm() throws IOException {
		return new ModelAndView("demo/chart/all-chart", "chartFormBean",
						new ChartFormBean());
	}

	@RequestMapping(value = "/demo/chart/all-chart",
					method = RequestMethod.POST)
	public void doPostForm(HttpServletRequest request,
					@ModelAttribute("chartFormBean") ChartFormBean bean,
					ModelMap map) {
		int width = 560;
		int height = 315;
		int count = bean.getCount();
		float minBound = bean.getMinBound();
		float maxBound = bean.getMaxBound();

		if (minBound < maxBound) {
			HttpSession session = request.getSession();
			DataCreator creator = new DataCreator(count, minBound, maxBound);
			ChartBuilder builder = new ChartBuilder(session, creator, width, height);
			ChartFactory factory = new ChartFactory(request, builder);
			factory.showBarChart();
			factory.showLineChart();
			factory.showPieChart();
			factory.showXYChart(null);
			factory.showXYZChart(null);
			
			map.addAttribute("width", width);
			map.addAttribute("height", height);
			map.addAttribute("list", factory.fetch());
		}
	}

}

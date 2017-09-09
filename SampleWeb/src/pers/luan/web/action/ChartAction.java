package pers.luan.web.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jfree.chart.plot.PlotOrientation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pers.luan.web.bean.form.ChartFormBean;
import pers.luan.web.tool.chart.ChartBuilder;
import pers.luan.web.tool.chart.DataCreator;
import pers.luan.web.tool.chart.DatasetFactory;

@Controller
public class ChartAction {

	private String name, url;

	@RequestMapping(value = "/demo/chart", method = RequestMethod.GET)
	public ModelAndView doGetForm() throws IOException {
		return new ModelAndView("demo/chart", "chartFormBean",
						new ChartFormBean());
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
			DataCreator creator = new DataCreator(count, minBound, maxBound);
			int width = 560;
			int height = 315;

			DatasetFactory dsFactory = new DatasetFactory();
			dsFactory.set(creator);

			ChartBuilder builder = new ChartBuilder(session, dsFactory, width,
							height);

			name = builder.createBar3DChart(PlotOrientation.HORIZONTAL,
							"Sample 3D-Bar Chart", "X-Axis Label",
							"y-Axis Label", true, true, true);
			url = request.getContextPath() + "/servlet/displaychart?filename="
							+ name;
			map.addAttribute("img3d", url);

			name = builder.createBar2DChart(PlotOrientation.HORIZONTAL,
							"Sample 2D-Bar Chart", "X-Axis Label",
							"Y-Axis Label", true, true, true);
			url = request.getContextPath() + "/servlet/displaychart?filename="
							+ name;
			map.addAttribute("img2d", url);
			map.addAttribute("condition", "both");
		}
	}

}

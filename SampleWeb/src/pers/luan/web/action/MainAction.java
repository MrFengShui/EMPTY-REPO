package pers.luan.web.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainAction {

	@RequestMapping("/demo/chart")
	public String left(HttpServletRequest request, Model model) throws IOException {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(100, "Apple", "");
		dataset.addValue(200, "Pear", "");
		dataset.addValue(300, "Grape", "");
		dataset.addValue(400, "Banana", "");
		dataset.addValue(500, "Litchi", "");
		
		JFreeChart chart = ChartFactory.createBarChart3D(
					"Fruit Yield Chart", 
					"Fruit Name", "Fruit Yield", 
					dataset,
					PlotOrientation.VERTICAL,
					true,
					false,
					false
				);
		
		String name = ServletUtilities.saveChartAsPNG(chart, 800, 600, null, request.getSession());
		String url = request.getContextPath() + "/servlet/displaychart?filename=" + name;
		model.addAttribute("charturl", url);
		return "demo/chart";
	}
	
//	@RequestMapping("/demo/chart")
//	public String right(@RequestParam(name="img", required=true) String imgurl, Model model) {
//		model.addAttribute("charturl", imgurl);
//		return "demo/chart";
//	}
	
}

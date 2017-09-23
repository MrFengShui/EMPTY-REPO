package pers.luan.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import pers.luan.web.bean.tag.TreeTagBean;
import pers.luan.web.tool.TreeBuilder;

@Controller
public class TestAction {

	@RequestMapping("/test")
	public String test(HttpServletRequest request, ModelMap map) {
		String path = getClass().getResource("/pers/luan/web/json/tree.json")
						.toExternalForm().replace("file:", "");
		TreeBuilder treeBuilder = new TreeBuilder();
		List<TreeTagBean> treeList = treeBuilder.parse(path);
		map.addAttribute("tree", treeList);
		map.addAttribute("title", "Sample Title");		
		return "test";
	}

}

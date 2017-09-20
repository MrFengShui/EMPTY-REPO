package pers.luan.web.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import pers.luan.web.bean.MenuItemBean;
import pers.luan.web.tool.MenuBuilder;

@Controller
public class TestAction {

	@RequestMapping("/test")
	public String test(ModelMap map) {
		String path = getClass().getResource("/pers/luan/web/json/menu.json")
						.toExternalForm().replace("file:", "");
		MenuBuilder builder = new MenuBuilder();
		List<MenuItemBean> list = builder.parse(path);
		List<MenuItemBean> root = new ArrayList<>();
		
		for (int i = 0; i < list.size(); i ++) {
			MenuItemBean bean = list.get(i);
			
			if (bean.getType().equals("menu")) {
				root.add(bean);
			}
		}
		map.addAttribute("root", root);
		map.addAttribute("nodes", list);
		return "test";
	}

}

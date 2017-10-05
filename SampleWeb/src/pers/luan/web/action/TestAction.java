package pers.luan.web.action;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import pers.luan.web.tool.JSONTool;

@Controller
public class TestAction {

//	private PrintWriter writer;
//	
//	@RequestMapping(value = "/test", method = RequestMethod.GET)
//	public ModelAndView doGet(HttpServletRequest request, HttpServletResponse response) {
//		return new ModelAndView("test", "testBean", new TestBean());
//	}
//	
//	@RequestMapping(value = "/test", method = RequestMethod.POST)
//	public void doPost(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
//		try {
//			String firstname = request.getParameter("firstname");
//			String lastname = request.getParameter("lastname");
//			writer = response.getWriter();
//			writer.println(firstname + "_" + lastname + "_return");
//			writer.flush();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			if (writer != null) {
//				writer.close();
//			}
//		}
//	}
	
	private FileReader reader;
	
	@RequestMapping("/test")
	public String show(ModelMap map) {
		try {
//			String path = getClass().getResource("/pers/luan/web/json/tree.json")
//							.toExternalForm().replace("file:", "");
//			reader = new FileReader(path);
//			JSONParser parser = new JSONParser();
//			JSONArray json = (JSONArray) parser.parse(reader);
//			map.addAttribute("json", json.toJSONString().replaceAll("\"", "'"));
//			
//			int size = 0;
//			
//			for (int i = 0; i < json.size(); i ++) {
//				JSONObject item = (JSONObject) json.get(i);
//				size = Math.max(size, JSONTool.measure(item, 0, ""));
//			}
//			
//			map.addAttribute("size", size);
			String path = getClass().getResource("/pers/luan/web/json/menu.json")
							.toExternalForm().replace("file:", "");
			reader = new FileReader(path);
			JSONParser parser = new JSONParser();
			JSONArray json = (JSONArray) parser.parse(reader);
			map.addAttribute("json", json.toJSONString().replaceAll("\"", "'"));
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return "test";
	}

}

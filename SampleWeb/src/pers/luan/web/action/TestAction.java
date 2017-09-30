package pers.luan.web.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pers.luan.web.bean.TestBean;

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
	
	@RequestMapping("/test")
	public String show() {
		return "test";
	}

}

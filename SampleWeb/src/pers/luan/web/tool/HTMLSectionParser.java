package pers.luan.web.tool;

import java.util.List;

public class HTMLSectionParser {

	public static List<String> parseHTML(List<String> list) {
		int start = list.indexOf("<!DOCTYPE html>");
		int end = list.lastIndexOf("</html>");
		return list.subList(start, end);
	}
	
	public static List<String> parseBody(List<String> list) {
		int start = list.indexOf("<body>");
		int end = list.indexOf("</body>");
		return list.subList(start, end);
	}
	
}

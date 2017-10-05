package pers.luan.web.tool;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONTool {

	public static int measure(JSONObject item, int size, String space) {
		String text = space + item.get("text").toString();
			
		if (item.get("type").toString().equals("node")) {
			space += "   ";
			JSONArray array = (JSONArray) item.get("child");
			
			for (int i = 0; i < array.size(); i ++) {
				JSONObject temp = (JSONObject) array.get(i);
				size = measure(temp, size, space);
			}
		}
		
		return Math.max(size, text.length());
	}
	
}

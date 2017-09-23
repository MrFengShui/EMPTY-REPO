package pers.luan.web.tool;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import pers.luan.web.bean.tag.MenuTagBean;

public class MenuBuilder {
	
	private Reader reader;

	@SuppressWarnings("unchecked")
	public List<MenuTagBean> parse(String path) {
		try {
			reader = new FileReader(path);
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(reader);
			Set<Entry<Object, Object>> set = json.entrySet();
			List<MenuTagBean> list = new ArrayList<>();
			
			for (Entry<Object, Object> entry : set) {
				JSONObject object = (JSONObject) entry.getValue();
				list = buildMenu(object, list);
			}
			return list;
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

		return null;
	}

	public List<MenuTagBean> buildMenu(JSONObject json, List<MenuTagBean> list) {
		Stack<JSONObject> stack = new Stack<>();
		stack.push(json);
		
		while (!stack.empty()) {
			JSONObject temp = stack.pop();
			MenuTagBean bean = new MenuTagBean();
			bean.setID(temp.get("id").toString());
			bean.setText(temp.get("text").toString());
			bean.setType(temp.get("type").toString());
			bean.setIcon(temp.get("icon").toString());
			
			if (!bean.getType().equals("item")) {
				List<MenuTagBean> beanList = new ArrayList<>();
				JSONArray array = (JSONArray) temp.get("list");
				
				for (int i = 0; i < array.size(); i ++) {
					JSONObject item = (JSONObject) array.get(i);
					MenuTagBean itemBean = new MenuTagBean();
					itemBean.setID(item.get("id").toString());
					itemBean.setText(item.get("text").toString());
					itemBean.setType(item.get("type").toString());
					itemBean.setIcon(item.get("icon").toString());
					
					if (item.get("type").equals("item")) {
						itemBean.setLink(item.get("link").toString());
					}
					
					beanList.add(itemBean);
					
					if (!item.get("type").equals("item")) {
						stack.push(item);
					}
				}
				
				bean.setList(beanList);
				list.add(bean);
			}
		}
		
		Collections.sort(list, new Comparator<MenuTagBean>() {

			@Override
			public int compare(MenuTagBean o1, MenuTagBean o2) {
				return o1.getID().compareTo(o2.getID());
			}
			
		});
		return list;
	}

	public static void printMenu(List<MenuTagBean> list) {
		for (MenuTagBean item : list) {
			System.out.println(item + "\n");
		}
	}
	
}

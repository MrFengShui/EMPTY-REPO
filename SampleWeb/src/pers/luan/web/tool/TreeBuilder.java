package pers.luan.web.tool;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import pers.luan.web.bean.TreeNodeBean;

public class TreeBuilder {
	
	private Reader reader;

	public List<TreeNodeBean> parse(String path) {
		try {
			reader = new FileReader(path);
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(reader);
			List<TreeNodeBean> list = new ArrayList<>();
			
			for (Object key : json.keySet()) {
				TreeNodeBean bean = buildTree(json, key.toString());
				list.add(bean);
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
	
	public TreeNodeBean buildTree(JSONObject json, String key) {
		TreeNodeBean node = new TreeNodeBean();
		JSONObject rootJSON = (JSONObject) json.get(key);
		String title = rootJSON.get("title").toString();
		String place = rootJSON.get("place").toString();
		JSONArray array = (JSONArray) rootJSON.get("list");
		node.setTitle(title);
		node.setPlace(place);
		recursiveTree(node, array);
		return node;
	}

	private void recursiveTree(TreeNodeBean node, JSONArray array) {
		if (array != null) {
			List<TreeNodeBean> list = new ArrayList<>();
			
			for (int i = 0; i < array.size(); i ++) {
				JSONObject json = (JSONObject) array.get(i);
				String title = json.get("title").toString();
				String place = json.get("place").toString();
				JSONArray items = (JSONArray) json.get("list");
				TreeNodeBean item = new TreeNodeBean();
				item.setTitle(title);
				item.setPlace(place);
				list.add(item);
				recursiveTree(item, items);
			}
			
			node.setList(list);
		}
	}
	
	public void printTree(TreeNodeBean node, String space) {
		System.out.println(space + "|--" + node.getTitle());
		List<TreeNodeBean> list = node.getList();
		
		if (list != null) {
			space += "   ";
			
			for (TreeNodeBean item : list) {
				printTree(item, space);
			}
		}
	}
	
}

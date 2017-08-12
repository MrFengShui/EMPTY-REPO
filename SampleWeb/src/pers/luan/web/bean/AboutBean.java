package pers.luan.web.bean;

import java.util.List;

public class AboutBean {

	private String key, value;
	private List<String> list;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "AboutBean [key=" + key + ", value=" + value + ", list=" + list + "]";
	}
	
}

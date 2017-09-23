package pers.luan.web.bean.tag;

import java.util.List;

public class TreeTagBean {

	private String title;
	private String place;
	private List<TreeTagBean> list;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public List<TreeTagBean> getList() {
		return list;
	}
	
	public void setList(List<TreeTagBean> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "TreeTagBean [title=" + title + ", place=" + place + ", list=" + list + "]";
	}
	
}

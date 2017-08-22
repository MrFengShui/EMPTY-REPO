package pers.luan.web.bean;

import java.util.List;

public class TreeNodeBean {

	private String title;
	private String place;
	private List<TreeNodeBean> list;
	
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

	public List<TreeNodeBean> getList() {
		return list;
	}
	
	public void setList(List<TreeNodeBean> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "TreeNodeBean [title=" + title + ", place=" + place + ", list=" + list + "]";
	}
	
}

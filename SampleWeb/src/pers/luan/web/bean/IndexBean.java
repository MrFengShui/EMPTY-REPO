package pers.luan.web.bean;

import java.util.List;

public class IndexBean {

	private String title, place;
	private List<ItemBean> list;
	
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

	public List<ItemBean> getList() {
		return list;
	}

	public void setList(List<ItemBean> list) {
		this.list = list;
	}

	public static class ItemBean {
		
		private String place, title;

		public String getPlace() {
			return place;
		}

		public void setPlace(String place) {
			this.place = place;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		@Override
		public String toString() {
			return "ItemBean [place=" + place + ", title=" + title + "]";
		}
		
	}

	@Override
	public String toString() {
		return "IndexBean [title=" + title + ", place=" + place + ", list=" + list + "]";
	}
	
}

package pers.luan.web.bean.tag;

import java.util.List;

public class ModalDialogTagBean {

	private String title;
	private List<String> list;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public List<String> getList() {
		return list;
	}
	
	public void setList(List<String> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "ModalDialogTagBean [title=" + title + ", list=" + list + "]";
	}
	
}

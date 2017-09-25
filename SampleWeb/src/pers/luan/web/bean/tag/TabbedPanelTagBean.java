package pers.luan.web.bean.tag;

public class TabbedPanelTagBean {

	public static class TabbedTitleBean {

		private String ID, title;
		private boolean closable;

		public String getID() {
			return ID;
		}

		public void setID(String ID) {
			this.ID = ID;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public boolean isClosable() {
			return closable;
		}

		public void setClosable(boolean closable) {
			this.closable = closable;
		}

		@Override
		public String toString() {
			return "TabbedTitleBean [ID=" + ID + ", title=" + title + ", closable=" + closable + "]";
		}

	}

	public static class TabbedContentBean {

		private String ID, URL;

		public String getID() {
			return ID;
		}

		public void setID(String ID) {
			this.ID = ID;
		}

		public String getURL() {
			return URL;
		}

		public void setURL(String URL) {
			this.URL = URL;
		}

		@Override
		public String toString() {
			return "TabbedContentBean [ID=" + ID + ", URL=" + URL + "]";
		}

	}

}

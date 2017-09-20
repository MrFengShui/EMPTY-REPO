package pers.luan.web.tool.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import pers.luan.web.bean.MenuItemBean;

public class MenuTag extends TagSupport {

	private static final long serialVersionUID = -6430083995462892279L;

	private MenuList menuList;
	
	public MenuList getMenuList() {
		return menuList;
	}

	public void setMenuList(MenuList menuList) {
		this.menuList = menuList;
	}

	@Override
	public int doEndTag() throws JspException {
		JspWriter writer = this.pageContext.getOut();

		if (menuList == null) {
			try {
				writer.println("Not Found");
				return SKIP_BODY;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			writer.println("<div class='menu-list' id='" + menuList.getParent().getID() + "'>");
			
			for (MenuItemBean child : menuList.getChildren()) {
				writer.println("<a href='" 
								+ child.getLink() + "' class='menu-item medium-text-font div-center-center' id='" 
								+ child.getID() + "'>");
				writer.println(child.getText() + "&nbsp;");
				writer.println("<i class='fa fa-chevron-right' aria-hidden='true'></i>");
				writer.println("</a>");
			}
			
			writer.println("</div>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return SKIP_BODY;
	}

	@Override
	public int doStartTag() throws JspException {
		return EVAL_PAGE;
	}

	@Override
	public void release() {
		super.release();
		this.menuList = null;
	}
	
	public class MenuList {
		
		private MenuItemBean parent;
		private List<MenuItemBean> children;
		
		public MenuItemBean getParent() {
			return parent;
		}
		
		public void setParent(MenuItemBean parent) {
			this.parent = parent;
		}
		
		public List<MenuItemBean> getChildren() {
			return children;
		}
		
		public void setChildren(List<MenuItemBean> children) {
			this.children = children;
		}

		@Override
		public String toString() {
			return "MenuList [parent=" + parent + ", children=" + children
							+ "]";
		}
		
	}

}

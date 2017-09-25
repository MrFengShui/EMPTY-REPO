package pers.luan.web.tool.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TabbedItemTag extends TagSupport {

	private static final long serialVersionUID = 5946144739138132937L;
	
	private JspWriter writer;
	
	private String title, ID;
	private boolean closable;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public boolean isClosable() {
		return closable;
	}

	public void setClosable(boolean closable) {
		this.closable = closable;
	}

	@Override
	public int doEndTag() throws JspException {
		try {
			writer = this.pageContext.getOut();
			writer.println("<li class='tabbed-panel-item' id='" + ID + "'>");
			writer.println("<span class='medium-text-font div-center-center'>" + title + "</span>");
			
			if (closable) {
				writer.println("<button class='medium-text-font div-center-center'>");
				writer.println("<i class='fa fa-times' aria-hidden='true'></i>");
				writer.println("</button>");
			}			
			
			writer.println("</li>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return SKIP_BODY;
	}

	@Override
	public int doStartTag() throws JspException {
		writer = this.pageContext.getOut();

		if (title == null && ID == null) {
			try {
				writer.println("Not Found");
				return SKIP_BODY;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return EVAL_PAGE;
	}

	@Override
	public void release() {
		super.release();
	}

}

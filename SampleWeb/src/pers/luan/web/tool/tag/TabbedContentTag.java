package pers.luan.web.tool.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class TabbedContentTag extends BodyTagSupport {

	private static final long serialVersionUID = -3911292075914512431L;
	
	private BodyContent content;
	private JspWriter writer;
	
	private String text, ID;

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	@Override
	public int doAfterBody() throws JspException {
		if ((text = content.getString()) != null) {
			try {
				writer.println(text);
				writer.println("</div>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return SKIP_BODY;
	}

	@Override
	public void doInitBody() throws JspException {
		try {
			content = getBodyContent();
			writer = content.getEnclosingWriter();
			writer.println("<div class='tabbed-panel-content' id='" + ID + "'>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		super.doInitBody();
	}

	@Override
	public void release() {
		super.release();
	}

}

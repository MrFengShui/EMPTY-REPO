package pers.luan.web.tool.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class TitlePanelTag extends BodyTagSupport {

	private static final long serialVersionUID = -2222566351910385388L;

	private BodyContent content;
	private JspWriter writer;

	private String title, text;
	private boolean collapsed;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isCollapsed() {
		return collapsed;
	}

	public void setCollapsed(boolean collapsed) {
		this.collapsed = collapsed;
	}

	@Override
	public int doAfterBody() throws JspException {
		if ((text = content.getString()) != null) {
			try {
				writer.println(text);
				writer.println("</div>");
				writer.println("</li>");
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
			writer.println(collapsed
							? "<li class='title-panel' id='title-panel-collapsed'>"
							: "<li class='title-panel'>");
			writer.println("<div class='title-head-panel div-left-center'>");
			writer.println("<header class='medium-header-font div-left-center'>"
							+ title + "</header>");
			writer.println("<button class='big-text-font div-center-center'><i class='fa fa-angle-double-down' aria-hidden='true'></i></button>");
			writer.println("</div>");
			writer.println("<div class='title-body-panel'>");
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

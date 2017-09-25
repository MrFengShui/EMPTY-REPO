package pers.luan.web.tool.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class TabbedBodyTag extends BodyTagSupport {

	private static final long serialVersionUID = 3011509176062401867L;
	
	private BodyContent content;
	private JspWriter writer;
	
	private String text;

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
			writer.println("<div class='separator-horizontal'></div>");
			writer.println("<div class='tabbed-panel-body'>");
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

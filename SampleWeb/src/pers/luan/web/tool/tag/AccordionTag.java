package pers.luan.web.tool.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class AccordionTag extends BodyTagSupport {

	private static final long serialVersionUID = 2550151730831706760L;

	private BodyContent content;
	private JspWriter writer;
	
	private String text;

	@Override
	public int doAfterBody() throws JspException {
		if ((text = content.getString()) != null) {
			try {
				writer.println(text);
				writer.println("</ul>");
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
			writer.println("<ul class='accordian-panel medium-border'>");
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

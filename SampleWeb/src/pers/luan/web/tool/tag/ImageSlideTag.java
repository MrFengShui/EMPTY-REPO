package pers.luan.web.tool.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class ImageSlideTag extends TagSupport {

	private static final long serialVersionUID = 3131864019460311546L;
	
	private List<String> srcList;

	public List<String> getSrcList() {
		return srcList;
	}

	public void setSrcList(List<String> srcList) {
		this.srcList = srcList;
	}

	@Override
	public int doEndTag() throws JspException {
		JspWriter writer = this.pageContext.getOut();

		if (srcList == null || srcList.isEmpty()) {
			try {
				writer.println("Not Found");
				return SKIP_BODY;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			writer.println("<div class='image-slide medium-border-shadow' style='width: 800px; height: 600px;'>");
			writer.println("<div class='image-content div-center-center'>");
			writer.println("<img src='" + srcList.get(0) + "' width='100%' height='100%'>");
			writer.println("</div>");
			writer.println("&nbsp;<hr>&nbsp;");
			writer.println("<div class='image-items'>");
			
			for (String srcItem : srcList) {
				writer.println("<div class='image-item medium-border div-center-center' style='background-color: rgb(32, 32, 32);'>");
				writer.println("<img src='" + srcItem + "' width='100%' height='100%'>");
				writer.println("</div>");
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
		this.srcList = null;
	}

}

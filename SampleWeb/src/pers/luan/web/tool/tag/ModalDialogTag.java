package pers.luan.web.tool.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import pers.luan.web.bean.tag.ModalDialogTagBean;

public class ModalDialogTag extends TagSupport {

	private static final long serialVersionUID = -8653481533048003729L;

	private ModalDialogTagBean tagBean;

	public ModalDialogTagBean getTagBean() {
		return tagBean;
	}

	public void setTagBean(ModalDialogTagBean tagBean) {
		this.tagBean = tagBean;
	}

	@Override
	public int doEndTag() throws JspException {
		JspWriter writer = this.pageContext.getOut();

		if (tagBean == null) {
			try {
				writer.println("Not Found");
				return SKIP_BODY;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			writer.println("<div class='modal-dialog-backbone'>");
			writer.println("<div class='modal-dialog-head'>");
			writer.println("<header class='modal-dialog-title header-font div-left-center'>"
							+ tagBean.getTitle() + "</header>");
			writer.println("<button class='modal-close-button big-text-font' onclick='hide_modal_dialog();'><i class='fa fa-close' aria-hidden='true'></i></button>");
			writer.println("</div>");
			writer.println("<div class='modal-dialog-body'>");
			
			for (String item : tagBean.getList()) {
				writer.println(item);
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
		this.tagBean = null;
	}

}

package pers.luan.web.tool.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import pers.luan.web.bean.TreeNodeBean;

public class TreeTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7626707286430021271L;
	
	private List<TreeNodeBean> treeList;

	public List<TreeNodeBean> getTreeList() {
		return treeList;
	}

	public void setTreeList(List<TreeNodeBean> treeList) {
		this.treeList = treeList;
	}

	@Override
	public int doEndTag() throws JspException {
		JspWriter writer = this.pageContext.getOut();
		
		if (treeList == null || treeList.isEmpty()) {
			try {
				writer.println("Not Found");
				return SKIP_BODY;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		for (TreeNodeBean bean : treeList) {
			try {
				writer.println("<li class='main_tree_item'>");
				writeDOMTree(bean, writer, "");
				writer.println("</li>");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
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
		this.treeList = null;
	}
	
	private void writeDOMTree(TreeNodeBean node, JspWriter writer, String space) {
		try {
			List<TreeNodeBean> list = node.getList();
			
			if (list.isEmpty()) {
				writer.println("<a href='demo/" + node.getPlace() + "' target='page_frame' class='main_item_link'>");
				writer.println(space + "<i class='fa fa-file-o' aria-hidden='true'>&nbsp;&nbsp;" + node.getTitle() + "</i>");
				writer.println("</a>");
			} else {
				writer.println("<div class='main_node_div'>");
				writer.println("<div class='main_item_header'>");
				writer.println(space);
				writer.println("<button class='main_item_button'><i class='fa fa-folder-o' aria-hidden='true'></i></button>");
				writer.println("<h2>&nbsp;&nbsp;" + node.getTitle() + "</h2>");
				writer.println("</div>");
				writer.println("<div class='main_item_content'>");
				
				if (list != null) {
					space += "&nbsp;&nbsp;&nbsp;&nbsp;";
					
					for (TreeNodeBean item : list) {
						writeDOMTree(item, writer, space);
					}
				}
				
				writer.println("</div>");
				writer.println("</div>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

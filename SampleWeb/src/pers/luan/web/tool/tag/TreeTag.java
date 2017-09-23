package pers.luan.web.tool.tag;

import java.io.IOException;
import java.util.List;
import java.util.Stack;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import pers.luan.web.bean.tag.TreeTagBean;

public class TreeTag extends TagSupport {

	private static final long serialVersionUID = -7626707286430021271L;

	private JspWriter writer;
	
	private List<TreeTagBean> treeList;

	public List<TreeTagBean> getTreeList() {
		return treeList;
	}

	public void setTreeList(List<TreeTagBean> treeList) {
		this.treeList = treeList;
	}

	@Override
	public int doEndTag() throws JspException {
		writer = this.pageContext.getOut();
		int size = 0;

		for (TreeTagBean treeItem : treeList) {
			int temp = measure(treeItem);

			if (size < temp) {
				size = temp;
			}
		}

		for (TreeTagBean bean : treeList) {
			try {
				writer.println("<li style='width: " + (size + 25) + "%;'>");
				writeDOMTree(bean, writer, "", 1);
				writer.println("</li>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return SKIP_BODY;
	}

	@Override
	public int doStartTag() throws JspException {
		writer = this.pageContext.getOut();
		
		if (treeList == null || treeList.isEmpty()) {
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
		this.treeList = null;
	}

	private int measure(TreeTagBean node) {
		String space = "";
		int size = 0;
		Stack<TreeTagBean> stack = new Stack<>();
		stack.push(node);

		while (!stack.isEmpty()) {
			TreeTagBean bean = stack.pop();
			String text = space + bean.getTitle();

			if (text.length() > size) {
				size = text.length();
			}

			for (TreeTagBean item : bean.getList()) {
				if (!stack.contains(item)) {
					stack.push(item);
				}
			}

			space += "   ";
		}
		return size;
	}

	private void writeDOMTree(TreeTagBean node, JspWriter writer, String space,
					int depth) {
		try {
			List<TreeTagBean> list = node.getList();

			if (list.isEmpty()) {
				writer.println("<div class='tree-body'>");
				writer.println("<a href='demo/" + node.getPlace()
								+ "' target='page_frame' class='tree-leaf small-text-font'>");
				writer.println(space);
				writer.println("<i class='fa fa-flag' aria-hidden='true'></i>&nbsp;"
								+ node.getTitle());
				writer.println("</a>");
				writer.println("</div>");
			} else {
				writer.println("<div class='tree-body'>");
				writer.println("<a href='#' class='tree-node small-text-font'>");
				writer.println(space);
				writer.println("<i class='fa fa-plus-square-o' aria-hidden='true'></i>&nbsp;"
								+ node.getTitle());
				writer.println("</a>");
				writer.println("<div class='tree-nodes'>");

				if (list != null) {
					space += "&nbsp;&nbsp;&nbsp;";
					depth++;

					for (TreeTagBean item : list) {
						writeDOMTree(item, writer, space, depth);
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

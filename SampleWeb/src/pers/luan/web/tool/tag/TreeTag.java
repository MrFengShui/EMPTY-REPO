package pers.luan.web.tool.tag;

import java.io.IOException;
import java.util.List;
import java.util.Stack;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import pers.luan.web.bean.TreeNodeBean;

public class TreeTag extends TagSupport {

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

		int size = 0;

		for (TreeNodeBean treeItem : treeList) {
			int temp = measure(treeItem);

			if (size < temp) {
				size = temp;
			}
		}

		for (TreeNodeBean bean : treeList) {
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
		return EVAL_PAGE;
	}

	@Override
	public void release() {
		super.release();
		this.treeList = null;
	}

	private int measure(TreeNodeBean node) {
		String space = "";
		int size = 0;
		Stack<TreeNodeBean> stack = new Stack<>();
		stack.push(node);

		while (!stack.isEmpty()) {
			TreeNodeBean bean = stack.pop();
			String text = space + bean.getTitle();

			if (text.length() > size) {
				size = text.length();
			}

			for (TreeNodeBean item : bean.getList()) {
				if (!stack.contains(item)) {
					stack.push(item);
				}
			}

			space += "   ";
		}
		return size;
	}

	private void writeDOMTree(TreeNodeBean node, JspWriter writer, String space,
					int depth) {
		try {
			List<TreeNodeBean> list = node.getList();

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

					for (TreeNodeBean item : list) {
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

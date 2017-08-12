package pers.luan.web.tool;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProjectPath extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6279174679231163033L;
	
	private String path;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context = getServletContext();
		this.path = context.getRealPath(File.separator);
	}
	
	public String fetchPath() {
		return path;
	}
	
}

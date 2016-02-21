package org.bookmgr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bookmgr.dao.BookDao;

public class BookServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String method = request.getParameter("method");
		BookDao bookDao = new BookDao();

		if ("list".equals(method)) {
			request.setAttribute("books", bookDao.getBookList());
			request.getRequestDispatcher("index.jsp").forward(request, response);// 转发
		} else if ("details".equals(method)) {
			String id = request.getParameter("id");
			request.setAttribute("book", bookDao.getBookById(id));
			request.getRequestDispatcher("book_details.jsp").forward(request,response);// 转发

		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

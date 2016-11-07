package com.cjon.book.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjon.book.service.BookService;

/**
 * Servlet implementation class BookListServlet
 */
@WebServlet("/bookDetail")
public class BookDetailList extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public BookDetailList() {
        super();
    }

    
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String keyword = request.getParameter("keyword");
		String callback = request.getParameter("callback");
		
		System.out.println(keyword);
		System.out.println("키워드 이후로 ");
		BookService service = new BookService();
		String result = service.getListOne(keyword);
		
		response.setContentType("text/plain; charset=UTF8");
		PrintWriter out = response.getWriter();
		out.println(callback+"("+result+")");
		out.flush();
		out.close();
		
	}

		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

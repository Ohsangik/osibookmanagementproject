package com.cjon.book.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cjon.book.service.BookService;

/**
 * Servlet implementation class BookListServlet
 */
@WebServlet("/selectForPage")
public class BookSelectForPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public BookSelectForPage() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
		String page = request.getParameter("page");
		String callback = request.getParameter("callback");
		
		int intpage = Integer.parseInt(page);
				
		System.out.println(page);
		System.out.println("키워드 이후로 ");
		BookService service = new BookService();
		String result = service.selectForPage(intpage);
		
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

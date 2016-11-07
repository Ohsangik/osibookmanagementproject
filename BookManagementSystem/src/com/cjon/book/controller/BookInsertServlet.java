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
@WebServlet("/bookInsert")
public class BookInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public BookInsertServlet() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 입력받고
		
				System.out.println("인서트되었습니다.");
				
				String isbn = request.getParameter("isbn");
				String bookprice = request.getParameter("bookprice");
				String booktitle = request.getParameter("booktitle");
				String bookauthor = request.getParameter("bookauthor");
				
				String bookpub = request.getParameter("bookpub");
				String booktran = request.getParameter("booktran");
				String imgfile = request.getParameter("imgfile");
				
				String callback = request.getParameter("callback");
				
				System.out.println("insert로 들어왔습니다다다");
				//2.로직처리
			
				BookService service = new BookService();
				boolean result = service.insertBook(imgfile,isbn,bookprice,booktitle,bookauthor,bookpub,booktran);
				
				//3.출력처리
				response.setContentType("text/plain; charset=utf8");
				PrintWriter out = response.getWriter();
				out.println(callback+"("+result+")");
				out.flush();
				out.close();
	
		
	}

		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}

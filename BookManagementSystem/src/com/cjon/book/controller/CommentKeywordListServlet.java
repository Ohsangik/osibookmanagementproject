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
@WebServlet("/CommentKeywordList")
public class CommentKeywordListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public CommentKeywordListServlet() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 입력받고
		String search = request.getParameter("search");
		String filter = request.getParameter("filter");

		System.out.println(filter+"필터는 무엇으로 넘어왔는가");
		
		String callback = request.getParameter("callback");
		
		
		System.out.println("서평 리스트로 들어왔습니다다다");
		//2.로직처리
		HttpSession session = request.getSession(true);
		String email = (String) session.getAttribute("email");
		
		BookService service = new BookService();
		System.out.println(search);
		String result = service.commentKeywordList(search, filter);
		
		//3.출력처리
		response.setContentType("text/plain; charset=utf8");
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

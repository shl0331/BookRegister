package com.hansung.Project1;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    BookDAO dao = new BookDAO();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("action");
		if(action==null) {
			response.sendRedirect("Login.jsp");
			return;
		}
		
		if(action.equalsIgnoreCase("MAIN")) {
			response.sendRedirect("Main.jsp");
			return;
		}else if (action.equalsIgnoreCase("BOOKREGISTER")) {
			bookRegister(request, response);
			return;
		}else if(action.equalsIgnoreCase("BOOKVIEW")) {
			response.sendRedirect("Book.html");
			return;
		}else if(action.equalsIgnoreCase("BOOKLIST")) {
			bookList(request, response);
			return;
		}else if(action.equalsIgnoreCase("BOOKDETAIL")) {
			bookDetail(request, response);
			return;
		}
	}


	public void bookRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NullPointerException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("NAME");
		String genre = request.getParameter("GENRE");
		String date = request.getParameter("DATE");
		String code = request.getParameter("CODE");
		String number = request.getParameter("NUMBER");
		String price = request.getParameter("PRICE");
		String publisher = request.getParameter("PUBLISHER");
		String state = request.getParameter("STATE");
		String lending = request.getParameter("LENDING");
		
		if((name.length()==0) || (genre.length()==0) || (date.length()==0) || (code.length()==0) || 
				(number.length()==0) || (price.length()==0) || (publisher.length()==0) || 
				(state.length()==0) || (lending.length()==0)) {
			request.setAttribute("msg", "도서 등록에 실패하셨습니다.");
			
		}else {
			
			Book b = new Book();
			b.setName(name);
			b.setGenre(genre);
			b.setDate(date);
			b.setCode(code);
			b.setNumber(number);
			b.setPrice(price);
			b.setPublisher(publisher);
			b.setState(state);
			b.setLending(lending);
			
			System.out.println(b.getName()+b.getGenre()+b.getDate()+b.getCode()+b.getNumber()+b.getPrice()+b.getPublisher()+b.getState()+b.getLending());
			System.out.println(b);
		
			try {
				dao.register(b);
				System.out.println("register book 메서드 호출");
			}catch(Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "도서 저장에 실패했습니다.");
			}
		
			//System.out.println(b.getAddress());
			System.out.println(b);
			request.setAttribute("b", b);
			request.getRequestDispatcher("BookView.jsp").forward(request, response);
		}
	}

	public void bookList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<Book> list = dao.search();
			request.setAttribute("list", list);
			request.getRequestDispatcher("BookList.jsp").forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "도서 검색에 실패하였습니다");
		}
		
	}
	
	public void bookDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String name = request.getParameter("name");
		try {
			Book b = dao.search(name);
			request.setAttribute("b", b);
			request.getRequestDispatcher("BookView.jsp").forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", name+"검색에 실패했습니다.");
		}
	}

}

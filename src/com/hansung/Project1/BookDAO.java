package com.hansung.Project1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hansung.Project1.DBUtil;

/**
 * Servlet implementation class BookDAO
 */
@WebServlet("/BookDAO")
public class BookDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookDAO() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void register(Book b) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		String q = "Insert into book_tb values(?,?,?,?,?,?,?,?,?)";
		try {
			con=DBUtil.getConnection();
			System.out.println("Connection 객체 생성");
			ps=con.prepareStatement(q);
			ps.setString(1, b.getName());
			ps.setString(2, b.getGenre());
			ps.setString(3, b.getDate());
			ps.setString(4, b.getCode());
			ps.setString(5, b.getNumber());
			ps.setString(6, b.getPrice());
			ps.setString(7, b.getPublisher());
			ps.setString(8, b.getState());
			ps.setString(9, b.getLending());
			
			ps.executeUpdate();
			System.out.println("회원 가입 완료");
			System.out.println(b.getName()+b.getGenre()+b.getDate()+b.getCode()+b.getNumber()+b.getPrice()+b.getPublisher()+b.getState()+b.getLending());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(ps);
			DBUtil.close(con);
		}
	}

	public ArrayList<Book> search() throws Exception {
		ArrayList<Book> list = new ArrayList<>();
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String q = "Select * from book_tb";
		try {
			con=DBUtil.getConnection();
			ps=con.prepareStatement(q);
			rs=ps.executeQuery();
			while(rs.next()) {
				Book b = new Book();
				b.setName(rs.getString("name"));
				b.setGenre(rs.getString("genre"));
				b.setDate(rs.getString("date"));
				b.setCode(rs.getString("code"));
				b.setNumber(rs.getString("number"));
				b.setPrice(rs.getString("price"));
				b.setPublisher(rs.getString("publisher"));
				b.setState(rs.getString("state"));
				b.setLending(rs.getString("lending"));
				list.add(b);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(con);
		}
		return list;
	}

	public Book search(String name) throws Exception {
		Book b = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String q = "Select * from book_tb where name=?";
		try {
			con=DBUtil.getConnection();
			ps=con.prepareStatement(q);
			ps.setString(1, name);
			rs=ps.executeQuery();
			if(rs.next()) {
				b = new Book();
				b.setName(rs.getString("name"));
				b.setGenre(rs.getString("genre"));
				b.setDate(rs.getString("date"));
				b.setCode(rs.getString("code"));
				b.setNumber(rs.getString("number"));
				b.setPrice(rs.getString("price"));
				b.setPublisher(rs.getString("publisher"));
				b.setState(rs.getString("state"));
				b.setLending(rs.getString("lending"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(con);
		}
		return b;
	}

}

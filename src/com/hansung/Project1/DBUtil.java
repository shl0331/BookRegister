package com.hansung.Project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBUtil {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//jdbc드라이버 로딩
			System.out.println("드라이버 로딩 성공");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws Exception {
		Connection con=DriverManager.getConnection( //데이터베이스 커넥션 생성
				"jdbc:mysql://localhost:3306/project1_db?"+"characterEncoding=utf-8&serverTimezone=UTC",
				"root","1234");
			System.out.println("컨넥션 객체 생성 성공");
		return con;

			
	}
	
	public static void close(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Statement ps) {
		if(ps != null) {
			try {
				ps.close();
							
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Connection con) {
		if(con != null) {
			try {
				con.close();
							
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

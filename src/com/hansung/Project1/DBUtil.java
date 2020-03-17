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
			Class.forName("com.mysql.cj.jdbc.Driver");//jdbc����̹� �ε�
			System.out.println("����̹� �ε� ����");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws Exception {
		Connection con=DriverManager.getConnection( //�����ͺ��̽� Ŀ�ؼ� ����
				"jdbc:mysql://localhost:3306/project1_db?"+"characterEncoding=utf-8&serverTimezone=UTC",
				"root","1234");
			System.out.println("���ؼ� ��ü ���� ����");
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

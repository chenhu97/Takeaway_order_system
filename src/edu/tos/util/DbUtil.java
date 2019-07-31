package edu.tos.util;


import java.sql.*;

import com.liuvei.common.*;


public class DbUtil {
	
	

	/**
	 * 【获得连接对象】
	 * 
	 * @return
	 */
	public static Connection getConn() {
		Connection conn = null;

		try {
			
			conn = C3P0.getConnection();
		
			//conn = C3P0Fun.getConnection();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("获取连接失败");
		}

		return conn;
	}
	
	/**
	 * 关闭连接对象
	 * 
	 * @param conn
	 *            欲关闭的连接对象
	 */
	public static void close(Connection conn) {
		DbFun.close(conn);
	}

	/**
	 * 关闭Statement
	 * 
	 * @param stmt
	 */
	public static void close(Statement stmt) {
		DbFun.close(stmt);
	}

	/**
	 * 关闭ResultSet
	 * 
	 * @param rs
	 */
	public static void close(ResultSet rs) {
		DbFun.close(rs);
	}

	/**
	 * 关闭三大对象
	 * 
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public static void close(Connection conn, Statement stmt, ResultSet rs) {

		DbFun.close(conn, stmt, rs);
	}

}

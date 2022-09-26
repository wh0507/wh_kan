package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBAccess {
	//JDBC接続先情報
	private static final String CONN = "jdbc:postgresql://localhost:5432/mydb";
	//ユーザー名
	private static final String USER = "postgres"; //myuser
	//パスワード
	private static final String PASS = "postgres"; //password

	Connection conn = null;

	//DBへ接続
	public Connection getConnection() {
		try {
			//接続先の情報
			conn = DriverManager.getConnection(CONN, USER, PASS);
			return conn;
		} catch (Exception e) {
			System.out.println("DBコネクションエラー:" + e.getMessage());
		}
		return null;
	}

	//DBへ切断
	public void closeDBAccess() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("DBクローズエラー:" + e.getMessage());
		}
	}

}

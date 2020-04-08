package mysql_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

	public static Connection getConn() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/cafe_tostring?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
		Connection conn = DriverManager.getConnection(url, "root", "mysql");
		return conn;
	}
}

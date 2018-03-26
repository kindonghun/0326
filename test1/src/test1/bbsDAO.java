package test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class bbsDAO {
	private Connection conn;
	private ResultSet rs;

	public bbsDAO() { // ������ ���ٰ�ü (�����͸� �ְ�,�����͸� �������°�)
		try {
			String dbURL = "jdbc:mysql://localhost:3306/BBS";
			String dbID = "root";
			String dbPassword = "4556";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			
			System.out.println("Connection Success!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

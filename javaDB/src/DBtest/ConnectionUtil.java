package DBtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
public static String ID= "ben";
public static String PASSWORD = "4556";
public static String IP ="localhost";
static {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
}
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:oracle:thin:@"+IP+":1521:xe",ID,PASSWORD);
	}
}


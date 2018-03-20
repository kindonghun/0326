package DBtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_ex02 {
public static void main(String[] args) {
	StringBuffer sql = new StringBuffer();
	sql.append("update department ");
	sql.append("set dname ='전자계산학과' ");
	sql.append("where deptno = 203");
	Connection con = null;
	Statement stmt =null;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ben", "4556");
		stmt= con.createStatement();
		int i= stmt.executeUpdate(sql.toString());
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}catch(SQLException e) {
		e.printStackTrace();
	}
	finally {
		try {
			if(con != null) con.close();
			if(stmt!=null)stmt.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
}

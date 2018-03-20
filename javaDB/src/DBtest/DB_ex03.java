package DBtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_ex03 {
	public static void main(String[] args) {
		StringBuffer sql =new StringBuffer();
		sql.append("delete department ");
		sql.append("where dname = '전자계산학과' ");
		Connection con = null;
		Statement stmt= null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ben","4556");
			stmt=con.createStatement();
			
			int n = stmt.executeUpdate(sql.toString());
			
			System.out.println(n + "개의 행이 삭제되었습니다.");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(con !=null) con.close();
				if(stmt != null) con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}

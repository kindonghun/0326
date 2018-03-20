package DBtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_ex04 {
	public static void main(String[] args) {
		StringBuffer sql =new StringBuffer();
		sql.append("select deptno, dname, college, loc ");
		sql.append("from department");
		Connection con = null;
		Statement stmt =null;
		ResultSet rs =null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ben","4556");
			stmt= con.createStatement();
			rs= stmt.executeQuery(sql.toString());
			//쿼리가 select 일때는 excuteUpdate()를 사용한다.
			while(rs.next()) {
				int i=rs.getInt(1);
				String s1 =rs.getString(2);
				int j= rs.getInt("College");
				String s2 =rs.getString("loc");
				System.out.println(i+"\t"+s1+"\t"+j+"\t"+s2);
			}
		}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					if(con !=null) con.close();
					if(stmt !=null) stmt.close();
					if(rs !=null)rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
			}
		}
	}
}


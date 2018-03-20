package DBtest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB_ex07 {
	public static void main(String[] args) {
		StringBuffer sql = new StringBuffer();
		sql.append("select a.name, a.profno, a.positon, b.dname ");
		sql.append("from professor a, department b ");
		sql.append("where a.deptno = b.deptno ");
		sql.append("and a.deptno = ? ");
		System.out.println(sql.toString());
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try {
			con = ConnectionUtil.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, 203);
			System.out.println(sql.toString());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("name")+"\t");
				System.out.println(rs.getInt("profno"+"\t"));
				System.out.println(rs.getString("dname")+"\t");
				System.out.println(rs.getString("prsition")+"\t");
				
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(con!=null) con.close();
				if(pstmt!=null) pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

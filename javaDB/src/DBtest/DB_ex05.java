package DBtest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DB_ex05 {
	public static void main(String[] args) {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into PROFESSOR ");
		sql.append("values (?, ?, ?, ?, ?, sysdate, ?, ?)");
		Connection con =null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.getConnection();
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, 9920);
			pstmt.setString(2, "홍길동");
			pstmt.setString(3, "gildong");
			pstmt.setString(4, "전임교수");
			pstmt.setInt(5, 450);
			pstmt.setInt(6, 40);
			pstmt.setInt(7, 203);
			int n =pstmt.executeUpdate();
			
			System.out.println(n+"개의 행이 추가되었습니다.");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(con !=null) con.close();
				if(pstmt !=null) pstmt.close();
			}catch(SQLException e) {
				
			}
		}
	}
}

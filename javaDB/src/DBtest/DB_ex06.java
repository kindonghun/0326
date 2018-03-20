package DBtest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DB_ex06 {
	public static void main(String[] args) {
		StringBuffer sql = new StringBuffer();
		sql.append("update professor ");
		sql.append("set sal = ? ");
		sql.append("where name = ? ");
		Connection con =null;
		PreparedStatement pstmt =null;
		try {
			con = ConnectionUtil.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, 500);
			pstmt.setString(2, "홍길동");
			
			int n = pstmt.executeUpdate();
			System.out.println(n+"개의 행이 수정되었습니다.");
			
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

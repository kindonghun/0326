package DBtest;
import java.sql.*;
public class DB_ex08 {
	public static void main(String[] args) {
		StringBuffer sql1 =new StringBuffer();
		sql1.append("insert into department ");
		sql1.append("values (?, ?, ?, ? ");
		StringBuffer sql2 =new StringBuffer();
		sql2.append("update department ");
		sql2.append("set dname = ?, loc = ? ");
		sql2.append("where deptno = ?");
		Connection con = null;
		PreparedStatement pstmt =null;
		try {
			//트랜잭션 1번작업시작
			con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql1.toString());
			pstmt.setInt(1, 255);
			pstmt.setString(2, "핵물리학과");
			pstmt.setInt(3, 200);
			pstmt.setString(4, "9호관");
			pstmt.executeQuery();
			//1번작업종료 -> 2번작업시작
			pstmt= con.prepareStatement(sql2.toString());
			pstmt.setString(1, "생명공학과");
			pstmt.setString(2, "8호관");
			pstmt.setInt(3, 255);
			pstmt.executeUpdate();
			//2번 작업종료, 정상적으로 실행된 경우 DB에반영된다.
			con.commit();
			System.out.println("DB 커밋 완료!");
		}catch(SQLException e) {
			try {
				con.rollback();
				System.out.println("DB 작업 실패 !");
				
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
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

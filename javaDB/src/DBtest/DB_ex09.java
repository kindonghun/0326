package DBtest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Types;
import java.util.Scanner;

public class DB_ex09 {
	public static void main(String[] args)throws Exception{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("SQL 입력:");
		String sql =sc.nextLine();
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs =pstmt.executeQuery();
		
		ResultSetMetaData rsmd = rs.getMetaData();
		System.out.println("컬럼갯수 :" + rsmd.getColumnCount());
		for(int i=1; i< rsmd.getColumnCount(); i++) {
			System.out.println(rsmd.getColumnName(i)+ "\t");
		}
		System.out.println();
		for(int i= 1; i< rsmd.getColumnCount(); i++) {
			System.out.print(rsmd.getColumnType(i)+ "\t");
		}
		System.out.println();
		System.out.println();
		int col =rsmd.getColumnCount();
		while(rs.next()) {
			for(int num = 1; num<= col; num++) {
				int type =rsmd.getColumnType(num);
				switch(type) {
				case Types.NUMERIC:
					System.out.println(rs.getInt(num)+ "\t");
					break;
				case Types.VARCHAR:
					System.out.println(rs.getString(num)+ "\t");
					break;
				case Types.DATE:
					System.out.println(rs.getDate(num)+ "\t");
					break;
				}
			}
			System.out.println();
		}
		rs.close();
		pstmt.close();
		con.close();
	}
}

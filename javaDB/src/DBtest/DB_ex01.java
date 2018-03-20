package DBtest;

import java.sql.*;

public class DB_ex01 {
public static void main(String[] args) {
	Connection con = null;
	Statement stmt = null;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "ben";
	String pass= "4556";
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// jdbc 드라이버를 메모리에 로드
		con = DriverManager.getConnection(url,id,pass); //getConnection 접속해주는명령어
		//ODB와 CON 연결된 객체
		System.out.println("DB접속 성공!");
		
		stmt =con.createStatement();
		StringBuffer sql= new StringBuffer();
		sql.append("INSERT INTO DEPARTMENT ");
		
		sql.append("VALUES (204, '제어게측공학과', 200, '7호관')");
		System.out.println(sql.toString());
		
		int result = stmt.executeUpdate(sql.toString()); //executeUpdate
		//변경된 행의 갯수 반환
		
		System.out.println(result +"개의 행이 추가되었습니다.");
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}catch(SQLException e) {
		e.printStackTrace();
	}
	finally {
		try {
			if(con !=null) 
				con.close();
				if(stmt !=null)
				stmt.close();	
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
}

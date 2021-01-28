package co.hj.board.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {

	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:xe";		//@ 이후부분은 현업에서 많이 바꿈
	private String user="hr";										//db에서 인가된 사용자와 패스워드
	private String password="hr";
	
	public Connection conn; //public만 상속가능 private은 안됨
	
	public DAO() {
		try {
			Class.forName(driver);					//라이브버리에 ojdbc가 로드됨
			conn = DriverManager.getConnection(url, user, password);	//커넥션을 받아올때 url, db 사용자명, 패스워드를 넘겨줌
			System.out.println("DB 연결 성공");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("DB 연결 실패");
		}
		
	}
	
}

package DBPKG;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static Connection getConnection() throws Exception { //static이 없으면 사용할때 new 연산을 통해 객체를 생성해서 사용해야 한다.
		Class.forName("oracle.jdbc.OracleDriver"); //Oracle드라이브 등록 //Oracle에 관련 기능을 사용할수 있게끔 해줌 //error - 1).jar 파일이 없음 2) 오타 오류
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "java2", "1234"); // 해당DB에 연결 // (접근경로, 아이디, 비밀번호)
		return con; //연결된 객체를 돌려줌
	}
}

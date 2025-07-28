package in.com.rays.pstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestInsert {
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
		
		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(4,104,'rohit',40,40,40)");
		
		int i = pstmt.executeUpdate();
		System.out.println("data inserted :" + i);
		
	}

}

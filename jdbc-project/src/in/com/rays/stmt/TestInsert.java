package in.com.rays.stmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
		Statement stmt = conn.createStatement();
		int i = stmt.executeUpdate("insert into marksheet values(9,107,'ajay',30,30,30)");

		System.out.println("data inserted :" + i);

	}

}

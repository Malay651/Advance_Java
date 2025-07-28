package in.com.rays.dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestNextPkDynamic {
	public static void main(String[] args) throws Exception {

		int nextPk = textNextPk();

		System.out.println(nextPk);

	}

	public static Integer textNextPk() throws Exception {

		int pk = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from marksheet");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);

		}
		return pk + 1;
	}
}

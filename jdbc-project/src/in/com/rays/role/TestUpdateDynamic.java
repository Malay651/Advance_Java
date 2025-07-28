package in.com.rays.role;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestUpdateDynamic {

	public static void main(String[] args) throws Exception {
		//testUpdate1();
		//testUpdate2();
		//testUpdate3();

		RoleBean bean = new RoleBean();
		bean.setId(6);
		bean.setName("akshat");
		bean.setDescription("software engineer");

		 testUpdate4(bean);
	}

	public static void testUpdate1() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn
				.prepareStatement("update role set name = 'harsh', description = 'it' where id = 2");

		int i = pstmt.executeUpdate();
		System.out.println("data updated :" + i);
	}

	public static void testUpdate2() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("update role set name = ? , description = ? where id = ?");

		pstmt.setString(1, "vishal");
		pstmt.setString(2, "lawyer");
		pstmt.setInt(3, 5);

		int i = pstmt.executeUpdate();
		System.out.println("data updated :" + i);
	}

	public static void testUpdate3(int id, String name, String description) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("update role set name = ? , description = ? where id = ?");

		pstmt.setString(1, "arjun");
		pstmt.setString(2, "hr");
		pstmt.setInt(3, id);

		int i = pstmt.executeUpdate();
		System.out.println("data updated :" + i);
	}

	public static void testUpdate4(RoleBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("update role set name = ?, description = ?  where id = ?");

		
		pstmt.setString(1, bean.getName());
		pstmt.setString(2, bean.getDescription());
		pstmt.setInt(3, bean.getId());
		
		int i = pstmt.executeUpdate();
		
		System.out.println("data updated :" + i);

	}
}

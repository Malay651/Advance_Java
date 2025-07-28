package in.com.rays.role;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.com.rays.dynamic.MarksheetBean;

public class TestReaddynamic {
	public static void main(String[] args) throws Exception {
         // testRead1();
         // testRead2();
       //   testRead3(0,"vishal",null);
         RoleBean bean = new RoleBean();
         //bean.setId(3);
         // bean.setName("arjun");
         // bean.setDescription("hr");
          
        // testRead4(bean);
         // testRead5(bean);
          testRead6(null,3,3);
	}

	public static void testRead1() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from role");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.println("\t" + rs.getString(3));

		}
	}

	public static void testRead2() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		 String sql = "select * from role";

		// String sql = "select * from role where id = 2";

		// String sql = "select * from role where name like 'a%'";

		// String sql = "select * from role where description like 'h%' ";

		System.out.println("sql :" + sql);

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.println("\t" + rs.getString(3));
		}
	}

	public static void testRead3(int id, String name, String description) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		String sql = "select * from role ";

		if (id > 0) {
			sql += " where id = " + id;
		}
		if (name != null) {
			sql += " where name like '" + name + "%'";
		}
		if (description != null) {
			sql += "where description like " + name + "%";
		}
		System.out.println("sql : " + sql);

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
		}
	}

	public static void testRead4(RoleBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		String sql = "select * from role";

		if (bean != null) {
			if (bean.getId() > 0) {
				sql += "where id = " + bean.getId();
			}
			if (bean.getName() != null) {
				sql += "where name = " + bean.getName();
			}
			if (bean.getDescription() != null) {
				sql += "where description = " + bean.getDescription();
			}
		}
		System.out.println("sql => " + sql);

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.println("\t" + rs.getString(3));

		}
	}

	public static void testRead5(RoleBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		StringBuffer sql = new StringBuffer("select * from role where 1=1");

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}
			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and name like '" + bean.getName() + "%'");
			}
			if (bean.getDescription() != null && bean.getDescription().length() > 0) {
				sql.append(" and description like '" + bean.getDescription());
			}
		}

		System.out.println("sql => " + sql);

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.println("\t" + rs.getString(3));

		}
	}

	public static void testRead6(RoleBean bean,int pageNo,int pageSize) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		StringBuffer sql = new StringBuffer(" select * from role where 1=1 ");

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}
			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and name like '" + bean.getName() + "%'");
			}
			if (bean.getDescription() != null && bean.getDescription().length() > 0) {
				sql.append("and description like '" + bean.getDescription());
			}
		}
		if (pageSize > 0) {
			pageNo = pageNo - 1 * pageSize;
			sql.append(" limit " + pageNo + "," + pageSize);
			System.out.println(" sql => " + sql);

			PreparedStatement pstmt = conn.prepareStatement(sql.toString());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.print(rs.getInt(1));
				System.out.print("\t" + rs.getString(2));
				System.out.println("\t" + rs.getString(3));

			}

		}
	}
}

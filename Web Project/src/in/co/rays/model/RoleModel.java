package in.co.rays.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.RoleBean;

public class RoleModel {

	public Integer nextPk() throws Exception {

		int pk = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from role");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
		}
		return pk + 1;
	}

	public void add(RoleBean bean) throws Exception {

		int pk = nextPk();

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into st_role values(?, ?, ?, ?, ?, ?,?)");

		pstmt.setInt(1, pk);
		pstmt.setString(2, bean.getName());
		pstmt.setString(3, bean.getDescription());
		pstmt.setString(4, bean.getCreatedby());
		pstmt.setString(5, bean.getModifiedby());
		pstmt.setTimestamp(6, bean.getCreateddatetime());
		pstmt.setTimestamp(7, bean.getModifieddatetime());

		int i = pstmt.executeUpdate();

		System.out.println("data inserted => " + i);
	}

	public void update(RoleBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("update st_role set  name = ?, description = ?, created_by = ?, modified_by = ?,created_datetime = ?,modified_datetime = ? where id =? ");

		pstmt.setString(1, bean.getName());
		pstmt.setString(2, bean.getDescription());
		pstmt.setString(3, bean.getCreatedby());
		pstmt.setString(4, bean.getModifiedby());
		pstmt.setTimestamp(5, bean.getCreateddatetime());
		pstmt.setTimestamp(6, bean.getModifieddatetime());
		pstmt.setLong(7, bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println("data updated => " + i);

	}

	public void delete(long id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("delete from st_role where id = ?");

		pstmt.setLong(1, id);

		int i = pstmt.executeUpdate();

		System.out.println("data deleted => " + i);
	}

	public RoleBean findbypk(long id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		StringBuffer sql = new StringBuffer("select * from st_role where id = ?");

		System.out.println("sql => " + sql);

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setLong(1, id);

		ResultSet rs = pstmt.executeQuery();

		RoleBean bean = null;

		while (rs.next()) {

			bean = new RoleBean();
			
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setDescription(rs.getString(3));
			bean.setCreatedby(rs.getString(4));
			bean.setModifiedby(rs.getString(5));
			bean.setCreateddatetime(rs.getTimestamp(6));
			bean.setModifieddatetime(rs.getTimestamp(7));
		}
		return bean;
	}

	public RoleBean findbyname(String name) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		StringBuffer sql = new StringBuffer("select * from st_role where name = ?");
		System.out.println("sql => " + sql);

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, name);

		ResultSet rs = pstmt.executeQuery();

		RoleBean bean = null;

		while (rs.next()) {
			bean = new RoleBean();
			
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setDescription(rs.getString(3));
			bean.setCreatedby(rs.getString(4));
			bean.setModifiedby(rs.getString(5));
			bean.setCreateddatetime(rs.getTimestamp(6));
			bean.setModifieddatetime(rs.getTimestamp(7));
		}
		return bean;
	}

	public List Search(RoleBean bean, int pageNo, int pageSize) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		StringBuffer sql = new StringBuffer("select * from st_role where 1=1");

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append("and ID =" + bean.getId());
			}
			if (bean.getName() != null && bean.getName().length() > 0) {

				sql.append(" and name like ' " + bean.getName() + "%'");
			}
		}	
				if (pageSize > 0) {
					pageNo = pageNo * 1 - pageSize;
					sql.append("limit" + pageNo + "," + pageSize);
				}
				
				System.out.println("sql :" + sql);
				
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

				ResultSet rs = pstmt.executeQuery();
				List list = new ArrayList();

				while (rs.next()) {

					bean = new RoleBean();
					
					bean.setId(rs.getInt(1));
					bean.setName(rs.getString(2));
					bean.setDescription(rs.getString(3));
					bean.setCreatedby(rs.getString(4));
					bean.setModifiedby(rs.getString(5));
					bean.setCreateddatetime(rs.getTimestamp(6));
					bean.setModifieddatetime(rs.getTimestamp(7));
				

					list.add(bean);

				}
				return list;
			}
		}
	

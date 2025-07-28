package in.co.rays.model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.UserBean;
import in.co.rays.util1.JDBCDataSource;

public class UserModel {

	public Integer nextPk() throws Exception {

		int pk = 0;

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_user");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
		}
		return pk + 1;
	}

	public void add(UserBean bean) throws Exception {

		int pk = nextPk();


		Connection conn =  JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("insert into st_user values(?,?,?,?,?,?,?,?,?,?,?,?,?)");

		pstmt.setInt(1, pk);
		pstmt.setString(2, bean.getFirstName());
		pstmt.setString(3, bean.getLastName());
		pstmt.setString(4, bean.getLogin_id());
		pstmt.setString(5, bean.getPassword());
		pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setString(7, bean.getMobile_No());
		pstmt.setString(8, bean.getRole_id());
		pstmt.setString(9, bean.getGender());
		pstmt.setString(10, bean.getCreatedby());
		pstmt.setString(11, bean.getModifiedby());
		pstmt.setTimestamp(12, bean.getCreateddatetime());
		pstmt.setTimestamp(13, bean.getModifieddatetime());

		int i = pstmt.executeUpdate();

		System.out.println("data inserted => " + i);
	}

	public void update(UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement(
				"update st_user set first_name = ?, last_name=?, login = ?, password = ?,dob = ?,mobile_no = ?,role_id = ?,gender = ?,created_by = ?, modified_by = ?, created_datetime = ?,modified_datetime = ? where id =? ");

		pstmt.setString(1, bean.getFirstName());
		pstmt.setString(2, bean.getLastName());
		pstmt.setString(3, bean.getLogin_id());
		pstmt.setString(4, bean.getPassword());
		pstmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setString(6, bean.getMobile_No());
		pstmt.setString(7, bean.getRole_id());
		pstmt.setString(8, bean.getGender());
		pstmt.setString(9, bean.getCreatedby());
		pstmt.setString(10, bean.getModifiedby());
		pstmt.setTimestamp(11, bean.getCreateddatetime());
		pstmt.setTimestamp(12, bean.getModifieddatetime());
		pstmt.setLong(13, bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println("data updated => " + i);
	}

	public void delete(long id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("delete from st_user where id = ?");

		pstmt.setLong(1, id);

		int i = pstmt.executeUpdate();

		System.out.println("data deleted => " + i);
	}

	public UserBean findbypk(long id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		StringBuffer sql = new StringBuffer("select * from st_user where id = ?");

		System.out.println("sql => " + sql);

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setLong(1, id);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;

		while (rs.next()) {

			bean = new UserBean();

		}
		return bean;
	}

	public UserBean login_id(String login_id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer("select * from st_user where login_id = ?");
		System.out.println("sql => " + sql);

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1,login_id);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;

		while (rs.next()) {
			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLogin_id(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setMobile_No(rs.getString(7));
			bean.setRole_id(rs.getString(8));
			bean.setGender(rs.getString(9));
			bean.setCreatedby(rs.getString(10));
			bean.setModifiedby(rs.getString(11));
			bean.setCreateddatetime(rs.getTimestamp(12));
			bean.setModifieddatetime(rs.getTimestamp(13));

		}
		return bean;
	}
	
	public UserBean authenticate(String login_id,String password) throws Exception {
		
		Connection conn = null;
		
		UserBean bean = null;
		 try { 
			 conn = JDBCDataSource.getConnection();
			 
			PreparedStatement pstmt = conn.prepareStatement("select * from st_user  where login = ? and password = ?");
			pstmt.setString(1, login_id);
			pstmt.setString(2,password);
			
			ResultSet rs = pstmt.executeQuery();
			System.out.println("inside en"+rs);
			
			 
			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getInt(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setLogin_id(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setDob(rs.getDate(6));
				bean.setAddress(rs.getString(7));
				System.out.println(bean);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return bean;
	}
      
	
	public List Search(UserBean bean, int pageNo, int pageSize) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		StringBuffer sql = new StringBuffer("select * from st_user where 1=1");

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append("and ID =" + bean.getId());
			}
			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {

				sql.append(" and first_name like ' " + bean.getFirstName() + "%'");
			}
			if (bean.getLastName() != null && bean.getLastName().length() > 0) {

				sql.append(" and last_name like ' " + bean.getLastName() + "%'");
			}

			if (bean.getLogin_id() != null && bean.getLogin_id().length() > 0) {
				sql.append(" and login_id like ' " + bean.getLogin_id() + "%'");
			}
		}
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + "," + pageSize);
		}
		System.out.println("sql :" + sql.toString());
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {

			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLogin_id(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setMobile_No(rs.getString(7));
			bean.setRole_id(rs.getString(8));
			bean.setGender(rs.getString(9));
			bean.setCreatedby(rs.getString(10));
			bean.setModifiedby(rs.getString(11));
			bean.setCreateddatetime(rs.getTimestamp(12));
			bean.setModifieddatetime(rs.getTimestamp(13));

			list.add(bean);

		}

		return list;
	}
}

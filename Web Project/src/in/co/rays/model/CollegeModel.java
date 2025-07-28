package in.co.rays.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.CollegeBean;

public class CollegeModel {
	
	public Integer nextpk() throws Exception {
		
		int pk = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_college");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
		}
		return pk + 1;
	}
      
	public  void Add(CollegeBean bean) throws Exception  {
		
		int pk = nextpk();
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into st_college values(?,?,?,?,?,?,?,?,?,?)");
        
		pstmt.setInt(1,pk);
		pstmt.setString(2,bean.getName());
		pstmt.setString(3,bean.getAddress());
		pstmt.setString(4,bean.getState());
		pstmt.setString(5,bean.getCity());
		pstmt.setString(6,bean.getPhone_No());
		pstmt.setString(7, bean.getCreated_by());
		pstmt.setString(8, bean.getModified_by());
		pstmt.setTimestamp(9, bean.getCreated_datetime());
		pstmt.setTimestamp(10, bean.getModified_datetime());
      
		int i = pstmt.executeUpdate();
		
		System.out.println(" data inserted " + i);
	}
	 
	   public void Update(CollegeBean bean) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("update st_college set name = ?,address = ?,state = ?,city = ?,phone_no = ?,created_by = ?,modified_by = ?,created_datetime = ?,modified_datetime = ? where id = ?");
        
		pstmt.setString(1,bean.getName());
		pstmt.setString(2,bean.getAddress());
		pstmt.setString(3,bean.getState());
		pstmt.setString(4,bean.getCity());
		pstmt.setString(5,bean.getPhone_No());
		pstmt.setString(6, bean.getCreated_by());
		pstmt.setString(7, bean.getModified_by());
		pstmt.setTimestamp(8, bean.getCreated_datetime());
		pstmt.setTimestamp(9, bean.getModified_datetime());
        pstmt.setInt(10,bean.getId());
        
		int i = pstmt.executeUpdate();
		
		System.out.println(" data updated " + i);
	}
	
	public void Delete(int id) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("delete from st_college where id = ?");
		
		pstmt.setInt(1,id);
		
		int i = pstmt.executeUpdate();
		System.out.println("data deleted :" + i);
		
	}
	
	public CollegeBean findbypk(int id) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
      
		StringBuffer sql = new StringBuffer("select * from st_college where id = ?");
		
		System.out.println("sql :" + sql);
		
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		
		pstmt.setInt(1,id);
		
		ResultSet rs = pstmt.executeQuery();
		
		CollegeBean bean = null;
		
		 while(rs.next()) {
			 bean = new CollegeBean();
			 
			 bean.setId(rs.getInt(1));
			 bean.setName(rs.getString(2));
			 bean.setAddress(rs.getString(3));
			 bean.setState(rs.getString(4));
			 bean.setCity(rs.getString(5));
			 bean.setPhone_No(rs.getString(6));
			 bean.setCreated_by(rs.getString(7));
			 bean.setModified_by(rs.getString(8));
		     bean.setCreated_datetime(rs.getTimestamp(9));
			 bean.setModified_datetime(rs.getTimestamp(10));
				
		 }
		return bean;
    }
	
	public CollegeBean findbyname(String name) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
      
		StringBuffer sql = new StringBuffer(" select * from st_college where name = ? ");
		
		System.out.println("sql :" + sql);
		
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		
		pstmt.setString(1,name);
		
		ResultSet rs = pstmt.executeQuery();
		
		CollegeBean bean = null;
		
		 while(rs.next()) {
			 bean = new CollegeBean();
			 
			 bean.setId(rs.getInt(1));
			 bean.setName(rs.getString(2));
			 bean.setAddress(rs.getString(3));
			 bean.setState(rs.getString(4));
			 bean.setCity(rs.getString(5));
			 bean.setPhone_No(rs.getString(6));
			 bean.setCreated_by(rs.getString(7));
			 bean.setModified_by(rs.getString(8));
		     bean.setCreated_datetime(rs.getTimestamp(9));
			 bean.setModified_datetime(rs.getTimestamp(10));
				
		 }
		return bean;
    }
	
	public List Search(CollegeBean bean,int pageNo, int pageSize) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
      
		StringBuffer sql = new StringBuffer("select * from st_college where 1=1 ");
		
		if(bean != null) {
			if(bean.getId() > 0) {
				sql.append(" and id = " + bean.getId()+" ");
			}
		}
		if(pageNo > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append("limit " + pageNo + ","  + pageSize);
		}
		System.out.println("sql : " + sql);
		
		 PreparedStatement pstmt = conn.prepareStatement(sql.toString());

 		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();
		
		while(rs.next()) {
			
			bean = new CollegeBean();
			 bean.setId(rs.getInt(1));
			 bean.setName(rs.getString(2));
			 bean.setAddress(rs.getString(3));
			 bean.setState(rs.getString(4));
			 bean.setCity(rs.getString(5));
			 bean.setPhone_No(rs.getString(6));
			 bean.setCreated_by(rs.getString(7));
			 bean.setModified_by(rs.getString(8));
		     bean.setCreated_datetime(rs.getTimestamp(9));
			 bean.setModified_datetime(rs.getTimestamp(10));
			 list.add(bean);
	}
		return list;

		

	}
}



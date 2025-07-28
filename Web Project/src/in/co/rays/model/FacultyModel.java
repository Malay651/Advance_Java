package in.co.rays.model;

import java.sql.Connection;
import java.sql.Date;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.FacultyBean;

public class FacultyModel {
	
public Integer nextpk() throws Exception {
		
		int pk = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_faculty");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
		}
		return pk + 1;
}


    public void Add(FacultyBean bean) throws Exception {
    	
    	int pk = nextpk();
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into st_faculty values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

		pstmt.setLong(1,pk);
		pstmt.setString(2,bean.getfirstName());
		pstmt.setString(3,bean.getlastName());
		pstmt.setDate(4, new java.sql.Date(bean.getDob().getTime()));
	    pstmt.setString(5, bean.getGender());
		pstmt.setString(6,bean.getMobile_No());
		pstmt.setString(7,bean.getEmail());
		pstmt.setInt(8,bean.getCollege_Id());
		pstmt.setString(9,bean.getCollege_Name());
		pstmt.setInt(10,bean.getStudent_Id());
		pstmt.setString(11,bean.getStudent_Name());
		pstmt.setString(12,bean.getCreatedby());
		pstmt.setString(13,bean.getModifiedby());
		pstmt.setTimestamp(14, bean.getCreateddatetime());
		pstmt.setTimestamp(15, bean.getModifieddatetime());
      
		int i = pstmt.executeUpdate();
		
		System.out.println("data inserted " + i);
		
    }

   public void Update(FacultyBean bean) throws Exception {
	   
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("update st__faculty set first_name = ?,last_name= ? dob = ?,gender = ?,mobile_no = ?,email = ?,college_id = ?,college_name = ?,student_id = ?,student_name = ?,created_by = ?,modified_by = ?,created_datetime = ?,modified_datetime = ? where id = ?");
        
		pstmt.setString(1,bean.getfirstName());
		pstmt.setString(2,bean.getlastName());
		pstmt.setDate(3, new java.sql.Date(bean.getDob().getTime()));
	    pstmt.setString(4, bean.getGender());
		pstmt.setString(5,bean.getMobile_No());
		pstmt.setString(6,bean.getEmail());
		pstmt.setInt(7,bean.getCollege_Id());
		pstmt.setString(8,bean.getCollege_Name());
		pstmt.setInt(9,bean.getStudent_Id());
		pstmt.setString(10,bean.getStudent_Name());
		pstmt.setString(11,bean.getCreatedby());
		pstmt.setString(12,bean.getModifiedby());
		pstmt.setTimestamp(13, bean.getCreateddatetime());
		pstmt.setTimestamp(14, bean.getModifieddatetime());
        pstmt.setLong(15,bean.getId());
		
		
		int i = pstmt.executeUpdate();
		System.out.println("data updated " + i);
		
   }

   public void Delete(int id) throws Exception {
	   
	   Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("delete from st_faculty where id = ?");
		
		pstmt.setLong(1,id);
		
		int i = pstmt.executeUpdate();
		
		System.out.println("data deleted :" + i);
	   
   }

   public FacultyBean findbypk(long id) throws Exception {
	   
	   Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		StringBuffer sql = new StringBuffer ("select * from st_faculty where id = ?");
		
		System.out.println("sql :" + sql);
		
		PreparedStatement pstmt = conn.prepareStatement (sql.toString());
		
		pstmt.setLong(1,id);
	   
		ResultSet rs = pstmt.executeQuery();
		
	   FacultyBean bean = null;
		
		while(rs.next()) {
			
			bean = new FacultyBean();
			
			bean.setId(rs.getLong(1));
			bean.setfirstName(rs.getString(2));
			bean.setlastName(rs.getString(3));
			bean.setDob(rs.getDate(4));
			bean.setGender(rs.getString(5));
			bean.setMobile_No(rs.getString(6));
			bean.setEmail(rs.getString(7));
			bean.setCollege_Id(rs.getInt(8));
			bean.setCollege_Name(rs.getString(9));
			bean.setStudent_Id(rs.getInt(10));
			bean.setStudent_Name(rs.getString(11));
			bean.setCreatedby(rs.getString(12));
			bean.setModifiedby(rs.getString(13));
		    bean.setCreateddatetime(rs.getTimestamp(14));
			bean.setModifieddatetime(rs.getTimestamp(15));
		}
		return bean;
   }
      
    public List Search (FacultyBean bean, int pageNo,int pageSize) throws Exception {
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
      
		StringBuffer sql = new StringBuffer("select * from st_faculty where 1=1 ");
		
		System.out.println("sql :" + sql);
		
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		
		ResultSet rs = pstmt.executeQuery();
		
		if (bean != null) {
			if(bean.getId() > 0) {
				sql.append(" and id =" + bean.getId() + " ");
				}
	}
		if(pageSize > 0) {
			pageNo = pageNo - 1 * pageSize;
			sql.append(" limit " + pageNo + "," + pageSize);
		}
		 List list =  new ArrayList();
		 
		 while(rs.next()) {
			 bean = new FacultyBean();
			 
			    bean.setId(rs.getLong(1));
				bean.setfirstName(rs.getString(2));
				bean.setlastName(rs.getString(3));
				bean.setDob(rs.getDate(4));
				bean.setGender(rs.getString(5));
				bean.setMobile_No(rs.getString(6));
				bean.setEmail(rs.getString(7));
				bean.setCollege_Id(rs.getInt(8));
				bean.setCollege_Name(rs.getString(9));
				bean.setStudent_Id(rs.getInt(10));
				bean.setStudent_Name(rs.getString(11));
				bean.setCreatedby(rs.getString(12));
				bean.setModifiedby(rs.getString(13));
			    bean.setCreateddatetime(rs.getTimestamp(14));
				bean.setModifieddatetime(rs.getTimestamp(15));
		
			 
		      list.add(bean);
		 }
		 return list;
}
}





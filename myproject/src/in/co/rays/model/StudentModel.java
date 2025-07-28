package in.co.rays.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.CollegeBean;
import in.co.rays.bean.StudentBean;


public class StudentModel {
	
	public Integer nextpk() throws Exception {
	
	    int pk = 0;
	    
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
		
		PreparedStatement pstmt = conn.prepareStatement ("select max(id) from st_student");
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			
			pk = rs.getInt(1);
		}
	   return pk + 1;
	}
	
	public void Add(StudentBean bean) throws Exception {
		
		CollegeModel model = new CollegeModel();
		
		CollegeBean collegebean = model.findbypk(bean.getCollege_id());
		bean.setCollege_name(collegebean.getName());
		
		StudentBean duplicatename = findbyemail(bean.getEmail());
		int pk = nextpk();
		
		if(duplicatename !=null) {
			throw new Exception ("email already exists");
		}
		
        Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
		
		PreparedStatement pstmt = conn.prepareStatement ("insert into st_student values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		pstmt.setInt(1,pk);
		pstmt.setString(2,bean.getFirst_name());
		pstmt.setString(3,bean.getLast_name());
		pstmt.setDate(4,new java.sql.Date(bean.getDob().getTime()));
		pstmt.setString(5,bean.getGender());
		pstmt.setString(6,bean.getMobile_No());
		pstmt.setString(7,bean.getEmail());
		pstmt.setInt(8,bean.getCollege_id());
		pstmt.setString(9,bean.getCollege_name());
		pstmt.setString(10,bean.getCreatedby());
		pstmt.setString(11,bean.getModifiedby());
		pstmt.setTimestamp(12,bean.getCreated_datetime());
		pstmt.setTimestamp(13,bean.getModified_datetime());
		
		int i = pstmt.executeUpdate();
		
		System.out.println("data inserted " + i);
	}
	
	public void Update(StudentBean bean) throws Exception {
		
         CollegeModel model = new CollegeModel();
		
		CollegeBean collegebean = model.findbypk(bean.getCollege_id());
		bean.setCollege_name(collegebean.getName());
		
		StudentBean duplicatename = findbyemail(bean.getEmail());
		int pk = nextpk();
		
		if(duplicatename !=null) {
			throw new Exception ("email already exists");
		}
		
		    Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
			
			PreparedStatement pstmt = conn.prepareStatement ("update st_student set first_name = ?,last_name = ?,dob = ?,gender = ?,mobile_no = ?,email = ?,college_id = ?,college_name = ?,created_by = ?,modified_by = ?,created_datetime = ?,modified_datetime = ? where id = ?");
			
			
			pstmt.setString(1,bean.getFirst_name());
			pstmt.setString(2,bean.getLast_name());
			pstmt.setDate(3,new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(4,bean.getGender());
			pstmt.setString(5,bean.getMobile_No());
			pstmt.setString(6,bean.getEmail());
			pstmt.setInt(7,bean.getCollege_id());
			pstmt.setString(8,bean.getCollege_name());
			pstmt.setString(9,bean.getCreatedby());
			pstmt.setString(10,bean.getModifiedby());
			pstmt.setTimestamp(11,bean.getCreated_datetime());
			pstmt.setTimestamp(12,bean.getModified_datetime());
			pstmt.setInt(13,bean.getId());
			
			int i = pstmt.executeUpdate();
			
			System.out.println("data updated " + i);
				
			}
		
	   public void Delete(int id) throws Exception {
		   
		   Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
			
			PreparedStatement pstmt = conn.prepareStatement ("delete from st_student where id = ?");
			
			pstmt.setInt(1,id);
			
			int i = pstmt.executeUpdate();
			 
			System.out.println("data deleted " + i);
		 }
	   
	   public StudentBean findbypk(int id) throws Exception {
		   
		   Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
			
			StringBuffer sql = new StringBuffer ("select * from st_student where id = ?");
			
			System.out.println("sql : " + sql);
			
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setInt(1,id);
			
			ResultSet rs = pstmt.executeQuery();
			
			StudentBean bean = null;
			
			while(rs.next()) {
				bean = new StudentBean();
				
				bean.setId(rs.getInt(1));
				bean.setFirst_name(rs.getString(2));
				bean.setLast_name(rs.getString(3));
				bean.setDob(rs.getDate(4));
				bean.setGender(rs.getString(5));
				bean.setMobile_No(rs.getString(6));
				bean.setEmail(rs.getString(7));
				bean.setCollege_id(rs.getInt(8));
				bean.setCollege_name(rs.getString(9));
				bean.setCreatedby(rs.getString(10));
			    bean.setModifiedby(rs.getString(11));
				bean.setCreated_datetime(rs.getTimestamp(12));
				bean.setModified_datetime(rs.getTimestamp(13));
				
		}
			return bean;
	   }   
	   
	   public StudentBean findbyemail(String email) throws Exception {
		   
		   Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
			
			StringBuffer sql = new StringBuffer ("select * from st_student where email = ?");
			
			System.out.println("sql : " + sql);
			
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1,email);
			
			ResultSet rs = pstmt.executeQuery();
			
			StudentBean bean = null;
			
			while(rs.next()) {
				bean = new StudentBean();
				
				bean.setId(rs.getInt(1));
				bean.setFirst_name(rs.getString(2));
				bean.setLast_name(rs.getString(3));
				bean.setDob(rs.getDate(4));
				bean.setGender(rs.getString(5));
				bean.setMobile_No(rs.getString(6));
				bean.setEmail(rs.getString(7));
				bean.setCollege_id(rs.getInt(8));
				bean.setCollege_name(rs.getString(9));
				bean.setCreatedby(rs.getString(10));
			    bean.setModifiedby(rs.getString(11));
				bean.setCreated_datetime(rs.getTimestamp(12));
				bean.setModified_datetime(rs.getTimestamp(13));
			}
			
			return bean;	   
	   }
	   
	   public List Search (StudentBean bean, int pageNo,int pageSize) throws Exception {
		   
		   Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

            StringBuffer sql = new StringBuffer ("select * from st_student where 1 = 1") ;
            
            if(bean != null) {
            	if (bean.getId() > 0) {
    				sql.append(" and ID =" + bean.getId());
            }
	   }
            if(pageSize > 0)	{
            	pageNo = (pageNo - 1) * pageSize ;
            	sql.append(" limit "+ pageNo +"," + pageSize);
            }
            System.out.println("sql :" + sql);
            
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());

    		ResultSet rs = pstmt.executeQuery();

    		List list = new ArrayList();
    		
            while(rs.next()) {
            	bean = new StudentBean();
            	
            	bean.setId(rs.getInt(1));
				bean.setFirst_name(rs.getString(2));
				bean.setLast_name(rs.getString(3));
				bean.setDob(rs.getDate(4));
				bean.setGender(rs.getString(5));
				bean.setMobile_No(rs.getString(6));
				bean.setEmail(rs.getString(7));
				bean.setCollege_id(rs.getInt(8));
				bean.setCollege_name(rs.getString(9));
				bean.setCreatedby(rs.getString(10));
			    bean.setModifiedby(rs.getString(11));
				bean.setCreated_datetime(rs.getTimestamp(12));
				bean.setModified_datetime(rs.getTimestamp(13));
				
				list.add(bean);
		 }
            	return list;
            }
}


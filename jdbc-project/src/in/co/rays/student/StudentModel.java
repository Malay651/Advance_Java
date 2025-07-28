package in.co.rays.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.com.rays.user.UserBean;

public class StudentModel {
	
	public Integer nextpk() throws Exception {
		
		int pk = 0;
		  
		Class.forName("com.mysql.cj.jdbc.Driver");
		 
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement  pstmt = conn.prepareStatement("select max(id) from student");
		
		    ResultSet rs = pstmt.executeQuery();
		    
		    while(rs.next()) {
		    	pk = rs.getInt(1);
		    }
		    return pk + 1 ;
		}	
	      
	 public void add(StudentBean bean) throws Exception {
	    	
	    	int pk = nextpk();
	    	
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

			PreparedStatement pstmt = conn.prepareStatement("insert into student values(?, ?, ?, ?, ?, ?, ?,?)");

			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getFirst_Name());
			pstmt.setString(3, bean.getLast_name());
			pstmt.setDate(4, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(5, bean.getGender());
			pstmt.setString(6, bean.getMobile_No());
			pstmt.setString(7, bean.getEmail_id());
			pstmt.setString(8,bean.getCollege_Name());
			

			int i = pstmt.executeUpdate();

			System.out.println("data inserted: " + i);
		}
     public void update(StudentBean bean) throws Exception {
    	 
    	 Class.forName("com.mysql.cj.jdbc.Driver");

 		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

 		PreparedStatement pstmt = conn.prepareStatement(
 				"update student set first_name = ?, last_name = ?, dob= ?, gender = ?, mobile_no = ?, email = ? , college_name = ? where id = ?");

 		pstmt.setString(1, bean.getFirst_Name());
 		pstmt.setString(2, bean.getLast_name());
 		pstmt.setDate(3,  new java.sql.Date(bean.getDob().getTime()));
 		pstmt.setString(4, bean.getGender());
 		pstmt.setString(5, bean.getMobile_No());
 		pstmt.setString(6, bean.getEmail_id());
 		pstmt.setString(7, bean.getCollege_Name());
        pstmt.setInt(8,bean.getId());
        
 		int i = pstmt.executeUpdate();

 		System.out.println("data updated: " + i);
 	}

 	public void delete(int id) throws Exception {

 		Class.forName("com.mysql.cj.jdbc.Driver");

 		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

 		PreparedStatement pstmt = conn.prepareStatement("delete from student where id = ?");

 		pstmt.setInt(1, id);

 		int i = pstmt.executeUpdate();

 		System.out.println("data deleted: " + i);
 	}
 	
 	public StudentBean findbypk(int id) throws Exception {
 		
 		Class.forName("com.mysql.cj.jdbc.Driver");

 		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

 		PreparedStatement pstmt = conn.prepareStatement(" select * from student where id = ? ");
        
 		pstmt.setInt(1,id);
 		
 		StudentBean bean = null;
 		
 		ResultSet rs = pstmt.executeQuery();
 		
 		while(rs.next()) {
 			bean = new StudentBean();
 			bean.setId(rs.getInt(1));
 			bean.setFirst_Name(rs.getNString(2));
 			bean.setLast_name(rs.getString(3));
 			bean.setDob(rs.getDate(4));
 			bean.setGender(rs.getString(5));
 			bean.setMobile_No(rs.getString(6));
 			bean.setEmail_id(rs.getString(7));
 			bean.setCollege_Name(rs.getString(8));
 		}
 		  return bean;
 	}
 	
 	  public StudentBean findbyemail(String email) throws Exception {
 		  
 		 Class.forName("com.mysql.cj.jdbc.Driver");

  		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

  		PreparedStatement pstmt = conn.prepareStatement(" select * from student where email = ? ");
         
  		pstmt.setString(1,email);
  		
  		StudentBean bean = null;
  		
  		ResultSet rs = pstmt.executeQuery();
  		
  		while(rs.next()) {
  			bean = new StudentBean();
  			bean.setId(rs.getInt(1));
 			bean.setFirst_Name(rs.getNString(2));
 			bean.setLast_name(rs.getString(3));
 			bean.setDob(rs.getDate(4));
 			bean.setGender(rs.getString(5));
 			bean.setMobile_No(rs.getString(6));
 			bean.setEmail_id(rs.getString(7));
 			bean.setCollege_Name(rs.getString(8));
 		}
 		  return bean;
}
 	  public List  search(StudentBean bean, int pageNo , int pageSize) throws Exception {
 		 Class.forName("com.mysql.cj.jdbc.Driver");

   		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

       StringBuffer sql = new StringBuffer (" select * from student where 1=1");
 		  
       if (bean != null) {
    	   if(bean.getId() > 0) {
    		   sql.append(" and dob =" + bean.getId());
    		   }
    	   if(bean.getFirst_Name() != null && bean.getFirst_Name().length()>0) {
    		   sql.append( " and name like =' " + bean.getFirst_Name() + "%'");
    		    }
    	   if (bean.getLast_name() != null && bean.getLast_name().length() > 0) {
				sql.append(" and last_name like '" + bean.getLast_name() + "%'");
			}
    	   if (bean.getDob() != null) {
				sql.append(" and dob =" + bean.getDob());
			}
    	   if (bean.getGender() != null && bean.getGender().length()>0) {
    		   sql.append( " and gender = " + bean.getGender());
    	   }
    	   if (bean.getMobile_No() != null && bean.getMobile_No().length() > 0) {
    		   sql.append(" and mobile no = " + bean.getMobile_No());
    	   }       
			if (bean.getEmail_id() != null && bean.getEmail_id().length() > 0) {
				sql.append(" and email_id like '" + bean.getEmail_id() + "%'");
			}
			if (bean.getCollege_Name() !=null && bean.getEmail_id().length() > 0) {
				sql.append(" and college_name like " + bean.getCollege_Name() + "%'");
			}
		  
		}
       if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + ", " + pageSize);
		}

		System.out.println("sql => " + sql);

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {
			bean = new StudentBean();
  			bean.setId(rs.getInt(1));
 			bean.setFirst_Name(rs.getNString(2));
 			bean.setLast_name(rs.getString(3));
 			bean.setDob(rs.getDate(4));
 			bean.setGender(rs.getString(5));
 			bean.setMobile_No(rs.getString(6));
 			bean.setEmail_id(rs.getString(7));
 			bean.setCollege_Name(rs.getString(8));
 			
			list.add(bean);
		}
		return list;
        
 	  }	  

}	      




package in.co.rays.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.CourseBean;


public class CourseModel {
	
public Integer nextpk() throws Exception {
		
		int pk = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_course");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
		}
		return pk + 1;
}


    public void Add(CourseBean bean) throws Exception {
    	
    	int pk = nextpk();
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into st_course values (?,?,?,?,?,?,?,?)");

		pstmt.setLong(1,pk);
		pstmt.setString(2,bean.getName());
		pstmt.setString(3,bean.getDuration());
		pstmt.setString(4,bean.getDescription());
	    pstmt.setString(5, bean.getCreatedby());
		pstmt.setString(6, bean.getModifiedby());
		pstmt.setTimestamp(7, bean.getCreateddatetime());
		pstmt.setTimestamp(8, bean.getModifieddatetime());
      
		int i = pstmt.executeUpdate();
		System.out.println("data inserted " + i);
		
    }

   public void Update(CourseBean bean) throws Exception {
	   
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("update st_course set name = ?,duration = ?,description = ?,created_by = ?,modified_by = ?,created_datetime = ?,modified_datetime = ? where id = ?");
        
		pstmt.setString(1,bean.getName());
		pstmt.setString(2,bean.getDuration());
		pstmt.setString(3,bean.getDescription());
	    pstmt.setString(4, bean.getCreatedby());
		pstmt.setString(5, bean.getModifiedby());
		pstmt.setTimestamp(6, bean.getCreateddatetime());
		pstmt.setTimestamp(7, bean.getModifieddatetime());
        pstmt.setLong(8,bean.getId());
		
		int i = pstmt.executeUpdate();
		
		System.out.println("data updated " + i);
		
   }

   public void Delete(int id) throws Exception {
	   
	   Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("delete from st_course where id = ?");
		
		pstmt.setLong(1,id);
		
		int i = pstmt.executeUpdate();
		System.out.println("data deleted :" + i);
	   
   }

   public CourseBean findbypk(long id) throws Exception {
	   
	   Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		StringBuffer sql = new StringBuffer ("select * from st_course where id = ?");
		
		System.out.println("sql :" + sql);
		
		PreparedStatement pstmt = conn.prepareStatement (sql.toString());
		
		pstmt.setLong(1,id);
	   
		ResultSet rs = pstmt.executeQuery();
		
		CourseBean bean = null;
		
		while(rs.next()) {
			
			bean = new CourseBean();
			
			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setDuration(rs.getString(3));
			bean.setDescription(rs.getString(4));
			bean.setCreatedby(rs.getString(5));
			bean.setModifiedby(rs.getString(6));
		    bean.setCreateddatetime(rs.getTimestamp(7));
			bean.setModifieddatetime(rs.getTimestamp(8));
		}
		return bean;
   }
      
    public List Search (CourseBean bean, int pageNo,int pageSize) throws Exception {
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
      
		StringBuffer sql = new StringBuffer("select * from st_course where 1=1 ");
		
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
			 bean = new CourseBean();
			 
			    bean.setId(rs.getLong(1));
				bean.setName(rs.getString(2));
				bean.setDuration(rs.getString(3));
				bean.setDescription(rs.getString(4));
				bean.setCreatedby(rs.getString(5));
				bean.setModifiedby(rs.getString(6));
			    bean.setCreateddatetime(rs.getTimestamp(7));
				bean.setModifieddatetime(rs.getTimestamp(8));
		
			 
			   list.add(bean);
		 }
		 return list;
}
}



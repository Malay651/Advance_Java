package in.co.rays.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.SubjectBean;


public class SubjectModel {

   public Integer nextpk() throws Exception {
		
		int pk = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_subject");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
		}
		return pk + 1;
}


    public void Add(SubjectBean bean) throws Exception {
    	
    	int pk = nextpk();
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into st_subject values (?,?,?,?,?,?,?,?,?)");

		pstmt.setLong(1,pk);
		pstmt.setString(2,bean.getName());
		pstmt.setLong(3,bean.getCourseId());
		pstmt.setString(4,bean.getCourseName());
		pstmt.setString(5,bean.getDescription());
		pstmt.setString(6,bean.getCreatedby());
		pstmt.setString(7,bean.getModifiedby());
		pstmt.setTimestamp(8,bean.getCreateddatetime());
		pstmt.setTimestamp(9,bean.getModifieddatetime());
      
		int i = pstmt.executeUpdate();
		
		System.out.println("data inserted " + i);
		
    }

   public void Update(SubjectBean bean) throws Exception {
	   
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("update st_subject set name = ?,course_id = ?,course_name = ?,description = ?,created_by = ?,modified_by = ?,created_datetime = ?,modified_datetime = ? where id = ?");
        
	
		pstmt.setString(1,bean.getName());
		pstmt.setInt(2,bean.getCourseId());
		pstmt.setString(3,bean.getCourseName());
		pstmt.setString(4,bean.getDescription());
		pstmt.setString(5, bean.getCreatedby());
		pstmt.setString(6, bean.getModifiedby());
		pstmt.setTimestamp(7, bean.getCreateddatetime());
		pstmt.setTimestamp(8, bean.getModifieddatetime());
		pstmt.setLong(9,bean.getId());
		
		int i = pstmt.executeUpdate();
		
		System.out.println("data updated " + i);
		
   }

   public void Delete(int id) throws Exception {
	   
	   Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("delete from st_subject where id = ?");
		
		pstmt.setLong(1,id);
		
		int i = pstmt.executeUpdate();
		
		System.out.println("data deleted :" + i);
	   
   }

   public SubjectBean findbypk(long id) throws Exception {
	   
	   Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		StringBuffer sql = new StringBuffer ("select * from st_subject where id = ?");
		
		System.out.println("sql :" + sql);
		
		PreparedStatement pstmt = conn.prepareStatement (sql.toString());
		
		pstmt.setLong(1,id);
	   
		ResultSet rs = pstmt.executeQuery();
		
		SubjectBean bean = null;
		
		while(rs.next()) {
			
			bean = new SubjectBean();
			
			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setCourseId(rs.getInt(3));
			bean.setCourseName(rs.getString(4));
			bean.setDescription(rs.getString(5));
			bean.setCreatedby(rs.getString(6));
			bean.setModifiedby(rs.getString(7));
		    bean.setCreateddatetime(rs.getTimestamp(8));
			bean.setModifieddatetime(rs.getTimestamp(9));
		}
		return bean;
   }
      
    public List Search (SubjectBean bean, int pageNo,int pageSize) throws Exception {
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
      
		StringBuffer sql = new StringBuffer("select * from st_subject where 1=1 ");
		
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
			 bean = new SubjectBean();
			 
			    bean.setId(rs.getLong(1));
			    bean.setName(rs.getString(2));
				bean.setCourseId(rs.getInt(3));
				bean.setCourseName(rs.getString(4));
				bean.setDescription(rs.getString(5));
				bean.setCreatedby(rs.getString(6));
				bean.setModifiedby(rs.getString(7));
			    bean.setCreateddatetime(rs.getTimestamp(8));
				bean.setModifieddatetime(rs.getTimestamp(9));
			
				list.add(bean);
		 }
		 return list;
}

}

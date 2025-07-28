package in.co.rays.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.CourseBean;
import in.co.rays.bean.StudentBean;
import in.co.rays.bean.SubjectBean;
import in.co.rays.bean.TimeTableBean;


public class TimeTableModel {

   public Integer nextpk() throws Exception {
		
		int pk = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_timetable");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
		}
		return pk + 1;
}


    public void Add(TimeTableBean bean) throws Exception {
   
    	CourseModel model = new CourseModel();
    	CourseBean  CourseBean = model.findbypk(bean.getCourse_Id());
    	bean.setCourseName(CourseBean.getName());
    	
    	SubjectModel model1 = new SubjectModel();
    	SubjectBean subjectBean = model1.findbypk(bean.getSubjectId());
    	bean.setSubjectName(subjectBean.getName());
    	
        int pk = nextpk();
        
    	Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into st_timetable values (?,?,?,?,?,?,?,?,?,?,?,?,?)");

		pstmt.setLong(1,pk);
		pstmt.setString(2,bean.getSemester());
		pstmt.setString(3,bean.getDescription());
		pstmt.setDate(4, new java.sql.Date(bean.getExamdate().getTime()));
	    pstmt.setString(5, bean.getExamtime());
		pstmt.setInt(6,bean.getCourseid());
		pstmt.setString(7,bean.getCoursename());
		pstmt.setInt(8,bean.getSubjectId());
		pstmt.setString(9,bean.getSubjectName());
		pstmt.setString(10,bean.getCreatedby());
		pstmt.setString(11,bean.getModifiedby());
		pstmt.setTimestamp(12, bean.getCreateddatetime());
		pstmt.setTimestamp(13, bean.getModifieddatetime());
      
		int i = pstmt.executeUpdate();
		
		System.out.println("data inserted " + i);
		
    }

   public void Update(TimeTableBean bean) throws Exception {
	   
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("update st__timetable set semester = ?,description = ? exam_date = ?,exam_time = ?,course_id = ?,course_name = ?,created_by = ?,modified_by = ?,created_datetime = ?,modified_datetime = ? where id = ?");
        
		
		pstmt.setString(1,bean.getSemester());
		pstmt.setString(2,bean.getDescription());
		pstmt.setDate(3, new java.sql.Date(bean.getExamdate().getTime()));
		pstmt.setString(4,bean.getExamtime());
		pstmt.setInt(5,bean.getCourseid());
		pstmt.setString(6,bean.getCoursename());
		pstmt.setString(7,bean.getCreatedby());
		pstmt.setString(8,bean.getModifiedby());
		pstmt.setTimestamp(9, bean.getCreateddatetime());
		pstmt.setTimestamp(10, bean.getModifieddatetime());
        pstmt.setLong(11,bean.getId());
        
		int i = pstmt.executeUpdate();
		System.out.println("data updated " + i);
		
   }

   public void Delete(int id) throws Exception {
	   
	   Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("delete from st_timetable where id = ?");
		
		pstmt.setLong(1,id);
		
		int i = pstmt.executeUpdate();
		
		System.out.println("data deleted :" + i);
	   
   }

   public TimeTableBean findbypk(long id) throws Exception {
	   
	   Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		StringBuffer sql = new StringBuffer ("select * from st_timetable where id = ?");
		
		System.out.println("sql :" + sql);
		
		PreparedStatement pstmt = conn.prepareStatement (sql.toString());
		
		pstmt.setLong(1,id);
	   
		ResultSet rs = pstmt.executeQuery();
		
	   TimeTableBean bean = null;
		
		while(rs.next()) {
			
			bean = new TimeTableBean();
			
			bean.setId(rs.getLong(1));
			bean.setSemester(rs.getString(2));
			bean.setDescription(rs.getString(3));
			bean.setExamdate(rs.getDate(4));
			bean.setExamtime(rs.getString(5));
			bean.setCourseid(rs.getInt(6));
			bean.setCoursename(rs.getString(7));
			bean.setCreatedby(rs.getString(8));
			bean.setModifiedby(rs.getString(9));
		    bean.setCreateddatetime(rs.getTimestamp(10));
			bean.setModifieddatetime(rs.getTimestamp(11));
		}
		return bean;
   }
      
    public List Search (TimeTableBean bean, int pageNo,int pageSize) throws Exception {
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
      
		StringBuffer sql = new StringBuffer("select * from st_timetable where 1=1 ");
		
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
			 bean = new TimeTableBean();
			 
			    bean.setId(rs.getLong(1));
				bean.setSemester(rs.getString(2));
				bean.setDescription(rs.getString(3));
				bean.setExamdate(rs.getDate(4));
				bean.setExamtime(rs.getString(5));
				bean.setCourseid(rs.getInt(6));
				bean.setCoursename(rs.getString(7));
				bean.setCreatedby(rs.getString(8));
				bean.setModifiedby(rs.getString(9));
			    bean.setCreateddatetime(rs.getTimestamp(10));
				bean.setModifieddatetime(rs.getTimestamp(11));
		      list.add(bean);
		 }
		 return list;
}
}


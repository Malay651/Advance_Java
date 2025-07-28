package in.co.rays.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.MarksheetBean;

public class MarksheetModel {
	
	public Integer nextpk() throws Exception {
		
		int pk = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_marksheet");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
		}
		return pk + 1;
}


    public void Add(MarksheetBean bean) throws Exception {
    	
    	int pk = nextpk();
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into st_marksheet values (?,?,?,?,?,?,?,?,?,?,?)");

		pstmt.setLong(1,pk);
		pstmt.setString(2,bean.getRollNo());
		pstmt.setLong(3,bean.getStudentId());
		pstmt.setString(4,bean.getName());
		pstmt.setInt(5,bean.getPhysics());
		pstmt.setInt(6,bean.getChemistry());
		pstmt.setInt(7,bean.getMaths());
		pstmt.setString(8, bean.getCreatedby());
		pstmt.setString(9, bean.getModifiedby());
		pstmt.setTimestamp(10, bean.getCreateddatetime());
		pstmt.setTimestamp(11, bean.getModifieddatetime());
      
		int i = pstmt.executeUpdate();
		System.out.println("data inserted " + i);
		
    }

   public void Update(MarksheetBean bean) throws Exception {
	   
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("update st_marksheet set roll_no = ?,student_id = ?,name = ?,physics = ?,chemistry = ?,maths = ?,created_by = ?,modified_by = ?,created_datetime = ?,modified_datetime = ? where id = ?");
        
		
		pstmt.setString(1,bean.getRollNo());
		pstmt.setLong(2,bean.getStudentId());
		pstmt.setString(3,bean.getName());
		pstmt.setInt(4,bean.getPhysics());
		pstmt.setInt(5,bean.getChemistry());
		pstmt.setInt(6,bean.getMaths());
		pstmt.setString(7, bean.getCreatedby());
		pstmt.setString(8, bean.getModifiedby());
		pstmt.setTimestamp(9, bean.getCreateddatetime());
		pstmt.setTimestamp(10, bean.getModifieddatetime());
		pstmt.setLong(11,bean.getId());
		
		int i = pstmt.executeUpdate();
		System.out.println("data updated " + i);
		
   }

   public void Delete(int id) throws Exception {
	   
	   Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("delete from st_marksheet where id = ?");
		
		pstmt.setLong(1,id);
		
		int i = pstmt.executeUpdate();
		System.out.println("data deleted :" + i);
	   
   }

   public MarksheetBean findbypk(long id) throws Exception {
	   
	   Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		StringBuffer sql = new StringBuffer ("select * from st_marksheet where id = ?");
		
		System.out.println("sql :" + sql);
		
		PreparedStatement pstmt = conn.prepareStatement (sql.toString());
		
		pstmt.setLong(1,id);
	   
		ResultSet rs = pstmt.executeQuery();
		
		MarksheetBean bean = null;
		
		while(rs.next()) {
			
			bean = new MarksheetBean();
			
			bean.setId(rs.getLong(1));
			bean.setRollNo(rs.getString(2));
			bean.setStudentId(rs.getLong(3));
			bean.setName(rs.getString(4));
			bean.setPhysics(rs.getInt(5));
			bean.setChemistry(rs.getInt(6));
			bean.setMaths(rs.getInt(7));
			bean.setCreatedby(rs.getString(8));
			bean.setModifiedby(rs.getString(9));
		    bean.setCreateddatetime(rs.getTimestamp(10));
			bean.setModifieddatetime(rs.getTimestamp(11));
		}
		return bean;
   }
      
    public List Search (MarksheetBean bean, int pageNo,int pageSize) throws Exception {
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
      
		StringBuffer sql = new StringBuffer("select * from st_marksheet where 1=1 ");
		
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
			 bean = new MarksheetBean();
			 
			    bean.setId(rs.getLong(1));
				bean.setRollNo(rs.getString(2));
				bean.setStudentId(rs.getLong(3));
				bean.setName(rs.getString(4));
				bean.setPhysics(rs.getInt(5));
				bean.setChemistry(rs.getInt(6));
				bean.setMaths(rs.getInt(7));
				bean.setCreatedby(rs.getString(8));
				bean.setModifiedby(rs.getString(9));
			    bean.setCreateddatetime(rs.getTimestamp(10));
				bean.setModifieddatetime(rs.getTimestamp(11));
		      list.add(bean);
		 }
		 return list;
}
}
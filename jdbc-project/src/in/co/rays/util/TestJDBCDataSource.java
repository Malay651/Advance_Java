package in.co.rays.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class TestJDBCDataSource {
	
	public static void main(String[] args) throws Exception {
		
		for (int i =1; i<=30; i++) {
			 System.out.println("connection :" + i);
			 
			 testGet();
		}
	}
     public static void testGet() throws Exception  {
    	 
    	 Connection conn = JDBCDataSource.getConnection();
    	 
    	 PreparedStatement pstmt = conn.prepareStatement ("select * from role where id = 1");
    	 
    	 ResultSet rs = pstmt.executeQuery();
    	 
    	 while(rs.next()) {
    		  System.out.println(rs.getInt(1));
    		  System.out.println(rs.getString(2));
    		  System.out.println(rs.getString(3));
    	 }
    	 
     }
}

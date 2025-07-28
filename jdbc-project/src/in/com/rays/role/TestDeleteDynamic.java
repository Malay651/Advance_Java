package in.com.rays.role;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestDeleteDynamic {
	public static void main(String[] args) throws Exception {
		
		//testDelete1();
		//testDelete2();
		testDelete3(3);
		
}


		
		 public static void testDelete1() throws Exception {
			 
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	        	
	        	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
	        	
	        	PreparedStatement pstmt = conn.prepareStatement ("delete from role where id = 1");
	        	
	        	int i = pstmt.executeUpdate();
	        	
	        	System.out.println("data deleted :" + i);
	        	
	        }
	        
	        public static void testDelete2() throws Exception {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	        	
	        	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
	        	
	        	PreparedStatement pstmt = conn.prepareStatement ("delete from role where id = ?");
	        	
	           pstmt.setInt(1,2);
	           
	           int i = pstmt.executeUpdate();
	           
	        	System.out.println("data deleted :" + i);
	        }
	        
	        public static void testDelete3(int Id) throws Exception {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	        	
	        	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
	        	
	        	PreparedStatement pstmt = conn.prepareStatement ("delete from role where id = ?");
	            
	        	pstmt.setInt (1,Id);
	        	
	        	int i = pstmt.executeUpdate();
	        	
	        	System.out.println("data deleted :" + i);
	        }
}





package in.com.rays.dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestInsertDynamic {
public static void main(String[] args) throws Exception {                                     
    // TestInsert1();
	//TestInsert2();
	//TestInsert3(6,106,"amay",46,63,84);
	
	MarksheetBean bean = new MarksheetBean();
	    bean.setId(3);
	   bean.setRollno(110);
	   bean.setName("shyam");
	   bean.setPhysics(40);
	   bean.setChemistry(50);
	   bean.setMaths(60);
	   
	   TestInsert4(bean);
}   
	

	
		public static void TestInsert1 () throws Exception {
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
		
		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values (5,105,'sonu',50,50,50)");
				
		int i = pstmt.executeUpdate();

		System.out.println("data inserted => " + i);
		
	}   
       public static void TestInsert2 () throws Exception {
    	   Class.forName("com.mysql.jc.jdbc.Driver");
    	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
    	   
    	   PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
    	       
    	   pstmt.setInt(1,3);
    	   pstmt.setInt(2,103 );
    	   pstmt.setString(3,"rajat");
    	   pstmt.setInt(4,65);
    	   pstmt.setInt(5, 75);
    	   pstmt.setInt(6,85);
    	     int i = pstmt.executeUpdate();
    	     System.out.println("data inserted :" + i);
    	     
   }
       public static void TestInsert3 (int id,int rollNo,String name,int physics,int chemistry,int maths) throws Exception {
    	   Class.forName("com.mysql.cj.jdbc.Driver");
    	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
    	   
    	   PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
    	       pstmt.setInt(1, id);
    	       pstmt.setInt(2,rollNo);
    	       pstmt.setString(3,name);
    	       pstmt.setInt(4,physics);
    	       pstmt.setInt(5,chemistry);
    	       pstmt.setInt(6,maths);
    	       
    	       int i = pstmt.executeUpdate();
    	       System.out.println("data inserted" + i);
   
       }
       public static void TestInsert4(MarksheetBean bean) throws Exception {
       Class.forName("com.mysql.cj.jdbc.Driver");
	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
	   
	   PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
	   
	   pstmt.setInt(1,bean.getId());
	 
	   pstmt.setInt(2,bean.getRollno());
	   pstmt.setString(3,bean.getName());
	   pstmt.setInt(4,bean.getPhysics());
	   pstmt.setInt(5,bean.getChemistry());
	   pstmt.setInt(6,bean.getMaths());
	   System.out.println(bean.getId());
	   
	   int i = pstmt.executeUpdate();
	   System.out.println("data inserted :" + i);
       }    
}

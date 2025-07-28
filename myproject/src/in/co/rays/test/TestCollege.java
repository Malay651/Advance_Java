package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.CollegeBean;

import in.co.rays.model.CollegeModel;


public class TestCollege {
 public static void main(String[] args) throws Exception {
	
	//testnextpk();
	 //testAdd();
	// testUpdate();
	// testDelete();
	 testfindbypk();
	 //testfindbyname();
	testSearch();
}
 
 
   public static void testnextpk() throws Exception {
	   
		CollegeModel model = new CollegeModel();

		int pk = model.nextpk();

		System.out.println("next primary key:" + pk);
	}

 
    public static void testAdd() throws Exception {
	 
	 CollegeBean bean = new CollegeBean();
	 
	// bean.setId(1);
	 bean.setName("rishna");
	 bean.setAddress("indore");
	 bean.setState("mp");
	 bean.setCity("bhopal");
	 bean.setPhone_No("9546785913");
	 bean.setCreated_by("malay");
	 bean.setModified_by("ram");
	 bean.setCreated_datetime(new Timestamp(new Date().getTime()));
	 bean.setModified_datetime(new Timestamp(new Date().getTime()));
	 
	 CollegeModel model = new CollegeModel();
	 
	 model.Add(bean);
 }
   
   public static void testUpdate() throws Exception {
	   
	   CollegeBean bean = new CollegeBean();
		 
		 bean.setName("rohan");
		 bean.setAddress("pune");
		 bean.setState("ap");
		 bean.setCity("hyderabad");
		 bean.setPhone_No("9546785913");
		 bean.setCreated_by("shyam");
		 bean.setModified_by("ram");
		 bean.setCreated_datetime(new Timestamp(new Date().getTime()));
		 bean.setModified_datetime(new Timestamp(new Date().getTime()));
		 bean.setId(0);
		 
		 CollegeModel model = new CollegeModel();
		 
		 model.Update(bean);
    }
    
      public static void testDelete() throws Exception {
	   
	   CollegeModel model = new CollegeModel();
	        
	   model.Delete(1);
	 }
   
      public static void testfindbypk() throws Exception {
      
	   CollegeModel model = new CollegeModel();
       CollegeBean bean = model.findbypk(1);
	   	
	   	System.out.print(bean.getId());
	   	System.out.print("\t" + bean.getName());
	   	System.out.print("\t" + bean.getAddress());
	   	System.out.print("\t" + bean.getState());
	   	System.out.print("\t" + bean.getCity());
	   	System.out.print("\t" + bean.getPhone_No());
	   	System.out.print("\t" + bean.getCreated_by());
	   	System.out.print("\t" + bean.getModified_by());
	   	System.out.print("\t" + bean.getCreated_datetime());
	   	System.out.println("\t" +bean.getModified_datetime());
	   	
	   }

	   public static void testSearch() throws Exception {
		   
	   	CollegeBean bean = new CollegeBean();

	   	CollegeModel model = new CollegeModel();

	   	List list = model.Search(null,1,5);

	   	Iterator it = list.iterator();

	   	while (it.hasNext()) {
	     
	   	 bean = (CollegeBean) it.next();

	   	System.out.print(bean.getId());
	   	System.out.print("\t" + bean.getName());
	   	System.out.print("\t" + bean.getAddress());
	   	System.out.print("\t" + bean.getState());
	   	System.out.print("\t" + bean.getCity());
	   	System.out.print("\t" + bean.getPhone_No());
	   	System.out.print("\t" + bean.getCreated_by());
	   	System.out.print("\t" + bean.getModified_by());
	   	System.out.print("\t" + bean.getCreated_datetime());
	   	System.out.println("\t" +bean.getModified_datetime());
	   	


	   	}
	   }
	   }





package in.co.rays.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.FacultyBean;
import in.co.rays.model.FacultyModel;


public class TestFaculty {
	
	public static void main(String[] args) throws Exception {

		// testnextpk();
		 testAdd();
		// testUpdate();
		// testDelete();
		// testfindbypk();
	//	testSearch();
	}

	public static void testnextpk() throws Exception {

		FacultyModel model = new FacultyModel();

		int pk = model.nextpk();
		System.out.println("next primary key:" + pk);

	}

	public static void testAdd() throws Exception {

		FacultyBean bean = new FacultyBean();
     SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
 
		
		bean.setId(1);
		bean.setfirstName("malay");
		bean.setlastName("dongre");
		bean.setDob(sdf.parse("15-06-2020"));
		bean.setGender("male");
		bean.setMobile_No("9523647855");
		bean.setEmail("malay@123");
		bean.setCollege_Id(101);
		bean.setCollege_Name("svce");
		bean.setStudent_Id(201);
		bean.setStudent_Name("harsh");
		bean.setCreatedby("jal");
		bean.setModifiedby("gagan");
		bean.setCreateddatetime(new Timestamp(new Date().getTime()));
		bean.setModifieddatetime(new Timestamp(new Date().getTime()));

		FacultyModel model = new FacultyModel();
		model.Add(bean);
	}

	public static void testUpdate() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		FacultyBean bean = new FacultyBean();
		
		bean.setfirstName("vijay");
		bean.setlastName("dongre");
		bean.setDob(sdf.parse("15-06-2020"));
		bean.setGender("male");
		bean.setMobile_No("9523647855");
		bean.setEmail("malay@123");
		bean.setCollege_Id(101);
		bean.setCollege_Name("svce");
		bean.setStudent_Id(201);
		bean.setStudent_Name("harsh");
		bean.setCreatedby("jal");
		bean.setModifiedby("gagan");
		bean.setCreateddatetime(new Timestamp(new Date().getTime()));
		bean.setModifieddatetime(new Timestamp(new Date().getTime()));
        bean.setId(1);
	
		
		FacultyModel model = new FacultyModel();
		model.Update(bean);
	}

	public static void testDelete() throws Exception {
		
		FacultyModel model = new FacultyModel();

		model.Delete(1);
	}

	public static void testfindbypk() throws Exception {

		FacultyModel model = new FacultyModel();
	    FacultyBean bean = model.findbypk(1);
		
	    System.out.print(bean.getId());
		System.out.print("\t" + bean.getfirstName());
		System.out.print("\t" + bean.getlastName());
		System.out.print("\t" + bean.getDob());
		System.out.print("\t" + bean.getGender());
		System.out.print("\t" + bean.getMobile_No());
		System.out.print("\t" + bean.getEmail());
		System.out.println("\t" + bean.getCollege_Id());
		System.out.println("\t" + bean.getCollege_Name());
		System.out.println("\t" + bean.getCollege_Id());
		System.out.println("\t" + bean.getStudent_Id());
		System.out.println("\t" + bean.getStudent_Name());
		System.out.print("\t" + bean.getCreatedby());
		System.out.print("\t" + bean.getModifiedby());
		System.out.print("\t" + bean.getCreateddatetime());
		System.out.println("\t" + bean.getModifieddatetime());
	}
	

	public static void testSearch() throws Exception {

		FacultyBean bean = new FacultyBean();
		
		FacultyModel model = new FacultyModel();
		List list = model.Search(null, 1, 5);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (FacultyBean) it.next();
			
			 System.out.print(bean.getId());
				System.out.print("\t" + bean.getfirstName());
				System.out.print("\t" + bean.getlastName());
				System.out.print("\t" + bean.getDob());
				System.out.print("\t" + bean.getGender());
				System.out.print("\t" + bean.getMobile_No());
				System.out.print("\t" + bean.getEmail());
				System.out.println("\t" + bean.getCollege_Id());
				System.out.println("\t" + bean.getCollege_Name());
				System.out.println("\t" + bean.getCollege_Id());
				System.out.println("\t" + bean.getStudent_Id());
				System.out.println("\t" + bean.getStudent_Name());
				System.out.print("\t" + bean.getCreatedby());
				System.out.print("\t" + bean.getModifiedby());
				System.out.print("\t" + bean.getCreateddatetime());
				System.out.println("\t" + bean.getModifieddatetime());
			

			}
	}
}








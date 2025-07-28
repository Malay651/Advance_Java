package in.co.rays.student;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import in.co.rays.marksheet.MarksheetBean;
import in.co.rays.marksheet.MarksheetModel;

public class TestStudent {

	public static void main(String[] args) throws Exception {
		// testnextpk();
		//testadd();
		//testupdate();
		//testdelete();
		//testfindbypk();
		//testbyfindbyemail();
		testSearch();
	}

	public static void testnextpk() throws Exception {
		StudentModel model = new StudentModel();

		int pk = model.nextpk();

		System.out.println("next primary key:" + pk);
	}

	public static void testadd() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		StudentBean bean = new StudentBean();
		
		bean.setFirst_Name("rohan");
		bean.setLast_name("joshi");
		bean.setDob(sdf.parse("18-05-2000"));
		bean.setGender("male");
		bean.setMobile_No("9479432345");
		bean.setEmail_id("ram@gmail.com");
		bean.setCollege_Name("svce");

		StudentModel model = new StudentModel();
		model.add(bean);
}
	public static void testupdate() throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		StudentBean bean = new StudentBean();
		
		bean.setFirst_Name("anshul");
		bean.setLast_name("dongre");
		bean.setDob(sdf.parse("18-03-2000"));
		bean.setGender("male");
		bean.setMobile_No("6279432345");
		bean.setEmail_id("anshul@gmail.com");
		bean.setCollege_Name("chameli devi");
        bean.setId(1);
        
        StudentModel model = new StudentModel();
         model.update(bean);
	}
	
	public static void testdelete() throws Exception {
		
		StudentModel model = new StudentModel();
		  model.delete(5);
	}
	
	public static void testfindbypk() throws Exception {

		StudentModel model = new StudentModel();

		model.findbypk(3);
	}

	public static void testfindbyemail() throws Exception {

		StudentModel model = new StudentModel();

		model.findbyemail("anshul@gmail.com");
	}

	public static void testSearch() throws Exception {

		StudentBean bean = new StudentBean();

		bean.getFirst_Name();
		bean.getLast_name();
		bean.getDob();
		bean.getGender();
		bean.getMobile_No();
		bean.getEmail_id();
		bean.getCollege_Name();

		StudentModel model = new StudentModel();

		List list = model.search(null,0,0);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (StudentBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirst_Name());
			System.out.print("\t" + bean.getLast_name());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getMobile_No()); 
			System.out.print("\t" + bean.getEmail_id());
			System.out.println("\t" + bean.getCollege_Name());
			
			list.add(bean);
		}

	}


}


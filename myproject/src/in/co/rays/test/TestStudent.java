package in.co.rays.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.StudentBean;
import in.co.rays.model.StudentModel;

public class TestStudent {
	public static void main(String[] args) throws Exception {

		// testAdd();
		testUpdate();
		// testDelete();
    	//testfindbypk();
      //testfindbyemail();
		//testSearch();
	}

	public static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		StudentBean bean = new StudentBean();

		bean.setFirst_name("abc");
		bean.setLast_name("singh");
		bean.setDob(sdf.parse("25-09-1999"));
		bean.setGender("male");
		bean.setMobile_No("9579565853");
		bean.setEmail("malay123@.com");
		bean.setCollege_id(2);
		bean.setCollege_name("ips");
		bean.setCreatedby("vijay");
		bean.setModifiedby("malay");
		bean.setCreated_datetime(new Timestamp(new Date().getTime()));
		bean.setModified_datetime(new Timestamp(new Date().getTime()));

		StudentModel model = new StudentModel();
		model.Add(bean);

	}

	public static void testUpdate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		StudentBean bean = new StudentBean();

		bean.setFirst_name("rohan");
		bean.setLast_name("upadhayay");
		bean.setDob(sdf.parse("25-05-2002"));
		bean.setGender("male");
		bean.setMobile_No("9579565853");
		bean.setEmail("rohan13@.com");
		bean.setCollege_id(1);
		bean.setCollege_name("svce");
		bean.setCreatedby("vijay");
		bean.setModifiedby("malay");
		bean.setCreated_datetime(new Timestamp(new Date().getTime()));
		bean.setModified_datetime(new Timestamp(new Date().getTime()));
		bean.setId(1);

		StudentModel model = new StudentModel();

		model.Update(bean);
	}

	public static void testDelete() throws Exception {

		StudentModel model = new StudentModel();

		model.Delete(3);

	}

	public static void testfindbypk() throws Exception {

		StudentModel model = new StudentModel();

		StudentBean bean = model.findbypk(1);
		
		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirst_name());
			System.out.print("\t" + bean.getLast_name());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getMobile_No());
			System.out.print("\t" + bean.getEmail());
			System.out.print("\t" + bean.getCollege_id());
			System.out.print("\t" + bean.getCollege_name());
			System.out.print("\t" + bean.getCreatedby());
			System.out.print("\t" + bean.getModifiedby());
			System.out.print("\t" + bean.getCreated_datetime());
			System.out.println("\t" + bean.getModified_datetime());
		  } else {
			System.out.println("no record found");
		}
	}
	

	public static void testfindbyemail() throws Exception {

		StudentModel model = new StudentModel();

		StudentBean bean = model.findbyemail("rohan123@.com");

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirst_name());
			System.out.print("\t" + bean.getLast_name());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getMobile_No());
			System.out.print("\t" + bean.getEmail());
			System.out.print("\t" + bean.getCollege_id());
			System.out.print("\t" + bean.getCollege_name());
			System.out.print("\t" + bean.getCreatedby());
			System.out.print("\t" + bean.getModifiedby());
			System.out.print("\t" + bean.getCreated_datetime());
			System.out.println("\t" + bean.getModified_datetime());
		} else {
			System.out.println("no record found");
		}
	}

	public static void testSearch() throws Exception {

		StudentBean bean = new StudentBean();

		StudentModel model = new StudentModel();

		List list = model.Search(null, 1, 5);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (StudentBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirst_name());
			System.out.print("\t" + bean.getLast_name());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getMobile_No());
			System.out.print("\t" + bean.getEmail());
			System.out.print("\t" + bean.getCollege_id());
			System.out.print("\t" + bean.getCollege_name());
			System.out.print("\t" + bean.getCreatedby());
			System.out.print("\t" + bean.getModifiedby());
			System.out.print("\t" + bean.getCreated_datetime());
			System.out.println("\t" + bean.getModified_datetime());

		}
	}

}

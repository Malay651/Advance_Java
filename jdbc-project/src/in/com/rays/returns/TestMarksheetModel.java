package in.com.rays.returns;

import java.util.Iterator;
import java.util.List;


public class TestMarksheetModel {

	public static void main(String[] args) throws Exception {

		// testAdd();
	//	testUpdate();
		// testDelete();
		//testfindbypk();
		// testFindByRollNo();
		// testSearch();

	}

	public static void testAdd() throws Exception {
		MarksheetBean bean = new MarksheetBean();

		bean.setRollNo(109);
		bean.setName("shiv");
		bean.setPhysics(45);
		bean.setChemisrty(65);
		bean.setMaths(75);

		MarksheetModel model = new MarksheetModel();
		model.add(bean);
	}

	public static void testUpdate() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		bean.setId(9);
		bean.setRollNo(107);
		bean.setName("harsh");
		bean.setPhysics(75);
		bean.setChemisrty(30);
		bean.setMaths(30);

		MarksheetModel model = new MarksheetModel();

		model.update(bean);
	}

	public static void testDelete() throws Exception {

		MarksheetModel model = new MarksheetModel();
		model.delete(9);
	}

	public static void testfindbypk() throws Exception {

		MarksheetModel model = new MarksheetModel();

		MarksheetBean bean = model.findbypk(3);

		if (bean != null) {
			System.out.println(bean.getId());
			System.out.println("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemisrty());
			System.out.println("\t" + bean.getMaths());
		} else {
			System.out.println("id does not exist..");
		}
	}

	public static void testFindByroll_no() throws Exception {

		MarksheetModel model = new MarksheetModel();

		MarksheetBean bean = model.findbyrollNo(103);;

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemisrty());
			System.out.println("\t" + bean.getMaths());
		} else {
			System.out.println("Roll No does not exist...!!");
		}
	}

	public static void testSearch() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		

		MarksheetModel model = new MarksheetModel();

		List list = model.Search(null,0,0);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (MarksheetBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemisrty());
			System.out.println("\t" + bean.getMaths()); 
			
			list.add(bean);
		}

	}

}

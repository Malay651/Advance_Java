package in.co.rays.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestMarksheetModel {
	public static void main(String[] args) throws Exception {

		//testAdd();
		//testUpdate();
		//testDelete();
		testfindbyRollNo();
		//testfindbypk();
		//testSearch();

	}

	public static void testAdd() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		bean.setRollno(109);
		bean.setName("shiv");
		bean.setPhysics(45);
		bean.setChemistry(65);
		bean.setMaths(75);

		MarksheetModel model = new MarksheetModel();
		model.add(bean);

	}

	public static void testUpdate() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		bean.setId(12);
		bean.setRollno(109);
		bean.setName("harsh");
		bean.setPhysics(45);
		bean.setChemistry(55);
		bean.setMaths(75);

		MarksheetModel model = new MarksheetModel();
		model.update(bean);

	}

	public static void testDelete() throws Exception {

		MarksheetModel model = new MarksheetModel();

		model.delete(10);

	}

	public static void testfindbypk() throws Exception {

		MarksheetModel model = new MarksheetModel();

		model.findbypk(1);
	}

	public static void testfindbyRollNo() throws Exception {

		MarksheetModel model = new MarksheetModel();

		model.findByRollNo(108);
	}

	public static void testSearch() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		bean.setRollno(109);
		bean.setName("shiv");
		bean.setPhysics(45);
		bean.setChemistry(65);
		bean.setMaths(75);

		MarksheetModel model = new MarksheetModel();
		model.search(bean, 9, 107);
	}
}
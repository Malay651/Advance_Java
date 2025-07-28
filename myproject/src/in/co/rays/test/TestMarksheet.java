package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.CollegeBean;
import in.co.rays.bean.MarksheetBean;
import in.co.rays.model.CollegeModel;
import in.co.rays.model.MarksheetModel;

public class TestMarksheet {
	public static void main(String[] args) throws Exception {

		// testnextpk();
		// testAdd();
		// testUpdate();
		// testDelete();
		testfindbypk();
		// testSearch();
	}

	public static void testnextpk() throws Exception {

		MarksheetModel model = new MarksheetModel();

		int pk = model.nextpk();
		System.out.println("next primary key:" + pk);

	}

	public static void testAdd() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		bean.setRollNo("101");
		bean.setStudentId(201);
		bean.setName("malay");
		bean.setPhysics(50);
		bean.setChemistry(60);
		bean.setMaths(70);
		bean.setCreatedby("ajay");
		bean.setModifiedby("gagan");
		bean.setCreateddatetime(new Timestamp(new Date().getTime()));
		bean.setModifieddatetime(new Timestamp(new Date().getTime()));

		MarksheetModel model = new MarksheetModel();
		model.Add(bean);
	}

	public static void testUpdate() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		bean.setRollNo("101");
		bean.setStudentId(201);
		bean.setName("harsh");
		bean.setPhysics(50);
		bean.setChemistry(60);
		bean.setMaths(70);
		bean.setCreatedby("ajay");
		bean.setModifiedby("gagan");
		bean.setCreateddatetime(new Timestamp(new Date().getTime()));
		bean.setModifieddatetime(new Timestamp(new Date().getTime()));
		bean.setId(1);

		MarksheetModel model = new MarksheetModel();
		model.Update(bean);
	}

	public static void testDelete() throws Exception {

		MarksheetModel model = new MarksheetModel();

		model.Delete(1);
	}

	public static void testfindbypk() throws Exception {

		MarksheetModel model = new MarksheetModel();
	    MarksheetBean bean = model.findbypk(1);
		
		System.out.print(bean.getId());
		System.out.print("\t" + bean.getRollNo());
		System.out.print("\t" + bean.getStudentId());
		System.out.print("\t" + bean.getName());
		System.out.print("\t" + bean.getPhysics());
		System.out.print("\t" + bean.getChemistry());
		System.out.print("\t" + bean.getMaths());
		System.out.print("\t" + bean.getCreatedby());
		System.out.print("\t" + bean.getModifiedby());
		System.out.print("\t" + bean.getCreateddatetime());
		System.out.println("\t" + bean.getModifieddatetime());
	}
	

	public static void testSearch() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();
		List list = model.Search(null, 1, 5);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (MarksheetBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getStudentId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.print("\t" + bean.getMaths());
			System.out.print("\t" + bean.getCreatedby());
			System.out.print("\t" + bean.getModifiedby());
			System.out.print("\t" + bean.getCreateddatetime());
			System.out.println("\t" + bean.getModifieddatetime());
		}
	}
}

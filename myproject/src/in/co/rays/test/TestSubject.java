package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.SubjectBean;
import in.co.rays.model.StudentModel;
import in.co.rays.model.SubjectModel;


public class TestSubject {

	public static void main(String[] args) throws Exception {

		// testnextpk();
		  // testAdd();
		// testUpdate();
		// testDelete();
		// testfindbypk();
		 testSearch();
	}

	public static void testnextpk() throws Exception {

		SubjectModel model = new SubjectModel();

		int pk = model.nextpk();
		System.out.println("next primary key:" + pk);

	}

	public static void testAdd() throws Exception {

		SubjectBean bean = new SubjectBean();

		bean.setName("malay");
		bean.setCourseId(101);
		bean.setCourseName("java");
		bean.setDescription("corporate java");
		bean.setCreatedby("jal");
		bean.setModifiedby("gagan");
		bean.setCreateddatetime(new Timestamp(new Date().getTime()));
		bean.setModifieddatetime(new Timestamp(new Date().getTime()));

		SubjectModel model = new SubjectModel();
		model.Add(bean);
	}

	public static void testUpdate() throws Exception {

		SubjectBean bean = new SubjectBean();

	
		bean.setName("harsh");
		bean.setCourseId(102);
		bean.setCourseName("advance java");
		bean.setDescription("python");
		bean.setCreatedby("agni");
		bean.setModifiedby("gagan");
		bean.setCreateddatetime(new Timestamp(new Date().getTime()));
		bean.setModifieddatetime(new Timestamp(new Date().getTime()));
		bean.setId(1);

		SubjectModel model = new SubjectModel();
		model.Update(bean);
	}

	public static void testDelete() throws Exception {
		
		SubjectModel model = new SubjectModel();

		model.Delete(1);
	}

	public static void testfindbypk() throws Exception {

		SubjectModel model = new SubjectModel();
	    SubjectBean bean = model.findbypk(1);
		
		System.out.print(bean.getId());
		System.out.print("\t" + bean.getName());
		System.out.print("\t" + bean.getCourseId());
		System.out.print("\t" + bean.getCourseName());
		System.out.print("\t" + bean.getDescription());
		System.out.print("\t" + bean.getCreatedby());
		System.out.print("\t" + bean.getModifiedby());
		System.out.print("\t" + bean.getCreateddatetime());
		System.out.println("\t" + bean.getModifieddatetime());
	}
	

	public static void testSearch() throws Exception {

		SubjectBean bean = new SubjectBean();
		SubjectModel model = new SubjectModel();
		List list = model.Search(null, 1, 5);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (SubjectBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedby());
			System.out.print("\t" + bean.getModifiedby());
			System.out.print("\t" + bean.getCreateddatetime());
			System.out.println("\t" + bean.getModifieddatetime());
		}
	}
}



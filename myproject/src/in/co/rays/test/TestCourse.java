package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.CourseBean;
import in.co.rays.model.CourseModel;

public class TestCourse {
	
	public static void main(String[] args) throws Exception {

		// testnextpk();
		// testAdd();
		// testUpdate();
		// testDelete();
		//testfindbypk();
		 testSearch();
	}

	public static void testnextpk() throws Exception {

		CourseModel model = new CourseModel();

		int pk = model.nextpk();
		System.out.println("next primary key:" + pk);

	}

	public static void testAdd() throws Exception {

		CourseBean bean = new CourseBean();

		bean.setName("sejal");
		bean.setDuration("two hour");
		bean.setDescription("many times");
		bean.setCreatedby("ajay");
		bean.setModifiedby("gagan");
		bean.setCreateddatetime(new Timestamp(new Date().getTime()));
		bean.setModifieddatetime(new Timestamp(new Date().getTime()));

		CourseModel model = new CourseModel();
		model.Add(bean);
	}

	public static void testUpdate() throws Exception {

		CourseBean bean = new CourseBean();

		bean.setName("sejal");
		bean.setDuration("two hour");
		bean.setDescription("many times");
		bean.setCreatedby("vayu");
		bean.setModifiedby("gagan");
		bean.setCreateddatetime(new Timestamp(new Date().getTime()));
		bean.setModifieddatetime(new Timestamp(new Date().getTime()));
		bean.setId(1);

		CourseModel model = new CourseModel();
		model.Update(bean);
	}

	public static void testDelete() throws Exception {

		CourseModel model = new CourseModel();

		model.Delete(1);
	}

	public static void testfindbypk() throws Exception {

		CourseModel model = new CourseModel();
		
	    CourseBean bean = model.findbypk(1);
		
		System.out.print(bean.getId());
		System.out.print("\t" + bean.getName());
		System.out.print("\t" + bean.getDuration());
		System.out.print("\t" + bean.getDescription());
		System.out.print("\t" + bean.getCreatedby());
		System.out.print("\t" + bean.getModifiedby());
		System.out.print("\t" + bean.getCreateddatetime());
		System.out.println("\t" + bean.getModifieddatetime());
	}
	

	public static void testSearch() throws Exception {

		CourseBean bean = new CourseBean();
		
		CourseModel model = new CourseModel();
		
		List list = model.Search(null, 1, 5);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (CourseBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getDuration());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedby());
			System.out.print("\t" + bean.getModifiedby());
			System.out.print("\t" + bean.getCreateddatetime());
			System.out.println("\t" + bean.getModifieddatetime());
		
		}
	}
}




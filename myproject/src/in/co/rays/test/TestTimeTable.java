package in.co.rays.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.TimeTableBean;
import in.co.rays.model.TimeTableModel;


public class TestTimeTable {

	public static void main(String[] args) throws Exception {

		// testnextpk();
		   testAdd();
		// testUpdate();
		// testDelete();
		// testfindbypk();
		//testSearch();
	}

	public static void testnextpk() throws Exception {

		TimeTableModel model = new TimeTableModel();

		int pk = model.nextpk();
		System.out.println("next primary key:" + pk);

	}

	public static void testAdd() throws Exception {

		TimeTableBean bean = new TimeTableBean();
     SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
 
		
		bean.setId(1);
		bean.setSemester("2nd");
		bean.setDescription("syllabus");
		bean.setExamdate(sdf.parse("15-06-2020"));
		bean.setExamtime("two hours");
		bean.setCourseid(101);
		bean.setCoursename("java");
		bean.setSubjectId(1);
		bean.setSubjectName("chemistry");
		bean.setCreatedby("jal");
		bean.setModifiedby("gagan");
		bean.setCreateddatetime(new Timestamp(new Date().getTime()));
		bean.setModifieddatetime(new Timestamp(new Date().getTime()));

		TimeTableModel model = new TimeTableModel();
		model.Add(bean);
	}

	public static void testUpdate() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		TimeTableBean bean = new TimeTableBean();

	    bean.setSemester("3rd");
		bean.setDescription("advance");
		bean.setExamdate(sdf.parse("16-06-2016"));
		bean.setExamtime("three hours");
		bean.setCourse_Id(102);
		bean.setCourseName("advance java");
		bean.setDescription("python");
		bean.setCreatedby("agni");
		bean.setModifiedby("gagan");
		bean.setCreateddatetime(new Timestamp(new Date().getTime()));
		bean.setModifieddatetime(new Timestamp(new Date().getTime()));
		bean.setId(1);

		TimeTableModel model = new TimeTableModel();
		model.Update(bean);
	}

	public static void testDelete() throws Exception {
		
		TimeTableModel model = new TimeTableModel();

		model.Delete(1);
	}

	public static void testfindbypk() throws Exception {

		TimeTableModel model = new TimeTableModel();
	    TimeTableBean bean = model.findbypk(1);
		
		System.out.print(bean.getId());
		System.out.print("\t" + bean.getSemester());
		System.out.print("\t" + bean.getDescription());
		System.out.print("\t" + bean.getExamdate());
		System.out.print("\t" + bean.getExamtime());
		System.out.print("\t" + bean.getCourse_Id());
		System.out.print("\t" + bean.getCoursename());
		System.out.print("\t" + bean.getCreatedby());
		System.out.print("\t" + bean.getModifiedby());
		System.out.print("\t" + bean.getCreateddatetime());
		System.out.println("\t" + bean.getModifieddatetime());
	}
	

	public static void testSearch() throws Exception {

		TimeTableBean bean = new TimeTableBean();
		
		TimeTableModel model = new TimeTableModel();
		List list = model.Search(null, 1, 5);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (TimeTableBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getSemester());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getExamdate());
			System.out.print("\t" + bean.getExamtime());
			System.out.print("\t" + bean.getCourse_Id());
			System.out.print("\t" + bean.getCoursename());
			System.out.print("\t" + bean.getCreatedby());
			System.out.print("\t" + bean.getModifiedby());
			System.out.print("\t" + bean.getCreateddatetime());
			System.out.println("\t" + bean.getModifieddatetime());

			}
	}
}





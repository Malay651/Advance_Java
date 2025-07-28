package in.co.rays.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

public class TestUser {
	public static void main(String[] args) throws Exception {

		// testnextpk();
//	testadd();
		// testUpdate();
//  testDelete();
		// testfindbypk();
		// testfindbyfirst_name();
		// testSearch();
		
		testauth();
	}

	private static void testauth() {
		// TODO Auto-generated method stub
		
	}

	public static void testnextpk() throws Exception {
		UserModel model = new UserModel();

		int pk = model.nextPk();

		System.out.println("next primary key:" + pk);
	}

	public static void testadd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		UserBean bean = new UserBean();

		bean.setFirstName("rohan");
		bean.setLastName("singh");
		bean.setLogin_id("rohan@.com");
		bean.setPassword("123");
		bean.setDob(sdf.parse("22-11-2016"));
		bean.setMobile_No("9479562853");
		bean.setRole_id("2");
		bean.setGender("male");
		bean.setCreatedby("ajay");
		bean.setModifiedby("malay");
		bean.setCreateddatetime(new Timestamp(new Date().getTime()));
		bean.setModifieddatetime(new Timestamp(new Date().getTime()));

		UserModel model = new UserModel();
		model.add(bean);
	}

	public static void testUpdate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		UserBean bean = new UserBean();

		bean.setFirstName("ram");
		bean.setLastName("pratap");
		bean.setLogin_id("rohan@.com");
		bean.setPassword("123");
		bean.setDob(sdf.parse("25-05-2002"));
		bean.setMobile_No("9479562853");
		bean.setRole_id("4");
		bean.setCreatedby("akshat");
		bean.setModifiedby("gagan");
		bean.setCreateddatetime(new Timestamp(new Date().getTime()));
		bean.setModifieddatetime(new Timestamp(new Date().getTime()));
		bean.setId(1);

		UserModel model = new UserModel();

		model.update(bean);
	}

	public static void testDelete() throws Exception {

		UserModel model = new UserModel();

		model.delete(1);

	}

	public static void testfindbypk() throws Exception {

		UserModel model = new UserModel();

		UserBean bean = model.findbypk(1);

		System.out.print(bean.getId());
		System.out.print("\t" + bean.getFirstName());
		System.out.print("\t" + bean.getLastName());
		System.out.print("\t" + bean.getLogin_id());
		System.out.print("\t" + bean.getPassword());
		System.out.print("\t" + bean.getMobile_No());
		System.out.print("\t" + bean.getRole_id());
		System.out.print("\t" + bean.getGender());
		System.out.print("\t" + bean.getCreatedby());
		System.out.print("\t" + bean.getModifiedby());
		System.out.print("\t" + bean.getCreateddatetime());
		System.out.println("\t" + bean.getModifieddatetime());

	}

	public static void testfindbyfirst_name() throws Exception {

		UserModel model = new UserModel();

		UserBean bean = model.findbyfirst_name("ram");

		System.out.print(bean.getId());
		System.out.print("\t" + bean.getFirstName());
		System.out.print("\t" + bean.getLastName());
		System.out.print("\t" + bean.getLogin_id());
		System.out.print("\t" + bean.getPassword());
		System.out.print("\t" + bean.getMobile_No());
		System.out.print("\t" + bean.getRole_id());
		System.out.print("\t" + bean.getGender());
		System.out.print("\t" + bean.getCreatedby());
		System.out.print("\t" + bean.getModifiedby());
		System.out.print("\t" + bean.getCreateddatetime());
		System.out.println("\t" + bean.getModifieddatetime());

	}

	public static void testSearch() throws Exception {
		UserBean bean = new UserBean();

		UserModel model = new UserModel();

		List list = model.Search(null, 1, 1);
		bean.setFirstName("rahul");

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (UserBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLogin_id());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getMobile_No());
			System.out.print("\t" + bean.getRole_id());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getCreatedby());
			System.out.print("\t" + bean.getModifiedby());
			System.out.print("\t" + bean.getCreateddatetime());
			System.out.println("\t" + bean.getModifieddatetime());

		}
	}
}

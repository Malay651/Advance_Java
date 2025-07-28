package in.com.rays.user;

import java.text.SimpleDateFormat;

public class TestUserModel {
	
	public static void main(String[] args) throws Exception {
		
		//testnextpk();
		testadd();
		//testUpdate();
		testDelete();
	}
    
	public static void testnextpk() throws Exception {
		
		UserModel model = new UserModel();
		
		int pk = model.nextpk();
		 
		System.out.println("next primary key:" + pk);
	}
	
	public static void testadd() throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		UserBean bean = new UserBean();
		
		bean.setFirstName("rohan");
		bean.setLastName ("joshi");
		bean.setLoginId("rohan@gmail.com");
		bean.setPassword("123");
		bean.setDob(sdf.parse("18-05-2000"));
		bean.setAddress("indore");
		
		UserModel model = new UserModel();
		model.add(bean);
	}
	
	public static void testUpdate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		UserBean bean = new UserBean();

		bean.setId(2);
		bean.setFirstName("Akshat");
		bean.setLastName("Saxena");
		bean.setLoginId("akshat@gmail.com");
		bean.setPassword("123");
		bean.setDob(sdf.parse("26-12-2000"));
		bean.setAddress("Indore");

		UserModel model = new UserModel();

		model.update(bean);
	}

	public static void testDelete() throws Exception {

		UserModel model = new UserModel();

		model.delete(1);
	}

	public static void testFindByPk() throws Exception {

		UserModel model = new UserModel();

		UserBean bean = model.findByPk(2);

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.println("\t" + bean.getAddress());
		} else {
			System.out.println("user id not found");
		}
	}

	public static void testFindByLoginId() throws Exception {

		UserModel model = new UserModel();

		UserBean bean = model.findByLoginId("aakshat@gmail.com");

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.println("\t" + bean.getAddress());
		} else {
			System.out.println("Login Id does not exist");
		}
	}
}


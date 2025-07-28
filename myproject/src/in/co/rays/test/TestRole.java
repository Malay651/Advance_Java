package in.co.rays.test;

import java.sql.Timestamp;

import java.util.Date;

import in.co.rays.bean.RoleBean;
import in.co.rays.model.RoleModel;

public class TestRole {
	public static void main(String[] args) throws Exception {

		testAdd();
		//testUpdate();
       // testDelete();
       // testfindbypk();
       // testfindbyname();
       // testSearch();
	}
	
	public static void testAdd() throws Exception {
		RoleBean bean = new RoleBean();
		
     	bean.setId(1);
		bean.setName("ram");
		bean.setDescription("hr");
		bean.setCreatedby("rohan");
		bean.setModifiedby("sejal");
		bean.setCreateddatetime(new Timestamp(new Date().getTime()));
        bean.setModifieddatetime(new Timestamp (new Date().getTime()));
        
	 RoleModel model = new RoleModel();
		model.add(bean);
	}

	public static void testUpdate() throws Exception {

	RoleBean bean = new RoleBean();
	bean.setId(1);
	bean.setName("ram");
	bean.setDescription("hr");
	bean.setCreatedby("akshat");
	bean.setModifiedby("rohan");
	bean.setCreateddatetime(new Timestamp(new Date().getTime()));
    bean.setModifieddatetime(new Timestamp (new Date().getTime()));
    
    RoleModel model = new RoleModel();

	model.update(bean);
}
	
	public static void testDelete() throws Exception {

		RoleModel model = new RoleModel();

		model.delete(8);

	}

	public static void testfindbypk() throws Exception {

    RoleModel model = new RoleModel();

		model.findbypk(8);
	}

	public static void testfindbyname() throws Exception {

		RoleModel model = new RoleModel();

		model.findbyname("shiv");
	}

	public static void testSearch() throws Exception {

		RoleBean bean = new RoleBean();

		bean.setId(8);
		bean.setName("shiv");
		bean.getDescription();
		bean.getCreatedby();
		bean.getModifiedby();
        bean.getCreateddatetime();
        bean.getModifieddatetime();
		RoleModel model = new RoleModel();
		model.Search(bean,8,0);
	}
}
	


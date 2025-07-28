package in.co.rays.bean;

import java.util.Date;
import java.sql.Timestamp;

public class FacultyBean extends BaseBean{
	
	private String firstName;
	private String lastName;
	private Date dob;
	private String gender;
	private String mobile_No;
	private String email;
	private int college_Id;
	private String college_Name;
	private int student_Id;
	private String student_Name;
	
	public String getfirstName() {
		return firstName;
	}
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getlastName() {
		return lastName;
	}
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobile_No() {
		return mobile_No;
	}
	public void setMobile_No(String mobile_No) {
		this.mobile_No = mobile_No;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCollege_Id() {
		return college_Id;
	}
	public void setCollege_Id(int college_Id) {
		this.college_Id = college_Id;
	}
	public String getCollege_Name() {
		return college_Name;
	}
	public void setCollege_Name(String college_Name) {
		this.college_Name = college_Name;
	}
	public int getStudent_Id() {
		return student_Id;
	}
	public void setStudent_Id(int student_Id) {
		this.student_Id = student_Id;
	}
	public String getStudent_Name() {
		return student_Name;
	}
	public void setStudent_Name(String student_Name) {
		this.student_Name = student_Name;
	}
	
}
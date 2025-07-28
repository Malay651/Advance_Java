package in.co.rays.bean;

import java.util.Date;

public class TimeTableBean extends BaseBean  {
	
	private String Semester;
	private String Description;
	private Date examdate;
	private String examtime;
	private int course_id;
	private String course_name;
	private int courseid;
	private String coursename;
	
	public String getSemester() {
		return Semester;
	}
	public void setSemester(String semester) {
		Semester = semester;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Date getExamdate() {
		return examdate;
	}
	public void setExamdate(Date examdate) {
		this.examdate = examdate;
	}
	public String getExamtime() {
		return examtime;
	}
	public void setExamtime(String examtime) {
		this.examtime = examtime;
	}
	public int getCourse_Id() {
		return courseid;
	}
	public void setCourseid(int course_Id) {
		this.courseid = courseid;
	}
	public String getCourseName() {
		return coursename;
	}
	public void setCourseName(String courseName) {
		this.coursename = courseName;
	}
	public int getCourseid() {
		return courseid;
	}
	public void setCourse_Id(int courseid) {
		this.courseid = course_id;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
}
	
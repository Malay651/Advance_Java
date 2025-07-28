package in.co.rays.bean;

import java.util.Date;

public class TimeTableBean extends BaseBean  {
	
	private String Semester;
	private String Description;
	private Date examdate;
	private String examtime;
	private int course_id;
	private String course_name;
	private int subjectId;
	private String subjectName;
	
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
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
		return course_id;
	}
	public void setCourseid(int course_Id) {
		this.course_id = course_id;
	}
	public String getCourseName() {
		return course_name;
	}
	public void setCourseName(String courseName) {
		this.course_name = courseName;
	}
	public int getCourseid() {
		return course_id;
	}
	public void setCourse_Id(int courseid) {
		this.course_id = course_id;
	}
	public String getCoursename() {
		return course_name;
	}
	public void setCoursename(String coursename) {
		this.course_name = coursename;
	}
}
	
package org.restapi.development.messanger.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.restapi.development.messanger.model.Course;
import org.restapi.development.messanger.model.Message;
import org.restapi.development.messanger.model.Profile;

public class DatabaseClass {
	
	private static Map<String , Profile> profiles = new HashMap<>();
	private static Map<Long, Message> messages = new HashMap<>();
	public static Map<Long, Message> getMessages(){
		return messages;
	}
	
	public static Map<String, Profile> getProfiles(){
		return profiles;
	}
	
	public static ArrayList<Course> getCourses() throws Exception{
		String user = "root";
		String password = "adminroot";
		ArrayList<Course> courseList = new ArrayList<Course>();
		String url = "jdbc:mysql://localhost:3306/student";
		String Query="select * from course";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
		ResultSet set = stmt.executeQuery(Query);
		while(set.next()){
			Course course = new Course();
			course.setCourseId(set.getString("CourseId"));
			course.setCourseName(set.getString("courseName"));
			course.setDuration(set.getString("Duration"));
			course.setMode(set.getString("mode"));
			course.setStatus(set.getString("status"));
			courseList.add(course);
		}
		con.close();
		return courseList;
		
	}
	
	public static ArrayList<Course> getCourse(String id) throws Exception{
		String user = "root";
		String password = "adminroot";
		ArrayList<Course> courseList = new ArrayList<Course>();
		String url = "jdbc:mysql://localhost:3306/student";
		String Query="select * from course where courseId="+id;

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
		ResultSet set = stmt.executeQuery(Query);
		while(set.next()){
			Course course = new Course();
			course.setCourseId(set.getString("CourseId"));
			course.setCourseName(set.getString("courseName"));
			course.setDuration(set.getString("Duration"));
			course.setMode(set.getString("mode"));
			course.setStatus(set.getString("status"));
			courseList.add(course);
		}
		con.close();
		return courseList;
	}
	
    public static String deleteCourse(String id) throws Exception{

		int status = 0;
		String message="";
		String user = "root";
		String password = "adminroot";
		String url = "jdbc:mysql://localhost:3306/student";
		String sql = "DELETE FROM course WHERE courseId ="+id;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
		status= stmt.executeUpdate(sql);
		if(status>0) {
			message="Delete Operation successfull COURSE_ID : "+id;
		}else {
			message="Cannot perform Delete Operation COURSE_ID : "+id;
		}
		con.close();	
		return message;
    }

    public static String addCourse(Course c) throws Exception {
    	String msg="";
		String user = "root";
		String password = "adminroot";
		String url = "jdbc:mysql://localhost:3306/student";
		String sql = "INSERT into course (courseId,courseName,Duration,mode,status) values(?,?,?,?,?)";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,user,password);
		PreparedStatement pStmt = con.prepareStatement(sql);
		pStmt.setString(1,c.getCourseId());
		pStmt.setString(2,c.getCourseName());  
		pStmt.setString(3,c.getDuration());  
		pStmt.setString(4,c.getMode());  
		pStmt.setString(5,c.getStatus());  
		int status= pStmt.executeUpdate();
		con.close();	
		if(status>0) {
			msg="Record Inserted successfully ";
		}else {
			msg="Record NOT Inserted ";
		}
		return msg;
    }
    
    public static String modifyCourse(String id,Course c) throws Exception {
    	String msg="";
		String user = "root";
		String password = "adminroot";
		String url = "jdbc:mysql://localhost:3306/student";
		//String sql = "INSERT into course (courseId,courseName,Duration,mode,status) values(?,?,?,?,?)";
		String sql = "UPDATE course SET courseName=?,Duration=?,mode=?,status=? where courseId="+id;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,user,password);
		PreparedStatement pStmt = con.prepareStatement(sql);
		pStmt.setString(1,c.getCourseName());  
		pStmt.setString(2,c.getDuration());  
		pStmt.setString(3,c.getMode());  
		pStmt.setString(4,c.getStatus());  
		int status= pStmt.executeUpdate();
		con.close();	
		if(status>0) {
			msg="Record Updated successfully Id "+id;
		}else {
			msg="Record NOT Updated for Id : "+id;
		}
		return msg;
    }

}

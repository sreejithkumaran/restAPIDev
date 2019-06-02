package org.restapi.development.messanger.database;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.restapi.development.messanger.model.Course;

public class SQLiteJDBCDriverConnection{
	/**
	 * Connect to a sample database
	 */
	private Connection connect() {
		// SQLite connection string
		String url = "jdbc:sqlite:H://SQLite/DB/Student.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("Connection to SQLite has been established.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Connection to SQLite NOT established.");
		}

		return conn;
	}	

	/**
	 * Get Data
	 */
	public ArrayList<Course> getCourses(){

		ArrayList<Course> courseList = new ArrayList<Course>();
		String sql = "SELECT CourseId, CourseName, Duration, Mode,Status FROM Course";

		try {
			Connection conn = this.connect();
			Statement stmt  = conn.createStatement();
			ResultSet rs    = stmt.executeQuery(sql);

			Course course = new Course();
			// loop through the result set
			while (rs.next()) {
				course.setCourseId(rs.getString("CourseId"));
				course.setCourseName(rs.getString("courseName"));
				course.setDuration(rs.getString("Duration"));
				course.setMode(rs.getString("mode"));
				course.setStatus(rs.getString("status"));
				courseList.add(course);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return courseList;
	}

	public ArrayList<Course> getCourse(String Id){

		ArrayList<Course> courseList = new ArrayList<Course>();
		String sql = "select * from Course where courseId="+Id;

		try {
			Connection conn = this.connect();
			Statement stmt  = conn.createStatement();
			ResultSet rs    = stmt.executeQuery(sql);

			Course course = new Course();
			// loop through the result set
			while (rs.next()) {
				course.setCourseId(rs.getString("CourseId"));
				course.setCourseName(rs.getString("courseName"));
				course.setDuration(rs.getString("Duration"));
				course.setMode(rs.getString("mode"));
				course.setStatus(rs.getString("status"));
				courseList.add(course);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return courseList;
	}

	public String addCourse(Course c) throws Exception {
		String msg="";
		String sql = "INSERT INTO course(CourseId,CourseName,Duration,Mode,Status) VALUES(?,?,?,?,?)";

		try {
			Connection conn = this.connect();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getCourseId());
			pstmt.setString(2, c.getCourseName());
			pstmt.setString(3, c.getDuration());
			pstmt.setString(4, c.getMode());
			pstmt.setString(5, c.getStatus());
			pstmt.executeUpdate();
			msg="Records successfully Inserted :"+c.getCourseId()+"|"+c.getCourseName()+"|"+c.getDuration()
			+"|"+c.getMode()+"|"+c.getStatus();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			msg="ERROR :: Records NOT INSERTED ..";
		}
		return msg;
	}

	public String updateCourse(String id,Course c) throws Exception {
		//http://www.sqlitetutorial.net/sqlite-java/update/
		String msg="";
		int status=0;
		String sql = "UPDATE course SET CourseName=?,Duration=?,Mode=?,Status=? where CourseId=";
		Connection conn = this.connect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(2, c.getCourseName());
			pstmt.setString(3, c.getDuration());
			pstmt.setString(4, c.getMode());
			pstmt.setString(5, c.getStatus());
			pstmt.setString(1, c.getCourseId());
			status = pstmt.executeUpdate(); 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			conn.close();
			System.out.println("Connection Closed..");
		}
		if(status>0) {
			msg="Record Updated successfully Id "+id;
		}else {
			msg="Record NOT Updated for Id : "+id;
		}
		return msg;
	}
	
	public String deleteCourse(String id) throws Exception {
		String msg="";
		int status=0;
		String sql = "DELETE From course where CourseId=?";
		Connection conn = this.connect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			status = pstmt.executeUpdate(); 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			conn.close();
			System.out.println("Connection Closed..");
		}
		if(status>0) {
			msg="Record Deleted successfully Id "+id;
		}else {
			msg="Record NOT Deleted for Id : "+id;
		}
		return msg;
	}
}

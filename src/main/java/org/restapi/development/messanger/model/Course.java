package org.restapi.development.messanger.model;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Course {
	
		private String courseId;
		private String courseName;
		private String duration;
		private String mode;
		private String status;

		public Course() {

		}

		public Course(String courseId, String courseName, String Duration, String mode, String status) {
			super();
			this.courseId = courseId;
			this.courseName = courseName;
			this.duration = Duration;
			this.mode = mode;
			this.status = status;
		}
		
		public String getCourseId() {
			return courseId;
		}

		public void setCourseId(String CourseId) {
			courseId = CourseId;
		}

		public String getCourseName() {
			return courseName;
		}

		public void setCourseName(String CourseName) {
			courseName = CourseName;
		}

		public String getDuration() {
			return duration;
		}

		public void setDuration(String Duration) {
			duration = Duration;
		}

		public String getMode() {
			return mode;
		}
		
		public void setMode(String Mode) {
			mode = Mode;
		}
		
		public String getStatus() {
			return status;
		}

		public void setStatus(String Status) {
			status = Status;
		}

}

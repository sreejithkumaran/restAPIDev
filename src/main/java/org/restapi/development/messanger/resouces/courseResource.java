package org.restapi.development.messanger.resouces;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.restapi.development.messanger.database.DatabaseClass;
import org.restapi.development.messanger.model.Course;

@Path("/courses")
public class courseResource {

	@GET
//	@Produces(MediaType.APPLICATION_XML) 
	@Produces(MediaType.APPLICATION_JSON) 
	public ArrayList<Course> getCourses() throws Exception { 
		return DatabaseClass.getCourses();
	}

	@GET
	@Path("/{courseId}")
//	@Produces(MediaType.APPLICATION_XML)  
	@Produces(MediaType.APPLICATION_JSON) 
	public ArrayList<Course> getCourse(@PathParam("courseId") String id) throws Exception{ 
		return DatabaseClass.getCourse(id);

	}

	@POST
//	@Produces(MediaType.APPLICATION_XML)
//	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON) 
	@Consumes(MediaType.APPLICATION_JSON) 
	public String addCourse(Course c) throws Exception { 
		return 	DatabaseClass.addCourse(c);
	}

	@PUT
	@Path("/{courseId}")
//	@Consumes(MediaType.APPLICATION_XML)
//	@Produces(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON) 
	@Consumes(MediaType.APPLICATION_JSON) 
	public String updateCourse(@PathParam("courseId") String id,Course c) throws Exception {
		return DatabaseClass.modifyCourse(id, c);
	}

	@DELETE
	@Path("/{courseId}")
	@Consumes(MediaType.APPLICATION_XML)
	public String deleteCourse(@PathParam("courseId") String id) throws Exception {
		return DatabaseClass.deleteCourse(id);
	}

}

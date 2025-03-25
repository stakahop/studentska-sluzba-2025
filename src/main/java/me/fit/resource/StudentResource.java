package me.fit.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.model.Student;
import me.fit.repository.StudentService;

@Path("/student/")
public class StudentResource {

	@Inject
	private StudentService studentService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addStudent")
	public Response createStudent(Student student) {
		Student s = studentService.createStudent(student);
		return Response.ok().entity(s).build();
	}
}
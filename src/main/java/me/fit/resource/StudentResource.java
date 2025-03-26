package me.fit.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.model.Student;
import me.fit.repository.StudentRepository;

@Path("/student/")
public class StudentResource {

	@Inject
	private StudentRepository studentRepository;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addStudent")
	public Response createStudent(Student student) {
		Student s = studentRepository.createStudent(student);
		return Response.ok().entity(s).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getAllStudents")
	public Response getAllStudents () {
		List<Student> students = studentRepository.getAllStudents();
		
		return Response.ok().entity(students).build();
	}
}
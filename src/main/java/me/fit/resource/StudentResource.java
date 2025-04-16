package me.fit.resource;

import java.util.List;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.quarkus.scheduler.Scheduled;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.exception.StudentException;
import me.fit.model.Student;
import me.fit.model.client.TimeResponse;
import me.fit.repository.StudentRepository;
import me.fit.restclient.TimeClient;

@Path("/student/")
public class StudentResource {

	@Inject
	private StudentRepository studentRepository;
	
	@RestClient
	private TimeClient timeClient;
	
	@ConfigProperty(name = "greeting.message") 
	String message;

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
	public Response getAllStudents() {
		List<Student> students = studentRepository.getAllStudents();

		return Response.ok().entity(students).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getStudentsByName")
	public Response getStudentsByName(@QueryParam(value = "name") String name) {

		List<Student> students;
		try {
			students = studentRepository.getStudentsByName(name);
		} catch (StudentException e) {
			return Response.ok().entity(e.getMessage()).build();
		}

		return Response.ok().entity(students).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getTime")
	public Response getTime(@QueryParam(value = "timeZone") String timeZone) {

		TimeResponse time = timeClient.getTime(timeZone);

		return Response.ok().entity(time).build();
	}
}
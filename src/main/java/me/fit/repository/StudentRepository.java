package me.fit.repository;

import java.util.HashSet;
import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.fit.exception.StudentException;
import me.fit.model.Student;
import me.fit.model.Telefon;
import me.fit.model.client.StudentPredmet;

@Dependent
public class StudentRepository {

	@Inject
	private EntityManager em;
	
	

	@Transactional
	public Student createStudent(Student s) {
		return em.merge(s);
	}

	@Transactional
	public List<Student> getAllStudents() {
		List<Student> students = em.createNamedQuery(Student.GET_ALL_STUDENTS, Student.class).getResultList();

		for (Student student : students) {
			List<Telefon> telefoni = em.createNamedQuery(Telefon.GET_PHONES_FOR_STUDENT, Telefon.class)
					.setParameter("id", student.getId()).getResultList();

			student.setTelefoni(new HashSet<>(telefoni));
		}

		return students;
	}

	public List<Student> getStudentsByName(String name) throws StudentException{

		List<Student> students = em.createNamedQuery(Student.GET_STUDENTS_BY_NAME, Student.class)
				.setParameter("name", name).getResultList();
		
		if(students.size() == 0) {
			throw new StudentException("Ne postoje studenti");
		}
		
		return students;
	}
	
	@Transactional
	public StudentPredmet createStudentPredmet(StudentPredmet s) {
		return em.merge(s);
	}

}

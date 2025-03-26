package me.fit.repository;

import java.util.HashSet;
import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.fit.model.Student;
import me.fit.model.Telefon;

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

}

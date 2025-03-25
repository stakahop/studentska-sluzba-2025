package me.fit.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.fit.model.Student;

@Dependent
public class StudentService {

	@Inject
	private EntityManager em;

	@Transactional
	public Student createStudent(Student s) {
		return em.merge(s);
	}

	

}

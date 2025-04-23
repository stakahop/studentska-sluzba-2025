package me.fit.model.client;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import me.fit.model.Predmet;
import me.fit.model.Student;

@Entity
public class StudentPredmet {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentpredmet_seq")
	private Long id;

	@ManyToOne(cascade =  CascadeType.ALL)
	Student student;

	@ManyToOne(cascade =  CascadeType.ALL)
	Predmet predmet;

	public StudentPredmet() {
		super();
	}

	public StudentPredmet(Student student, Predmet predmet) {
		super();
		this.student = student;
		this.predmet = predmet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((predmet == null) ? 0 : predmet.hashCode());
		result = prime * result + ((student == null) ? 0 : student.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentPredmet other = (StudentPredmet) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (predmet == null) {
			if (other.predmet != null)
				return false;
		} else if (!predmet.equals(other.predmet))
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StudentPredmet [id=" + id + ", student=" + student + ", predmet=" + predmet + "]";
	}

}

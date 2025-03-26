package me.fit.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
@NamedQuery(name = Student.GET_ALL_STUDENTS, query = "Select s from Student s")
public class Student {

	public static final String GET_ALL_STUDENTS = "Student.getAllStudents";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
	private Long id;

	private String ime;

	private String prezime;

	private Date datumRodjenja;

	private String jmbg;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id")
	private Set<Telefon> telefoni;
	
	public Student() {
		super();
	}

	public Student(Long id, String ime, String prezime, Date datumRodjenja, String jmbg) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.jmbg = jmbg;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	
	public Set<Telefon> getTelefoni() {
		return telefoni;
	}

	public void setTelefoni(Set<Telefon> telefoni) {
		this.telefoni = telefoni;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datumRodjenja == null) ? 0 : datumRodjenja.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ime == null) ? 0 : ime.hashCode());
		result = prime * result + ((jmbg == null) ? 0 : jmbg.hashCode());
		result = prime * result + ((prezime == null) ? 0 : prezime.hashCode());
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
		Student other = (Student) obj;
		if (datumRodjenja == null) {
			if (other.datumRodjenja != null)
				return false;
		} else if (!datumRodjenja.equals(other.datumRodjenja))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ime == null) {
			if (other.ime != null)
				return false;
		} else if (!ime.equals(other.ime))
			return false;
		if (jmbg == null) {
			if (other.jmbg != null)
				return false;
		} else if (!jmbg.equals(other.jmbg))
			return false;
		if (prezime == null) {
			if (other.prezime != null)
				return false;
		} else if (!prezime.equals(other.prezime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", datumRodjenja=" + datumRodjenja
				+ ", jmbg=" + jmbg + "]";
	}

}

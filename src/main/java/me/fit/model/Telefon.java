package me.fit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery(name = Telefon.GET_PHONES_FOR_STUDENT, query = "Select t from Telefon t where t.student.id = :id")
public class Telefon {

	public static final String GET_PHONES_FOR_STUDENT = "Telefon.getPhonesForStudent";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "telefon_seq")
	private Long id;
	private String prefiks;
	private String broj;
	
	@ManyToOne
	private Student student;

	public Telefon() {
		super();
	}

	public Telefon(Long id, String prefiks, String broj) {
		super();
		this.id = id;
		this.prefiks = prefiks;
		this.broj = broj;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrefiks() {
		return prefiks;
	}

	public void setPrefiks(String prefiks) {
		this.prefiks = prefiks;
	}

	public String getBroj() {
		return broj;
	}

	public void setBroj(String broj) {
		this.broj = broj;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((broj == null) ? 0 : broj.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((prefiks == null) ? 0 : prefiks.hashCode());
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
		Telefon other = (Telefon) obj;
		if (broj == null) {
			if (other.broj != null)
				return false;
		} else if (!broj.equals(other.broj))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (prefiks == null) {
			if (other.prefiks != null)
				return false;
		} else if (!prefiks.equals(other.prefiks))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Telefon [id=" + id + ", prefiks=" + prefiks + ", broj=" + broj + "]";
	}

}

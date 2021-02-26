package com.calendar.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "abscence")
public class Absence {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "dateDepart")
	private LocalDate dateDepart;

	@Column(name = "dateRetour")
	private LocalDate dateRetour;

	@OneToOne
	@JoinColumn(name = "idPerson")
	private Person idPerson;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(LocalDate dateDepart) {
		this.dateDepart = dateDepart;
	}

	public LocalDate getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(LocalDate dateRetour) {
		this.dateRetour = dateRetour;
	}

	public Person getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(Person idPerson) {
		this.idPerson = idPerson;
	}

}

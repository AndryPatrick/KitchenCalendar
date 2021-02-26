package com.calendar.service.bean;

import java.time.LocalDate;

public class AbsenceBean extends PersonBean {

	private long idAbsence;
	private LocalDate dateDepart;
	private LocalDate dateRetour;

	public long getIdAbsence() {
		return idAbsence;
	}

	public void setIdAbsence(long idAbsence) {
		this.idAbsence = idAbsence;
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

}

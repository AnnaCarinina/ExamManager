package com.fstg.gestion.exams.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class Exam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String reference;
	private String dateDepart;
	private String dateFin;
	
	@OneToOne
	private Module module;
	@OneToOne
	private Professeur prof;
	
		
	@OneToMany(mappedBy="exam")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<ExamSalle> examSalles;
			
	@OneToMany(mappedBy="exam")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<ExamSurve> examSurveillants;
	

	



	public Exam() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(String dateDepart) {
		this.dateDepart = dateDepart;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}


	public Professeur getProf() {
		return prof;
	}

	public void setProf(Professeur prof) {
		this.prof = prof;
	}



	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}
	public List<ExamSalle> getExamSalles() {
		return examSalles;
	}
	public void setExamSalles(List<ExamSalle> examSalles) {
		this.examSalles = examSalles;
	}
	public List<ExamSurve> getExamSurveillants() {
		return examSurveillants;
	}
	public void setExamSurveillants(List<ExamSurve> examSurveillants) {
		this.examSurveillants = examSurveillants;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Exam other = (Exam) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	
	
}
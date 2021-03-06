package com.fstg.gestion.exams.model.service.facade;

import java.util.List;

import com.fstg.gestion.exams.beans.Departement;



public interface DepartementService {

	
	public Departement findById(Long id);
	public Departement findByLibelle(String libelle);
	public int deleteByLibelle(String libelle);
	public int save(Departement departement);
	public List<Departement> findAll();
	public Departement update(Long id,String libelle);
}

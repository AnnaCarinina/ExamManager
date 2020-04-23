package com.fstg.gestion.exams.model.service.facade;

import java.util.List;

import com.fstg.gestion.exams.beans.Etudiant;


public interface EtudiantService {

	public Etudiant findByCne(String cne);
	public int save(Etudiant etudiant);
	public List<Etudiant> findAll();
	public int deleteByCne(String cne);
	public List<Etudiant> findByFiliereLibelle(String libelle);
	public int deleteByFiliereLibelle(String libelle);
}

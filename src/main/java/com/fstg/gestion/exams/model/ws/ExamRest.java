package com.fstg.gestion.exams.model.ws;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fstg.gestion.exams.beans.Exam;
import com.fstg.gestion.exams.beans.Filiere;
import com.fstg.gestion.exams.beans.Module;
import com.fstg.gestion.exams.beans.Professeur;
import com.fstg.gestion.exams.model.service.facade.ExamService;
import com.fstg.gestion.exams.model.service.util.DateUtil;

@RestController
@RequestMapping("exam-api/exams")
@CrossOrigin(origins= {"http://localhost:4200" })
public class ExamRest  {

	
	@Autowired
	ExamService examService;

	@GetMapping("/find-by-reference/{reference}")
	public Exam findByReference(@PathVariable String reference) {
		return examService.findByReference(reference);
	}

	@DeleteMapping("/delete-by-id/{id}")
	public int deleteByid(@PathVariable Long id) {
		return examService.deleteById(id);
	}

	@GetMapping("/find-by-module/{reference}")
	public List<Exam> findByModuleLibelle(@PathVariable String reference) {
		return examService.findByModuleLibelle(reference);
	}

	@GetMapping("/find-all")
	public List<Exam> findAll() {
		return examService.findAll();
	}

	@GetMapping("/find-by-id/{id}")
	public Exam findById(@PathVariable Long id) {
		return examService.findById(id);
	}

	@PutMapping("/{id}/{reference}/{dateDepart}/{dateFin}/{module}/{prof}/{filiere}")
	public Exam update(@PathVariable Long id,@PathVariable String reference,@PathVariable Date dateDepart,@PathVariable Date dateFin, Module module,
			Professeur prof, Filiere filiere) {
		return update(id, reference , dateDepart, dateFin, module, prof, filiere);
	}
	@PostMapping("/save")
	public int save(@RequestBody Exam exam) {
		return examService.save(exam, exam.getExamSalles());
	}

	@GetMapping("/events/date-depart/{dateDepart}/date-fin/{dateFin}/module/{module}")
	public Exam findByDateDepartAndDateFinAndModuleLibelle(@PathVariable Date dateDepart,@PathVariable Date dateFin,@PathVariable String module) {
		return examService.findByDateDepartAndDateFinAndModuleLibelle(dateDepart, dateFin, module);
	}
	
	


	
}

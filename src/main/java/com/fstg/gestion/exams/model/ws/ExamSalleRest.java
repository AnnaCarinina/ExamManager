package com.fstg.gestion.exams.model.ws;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.fstg.gestion.exams.beans.ExamSalle;
import com.fstg.gestion.exams.model.service.facade.ExamSalleService;
import com.fstg.gestion.exams.model.service.util.DateUtil;


@RestController
@RequestMapping("exam-api/exams-salle")
@CrossOrigin(origins= {"http://localhost:4200" })
public class ExamSalleRest {

	@Autowired
	ExamSalleService examSalleService;

	@GetMapping("/salle/find-by-reference/{reference}")
	public List<ExamSalle> findBySalleDesignation(@PathVariable String designation) {
		return examSalleService.findBySalleDesignation(designation);
	}

	@GetMapping("/exam/find-by-reference/{reference}")
	public List<ExamSalle> findByExamReference(@PathVariable String reference) {
		return examSalleService.findByExamReference(reference);
	}

	@DeleteMapping("/exam/delete-by-id/{id}")
	public int deleteByExamId(@PathVariable Long id) {
		return examSalleService.deleteByExamId(id);
	}
	@DeleteMapping("/delete-by-designation/{designation}/delete-by-dateDepart/{dateDepart}/delete-by-dateFin/{dateFin}")
	public int deleteBySalleDesignationAndExamDateDepartAndExamDateFin(@PathVariable String designation,@PathVariable String dateDepart,@PathVariable String dateFin )  {
		return examSalleService.deleteBySalleDesignationAndExamDateDepartAndExamDateFin( designation,DateUtil.parse(dateDepart), DateUtil.parse(dateFin) ) ;
	}


	@GetMapping("/find-all")
	public List<ExamSalle> findAll() {
		return examSalleService.findAll();
	}

	@GetMapping("/find-by-id/{id}")
	public ExamSalle findById(@PathVariable Long id) {
		return examSalleService.findById(id);
	}
	/*@GetMapping("/designation/{designation}/dateDepart/{dateDepart}/dateFin/{dateFin}")
	public ExamSalle findBySalleDesignationAndExamDateDepartAndExamDateFin(@PathVariable String designation,@PathVariable Date dateDepart,@PathVariable
			Date dateFin) {
		return examSalleService.findBySalleDesignationAndExamDateDepartAndExamDateFin(designation, dateDepart,dateFin);
	}*/
	@GetMapping("/designation/{designation}/dateDepart/{dateDepart}/dateFin/{dateFin}")
	public List<ExamSalle> findExamSalle(@PathVariable String designation,@PathVariable String dateDepart,@PathVariable String dateFin) {
		System.out.println("dateDepart "+dateDepart);
		return examSalleService.findExamSalle(designation ,DateUtil.parse(dateDepart), DateUtil.parse(dateFin));
	}
	@DeleteMapping("/delete-by-id/{id}")
	public void deleteById(@PathVariable Long id) {
		examSalleService.deleteById(id);
	}
	@DeleteMapping("/salle/delete-by-id/{id}")
	public int deleteBySalleId(@PathVariable Long id) {
		return examSalleService.deleteBySalleId(id);
	}
}
package com.fstg.gestion.exams.model.ws;

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

import com.fstg.gestion.exams.beans.Surveillant;
import com.fstg.gestion.exams.model.service.facade.SurveillantService;
import com.fstg.gestion.exams.model.service.util.DateUtil;

@RestController
@RequestMapping("exam-api/surveillants")
@CrossOrigin(origins= {"http://localhost:4200" })
public class SurveillantRest {

	@Autowired
	SurveillantService surveillantService;

	@GetMapping("/find-by-nom/{nom}")
	public Surveillant findByNom(@PathVariable String nom) {
		return surveillantService.findByNom(nom);
	}

	@DeleteMapping("/delete-by-nom/{nom}")
	public int deleteByNom(@PathVariable String nom) {
		return surveillantService.deleteByNom(nom);
	}
	@GetMapping("/find-all")
	public List<Surveillant> findAll() {
	return surveillantService.findAll();
	}

	@PutMapping("/{id}/{nom}/{prenom}/{mail}")
	public Surveillant update(@PathVariable Long id,@PathVariable String nom,@PathVariable String prenom,@PathVariable String mail) {
		return surveillantService.update(id,nom, prenom, mail);
	}

	@GetMapping("/{designation}/{dateDepart}/{dateFin}")
	public List<Surveillant> findByExamSalleSalleDesignationAndExamSalleExamDateDepartAndExamSalleExamDateFin(
			@PathVariable String designation,@PathVariable String dateDepart,@PathVariable String dateFin) {
		return surveillantService.findByExamSalleSalleDesignationAndExamSalleExamDateDepartAndExamSalleExamDateFin(
				designation, DateUtil.parse(dateDepart), DateUtil.parse(dateFin));
	}

	@GetMapping("/find-by-exam/{exam}")
	public List<Surveillant> findByExam(@PathVariable Long exam) {
		return surveillantService.findByExam(exam);
	}
	
	@GetMapping("/nom/{nom}/dateDepart/{dateDepart}/dateFin/{dateFin}")
	public List<Surveillant> findSurveillant(@PathVariable String nom,@PathVariable String dateDepart,@PathVariable String dateFin) {
		return surveillantService.findSurveillant(nom, DateUtil.parse(dateDepart), DateUtil.parse(dateFin));
	}
	
	
}

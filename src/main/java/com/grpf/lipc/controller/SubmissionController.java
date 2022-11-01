package com.grpf.lipc.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grpf.lipc.entities.Submission;
import com.grpf.lipc.entities.User;
import com.grpf.lipc.exception.DataNotFoundException;
import com.grpf.lipc.service.MapValidationErrorService;
import com.grpf.lipc.service.SubmissionService;
import com.grpf.lipc.service.UserService;

@RestController
@RequestMapping("/submission")
@CrossOrigin(origins= "*")
public class SubmissionController {
	
	@Autowired
	private SubmissionService submissionService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@GetMapping("/{id}")
//	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Submission getByQuestionId(@PathVariable("id") int id) {
		return submissionService.findQuestionsById(id);
	}
	
	@GetMapping("/getAllSubmissonsByEmail/{email}")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Submission> getAllSubmissionsByEmail(@PathVariable("email") String email){
		return submissionService.findAllSubmissionsByUser(email);
	}
	
	@GetMapping("/getAllSubmission")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Submission> getAllUser(){
		return submissionService.findAllSubmission();
	}
	
	@GetMapping("/user/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Submission getByUserId(@PathVariable("id") int uId) {
		return submissionService.findQuestionByUser(uId);
	}
	
	@GetMapping("/findByEmail/{email}")
	public ResponseEntity<Submission> findByEmail(@PathVariable("email") String email){
		User u=userService.findUserByEmail(email);
		int uId=u.getUserId();
		Submission q=submissionService.findQuestionByUser(uId);
		return new ResponseEntity<Submission>(q,HttpStatus.OK);
	}
	
	@PostMapping("/addSubmisson/{email}")
	public ResponseEntity<Submission> addQuestions(@PathVariable("email") String email,@Valid @RequestBody Submission sub, BindingResult result){
		ResponseEntity<?> errorMap =  mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) return (ResponseEntity<Submission>) errorMap;
		User u=userService.findUserByEmail(email);
		
		sub.setUser(u);
		submissionService.addQuestions(sub);
		return new ResponseEntity<>(sub, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getCoverage/{email}")
	public ResponseEntity<String> getCoverage(@PathVariable("email") String email){
		User u=userService.findUserByEmail(email);
		int uId=u.getUserId();
		Submission q=submissionService.findQuestionByUser(uId);
		return new ResponseEntity<String>(String.valueOf(q.getCoverage()),HttpStatus.OK);
	}
	
	
	@GetMapping("/getDuration/{email}")
	public ResponseEntity<String> getDuration(@PathVariable("email") String email){
		User u=userService.findUserByEmail(email);
		int uId=u.getUserId();
		Submission q=submissionService.findQuestionByUser(uId);
		return new ResponseEntity<String>(String.valueOf(q.getYears()*12),HttpStatus.OK);
	}
	
	
	@GetMapping("/getQuote/{email}")
	public ResponseEntity<String> getQuote(@PathVariable("email") String email) throws DataNotFoundException{
		User u=userService.findUserByEmail(email);
		int uId=u.getUserId();
		Submission q=submissionService.findQuestionByUser(uId);
		
		
		
		//occupation Risk
		double ocRisk;

		
		//age risk
		LocalDate curDate = LocalDate.now();  
		LocalDate dob = q.getDOB();
		double age=(Period.between(dob, curDate).getYears())/100;
		double ageRisk=(Math.floor(age))*2;
		
		
		//hobbies risk
		double hobRisk;
//		hobRisk=(q.getRiskyHobby())/4.00;
		
		//Medical problems risk
		double medRisk;
//		medRisk=(q.getMedicalProblems())/4.00;
		
		
		//smoking risk
		double smokRisk;
		if(q.isSmoking()) {
			smokRisk=1.00;
		}
		else {
			smokRisk=0;
		}
		
		
		//drinking risk
		double drinkRisk;
		if(q.isDrinking()) {
			drinkRisk=1.00;
		}
		else {
			drinkRisk=0;
		}
		
		
//		double totalRisk=smokRisk+drinkRisk+hobRisk+medRisk+ocRisk+ageRisk;
//		int months=q.getYears()*12;
//		double premium=(0.5+(totalRisk/7))*(q.getCoverage()/months)/100;
		
		String ans="$ "+String.valueOf(1)+" / month";
		
		

		return new ResponseEntity<String>(ans,HttpStatus.OK);
	}

}

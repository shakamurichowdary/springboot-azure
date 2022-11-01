package com.grpf.lipc.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grpf.lipc.entities.Quote;
import com.grpf.lipc.entities.Submission;
import com.grpf.lipc.entities.User;
import com.grpf.lipc.exception.DataNotFoundException;
import com.grpf.lipc.service.BeneficiaryService;
import com.grpf.lipc.service.MapValidationErrorService;
import com.grpf.lipc.service.QuoteService;
import com.grpf.lipc.service.SubmissionService;
import com.grpf.lipc.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/quote")
@Transactional
public class QuoteController {
	@Autowired
	private UserService userService;
	
//	@Autowired
//	private BeneficiaryService beneficiaryService;
	
	@Autowired
	private SubmissionService submissionService;
	
	@Autowired
	private QuoteService quoteService;
	
	@PersistenceContext
	private EntityManager em;
	
	
	@GetMapping("/{email}")
	public ResponseEntity<Double> getQuote(@PathVariable("email") String email) throws DataNotFoundException{
		User u=userService.findUserByEmail(email);
		Submission sub=submissionService.findQuestionByUser(u.getUserId());
		return this.getQuote(sub);
		
	}
	
	
	
	
	
	
	
	public ResponseEntity<Double> getQuote(Submission sub) throws DataNotFoundException{
		HashMap<String,Double> map=new HashMap<>();
		map.put("smoking", 1.00);
		map.put("drinking", 1.00);
		map.put("racing", 0.05);
		map.put("skyDiving", 0.10);
		map.put("bungeeJumping", 0.15);
		map.put("scubaDiving", 0.1);
		map.put("hobOthers", 0.1);
		map.put("diabaties", 0.05);
		map.put("bloodPressure", 0.05);
		map.put("cancer", 0.1);
		map.put("brainTumor", 0.2);
		map.put("medOthers", 0.1);
		map.put("heartDisease", 0.05);
		map.put("highBloodPressure", 0.05);
		map.put("alzheimer", 0.1);
		map.put("arthritis", 0.2);
		map.put("herOthers", 0.1);
		
		
		double totalRisk=0;
		if(sub.isSmoking()) {
			totalRisk+=map.get("smoking");
		}
		if(sub.isDrinking()) {
			totalRisk+=map.get("drinking");
		}
		if(sub.getHobbies().isRacing()) {
			totalRisk+=map.get("racing");
		}
		if(sub.getHobbies().isSkyDiving()) {
			totalRisk+=map.get("skyDiving");
		}
		if(sub.getHobbies().isBungeeJumping()) {
			totalRisk+=map.get("bungeeJumping");
		}
		if(sub.getHobbies().isScubaDiving()) {
			totalRisk+=map.get("scubaDiving");
		}
		if(sub.getHobbies().isOthers()) {
			totalRisk+=map.get("hobOthers");
		}
		if(sub.getMedical().isBloodPressure()) {
			totalRisk+=map.get("bloodPressure");
		}
		if(sub.getMedical().isBrainTumor()) {
			totalRisk+=map.get("brainTumor");
		}
		if(sub.getMedical().isCancer()) {
			totalRisk+=map.get("cancer");
		}
		if(sub.getMedical().isDiabaties()) {
			totalRisk+=map.get("diabaties");
		}
		if(sub.getMedical().isOthers()) {
			totalRisk+=map.get("medOthers");
		}
		if(sub.getHereditaryDiseases().isAlzheimer()) {
			totalRisk+=map.get("alzheimer");
		}
		if(sub.getHereditaryDiseases().isArthritis()) {
			totalRisk+=map.get("arthritis");
		}
		if(sub.getHereditaryDiseases().isHeartDisease()) {
			totalRisk+=map.get("heartDisease");
		}
		if(sub.getHereditaryDiseases().isHighBloodPressure()) {
			totalRisk+=map.get("highBloodPressure");
		}
		if(sub.getHereditaryDiseases().isOthers()) {
			totalRisk+=map.get("herOthers");
		}
		if(sub.getOccupation().isBusiness()) {
			totalRisk+=0.1;
		}
		if(sub.getOccupation().isMilitary()) {
			totalRisk+=0.2;
		}
		if(sub.getOccupation().isPrivateSector()) {
			totalRisk+=0.05;
		}
		if(sub.getOccupation().isPublicSector()) {
			totalRisk+=0.05;
		}
		if(sub.getOccupation().isSports()) {
			totalRisk+=0.1;
		}
		
		
		
		
		
		LocalDate curDate = LocalDate.now();  
		LocalDate dob = sub.getDOB();
		double age=(Period.between(dob, curDate).getYears())/100;
		double ageRisk=age;
		totalRisk+=ageRisk;
		
		
		int months=sub.getYears()*12;
		double premium=(0.5+(totalRisk/5))*(sub.getCoverage()/months)/100;
		
		
		String ans="$ "+String.valueOf(premium).substring(0, 4)+" / month";
		
		
		
//		System.out.println(sub);	
		
		Quote q=new Quote();
		q.setQuoteAmount(premium);
		q.setCoverage(sub.getCoverage());
		q.setSubmission(sub);
		q.setYears(sub.getYears());
//		
//		quoteService.addQuote(q);
		
		
		sub.setQuote(q);
		em.merge(sub);
			
		
		
		
		return new ResponseEntity<Double>(premium,HttpStatus.OK);
		
		
		
	}
	
	
	
	

}

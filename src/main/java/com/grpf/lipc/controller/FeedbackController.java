package com.grpf.lipc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grpf.lipc.entities.Feedback;
import com.grpf.lipc.entities.User;

import com.grpf.lipc.service.FeedbackService;
import com.grpf.lipc.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/feedback")

public class FeedbackController {
	
	@Autowired
	private FeedbackService feedbackService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("{email}")
	public ResponseEntity<String> getQuote(@PathVariable("email") String email, @RequestBody Feedback feed) {
		User u=userService.findUserByEmail(email);
		feed.setUser(u);
		feedbackService.addfeedback(feed);
		return new ResponseEntity<String>("feedback Added",HttpStatus.OK);
		
	}
	

}

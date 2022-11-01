package com.grpf.lipc.service;

import java.util.List;

import org.jvnet.hk2.annotations.Service;

import com.grpf.lipc.entities.Feedback;


public interface FeedbackService {
	

	public void addfeedback(Feedback feed);
	
	public List<Feedback> findAllfeedback();
	
	public Feedback getByUserEmail(String email);

}

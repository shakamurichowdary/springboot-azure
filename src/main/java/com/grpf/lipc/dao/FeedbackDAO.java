package com.grpf.lipc.dao;

import java.util.List;

import com.grpf.lipc.entities.Feedback;

public interface FeedbackDAO {
	
	public void addfeedback(Feedback feed);
	
	public List<Feedback> findAllfeedback();
	
	public Feedback getByUserEmail(String email);
	
}
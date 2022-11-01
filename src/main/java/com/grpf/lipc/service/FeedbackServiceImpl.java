package com.grpf.lipc.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grpf.lipc.dao.FeedbackDAO;
import com.grpf.lipc.entities.Feedback;

@Service
@Transactional(readOnly=true)
public class FeedbackServiceImpl implements FeedbackService {
	
	
	@Autowired
	private FeedbackDAO dao;

	@Override
	@Transactional
	public void addfeedback(Feedback feed) {
		
		dao.addfeedback(feed);
		

	}

	@Override
	public List<Feedback> findAllfeedback() {
		return dao.findAllfeedback();
	}

	@Override
	public Feedback getByUserEmail(String email) {
		return dao.getByUserEmail(email);
	}

}

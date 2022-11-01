package com.grpf.lipc.service;



import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grpf.lipc.dao.SubmissionDAO;
import com.grpf.lipc.entities.Submission;

@Service
@Transactional(readOnly=true)
public class SubmissionServiceImpl implements SubmissionService {
	
	@Autowired
	private SubmissionDAO dao;

	@Override
	@Transactional
	public void addQuestions(Submission que) {
		
		dao.addQuestions(que);
		

	}

	@Override
	public Submission findQuestionsById(int qId) {
	
		
		return dao.findQuestionsById(qId);
		
		

	}

	@Override
	public Submission findQuestionByUser(int uId) {
		
		return dao.findQuestionByUser(uId);

	}

	@Override
	public List<Submission> findAllSubmission() {
		return dao.findAllSubmission();
	}

	@Override
	public List<Submission> findAllSubmissionsByUser(String email) {
		return dao.findAllSubmissionsByUser(email);
	}

}

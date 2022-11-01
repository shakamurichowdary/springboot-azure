package com.grpf.lipc.dao;

import java.util.List;

import com.grpf.lipc.entities.Submission;



public interface SubmissionDAO {
	
	
	
	public void addQuestions(Submission que);
	
	public Submission findQuestionsById(int qId);
	
	public Submission findQuestionByUser(int uId);
	
	public List<Submission> findAllSubmission();
	
	public List<Submission> findAllSubmissionsByUser(String email);
	
	
	

}

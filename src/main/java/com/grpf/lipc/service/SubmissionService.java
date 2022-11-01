package com.grpf.lipc.service;

import java.util.List;

import com.grpf.lipc.entities.Submission;

public interface SubmissionService {
	
	public void addQuestions(Submission que);
	
	public Submission findQuestionsById(int qId);
	
	public Submission findQuestionByUser(int uId);
	
	public List<Submission> findAllSubmission();
	
	public List<Submission> findAllSubmissionsByUser(String email);

	
}

package com.grpf.lipc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grpf.lipc.entities.Submission;
import com.grpf.lipc.entities.User;
import com.grpf.lipc.service.UserService;


@Repository
public class SubmissionDAOImpl implements SubmissionDAO {

	@PersistenceContext
	private EntityManager em;
	
	
	
	@Override
	public void addQuestions(Submission que) {
		em.persist(que);

	}

	@Override
	public Submission findQuestionsById(int qId) {
		Submission q=em.createQuery("SELECT q FROM Submission q where q.id= :id",Submission.class).setParameter("id", qId).getSingleResult();
		return q;
	}

	@Override
	public Submission findQuestionByUser(int uId) {
//		User u=userService.findUserById(uId);
		
		List<Submission> q=em.createQuery("SELECT q FROM Submission q where q.user.userId= :id",Submission.class).setParameter("id", uId).getResultList();
		return q.get(q.size()-1);
	}

	@Override
	public List<Submission> findAllSubmission() {
		
		List<Submission> q=em.createQuery("SELECT q FROM Submission q",Submission.class).getResultList();
		return q;
	}
	
	
	@Override
	public List<Submission> findAllSubmissionsByUser(String email) {
		List<Submission> sub=em.createQuery("SELECT s FROM Submission s where s.user.email= :email",Submission.class).setParameter("email", email).getResultList();
		return sub;
	}
	
	

}

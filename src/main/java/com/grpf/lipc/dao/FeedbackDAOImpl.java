package com.grpf.lipc.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grpf.lipc.entities.Feedback;
import com.grpf.lipc.service.UserService;


@Repository
public class FeedbackDAOImpl implements FeedbackDAO{
	
	@PersistenceContext
	private EntityManager em;
	

	@Override
	public void addfeedback(Feedback feed) {
		em.persist(feed);
	}

	@Override
	public List<Feedback> findAllfeedback() {
		List<Feedback> f=em.createQuery("SELECT f FROM Feedback f",Feedback.class).getResultList();
		return f;
	}


	@Override
	public Feedback getByUserEmail(String email) {
		Feedback feed=em.createQuery("SELECT f FROM Feedback f where f.user.email:email",Feedback.class).setParameter("email", email).getSingleResult();
		return feed;
	}
}
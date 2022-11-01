package com.grpf.lipc.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.grpf.lipc.entities.Quote;

@Repository
public class QuoteDAOImpl implements QuoteDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	

	@Override
	public void addQuote(Quote q) {
		em.persist(q);
	}

}

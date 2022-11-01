package com.grpf.lipc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grpf.lipc.dao.QuoteDAO;
import com.grpf.lipc.entities.Quote;

@Service
@Transactional(readOnly=true)
public class QuoteServiceImpl implements QuoteService {
	
	@Autowired
	private QuoteDAO dao;

	
	@Override
	@Transactional
	public void addQuote(Quote q) {
		dao.addQuote(q);

	}

}

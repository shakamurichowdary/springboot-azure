package com.grpf.lipc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grpf.lipc.dao.PersonDAO;
import com.grpf.lipc.entities.Person;

@Service
@Transactional(readOnly=true)
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonDAO dao;

	@Override
	@Transactional
	public Person addPerson(Person person) {
		dao.addPerson(person);
		return person;
	}

	@Override
	public Person findPersonById(int pId) {
		return dao.findPersonById(pId);
		
	}

	@Override
	public List<Person> findAllPerson() {
		return dao.findAllPerson();
	}

}

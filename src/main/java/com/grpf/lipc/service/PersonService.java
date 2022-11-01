package com.grpf.lipc.service;

import java.util.List;

import com.grpf.lipc.entities.Person;

public interface PersonService {
	
	public Person addPerson(Person person);
	
	public Person findPersonById(int pId);
	
	public List<Person> findAllPerson();

}

package com.grpf.lipc.dao;

import java.util.List;

import com.grpf.lipc.entities.Person;

public interface PersonDAO {
	
	public Person addPerson(Person person);
	
	public Person findPersonById(int pId);
	
	public List<Person> findAllPerson();
	

}

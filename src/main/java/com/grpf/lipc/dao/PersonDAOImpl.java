package com.grpf.lipc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.grpf.lipc.entities.Person;
@Repository

public class PersonDAOImpl implements PersonDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Person addPerson(Person person) {
		em.persist(person);
		return person;
	}

	@Override
	public Person findPersonById(int pId) {
		Person p=em.createQuery("SELECT p FROM Person p where p.perId= :pId",Person.class).setParameter("pId", pId).getSingleResult();
		return p;
	}

	@Override
	public List<Person> findAllPerson() {
		List<Person> p=em.createQuery("SELECT p FROM Person p",Person.class).getResultList();
		return p;
	}

}

package com.grpf.lipc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.grpf.lipc.entities.User;


@Repository  
public class UserDAOImpl implements UserDAO {
	

	@PersistenceContext
	private EntityManager em;
	


	public void addUser(User user) {
		
		em.persist(user);

	}

	public List<User> findAllUsers() {
		List<User> users=em.createQuery("select u from User u",User.class).getResultList();
		return users;
	}

	public User findUserById(int id) {
		User user=em.createQuery("SELECT u FROM User u where u.id= :id",User.class).setParameter("id", id).getSingleResult();
		
		return user;
	}

	public void deleteUser(User user) {
		em.remove(user);

	}

	public void updateUser(User user) {
		em.merge(user);
		
	}

	@Override
	public User findUserByEmail(String email) {
		User user=em.createQuery("select u from User u where u.email= :email",User.class).setParameter("email", email).getSingleResult();
		return user;
	}

}

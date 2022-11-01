package com.grpf.lipc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grpf.lipc.dao.UserDAO;
import com.grpf.lipc.entities.User;



@Service
@Transactional(readOnly=true)
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private UserDAO dao;


	@Override
	@Transactional
	public void addUser(User user) {
		dao.addUser(user);

	}

	@Override
	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}

	@Override
	public User findUserById(int id) {
		
		return dao.findUserById(id);
	}

	@Override
	@Transactional
	public void deleteUser(int id) {
		User u=findUserById(id);
		if(u==null) {
			throw new IllegalArgumentException("Id not found: "+id);
		}
		dao.deleteUser(u);

	}

	@Override
	@Transactional
	public void updateUser(User user) {
		User u=findUserById(user.getUserId());
		if(u==null) {
			throw new IllegalArgumentException("Id not found: "+user.getUserId());
		}
		u.setUserId(user.getUserId());
		
		

	}

	@Override
	public User findUserByEmail(String email) {
		return dao.findUserByEmail(email);
	}

}

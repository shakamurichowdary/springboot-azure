package com.grpf.lipc.dao;

import java.util.List;

import com.grpf.lipc.entities.User;


public interface UserDAO {
	
	public void addUser(User user);
	
	public List<User> findAllUsers();
	
	public User findUserById(int id);
	
	public void deleteUser(User user);
	
	public void updateUser(User user);
	
	public User findUserByEmail(String email);
	
	
	
	

}

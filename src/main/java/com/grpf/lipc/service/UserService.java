package com.grpf.lipc.service;

import java.util.List;

import com.grpf.lipc.entities.User;



public interface UserService {
	
	public void addUser(User user);
	public List<User> findAllUsers();
	public User findUserById(int id);
	public void deleteUser(int id);
	public void updateUser(User user);
	public User findUserByEmail(String email);


}

package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDAO;
import com.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDAO dao;
	ArrayList<User> al = new ArrayList<User>();
	public boolean userLogin(User user) {
		if(user.getUname().equals("admin") && user.getPass().equals("pass123")) {
			return true;
		}
		return false;
	}
	
	public boolean addUser(User user) {
		dao.save(user);
		System.out.println(al);
		return true;
	}
	
	public List<User> loadallUsers() {
		return al;
	}
	
	public boolean findUser(String name) {
		for(User user: al) {
			if(user.getUname().equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean removeUser(String name) {
		for(User user: al) {
			if(user.getUname().equals(name)) {
				al.remove(user);
				return true;
			}
		}
		return false;
	}
	
	public void updateUser(String name, User user) {
		for(User u: al) {
			if(u.getUname().equals(name)) {
				al.set(al.indexOf(u), user);
			}
		}
	}
}
package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.service.UserService;

@RestController
@RequestMapping("/mainapp")
public class AppController {
	
	@Autowired
	UserService service;
	ArrayList<User> al = new ArrayList<User>();
	
	@PostMapping("/login")
	public String loginVal(@ModelAttribute User user) {
		if(service.userLogin(user)) {
			return "login successfully!";
		}
		return "login fail";
	}
	
	@PostMapping("/register")
	public String regUser(@ModelAttribute User user) {
		service.addUser(user);
		return "user registered";
	}
	
	@GetMapping("/loadall")
	public List<User> loadAll(){
	 return service.loadallUsers();	
		
	}
	
	@GetMapping("/finduser/{uname}")
	public String findUser(@PathVariable("uname") String uname) {
	   if(service.findUser(uname)) {
		   return "user "+ uname+ "found";
	   }
		return "user "+ uname+ "not found";
	}
	
	@DeleteMapping("/deleteuser/{uname}")
	public String deleteUser(@PathVariable("uname") String uname) {
	   if(service.findUser(uname)) {
		   return "user "+ uname+ "found and deleted";
	   }
		return "user "+ uname+ "not found";
	}
	
	@PutMapping("/putuser/{uname}")
	public void putUser(@PathVariable("uname") String uname, @RequestBody User user) {
	   service.updateUser(uname, user);
	}
}

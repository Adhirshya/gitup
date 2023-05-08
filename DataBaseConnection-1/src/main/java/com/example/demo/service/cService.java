package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repo.cRepo;
import com.example.demo.day6.cModel;

@Service
public class cService 
{
	@Autowired
	private cRepo repo;
	
	public String checkLogin(String username, String password) {
	    cModel user = repo.findByusername(username);
	    if (user == null) {
	      return "no user found";
	    }
	    else{
	    	if(user.getPassword().equals(password)) {	    		
	    		return"Login Succesfull"; 
	    	}
	    	else {
	    		return "Login Failed";
	    	}
	    }
	}
	public cModel addUser(cModel car) 
	{
		return repo.save(car);
	}
	public List<cModel> getUser()
	{
		return repo.findAll();
	}


}

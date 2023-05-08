package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.loginModel;
import com.example.demo.Repository.loginRepo;

@Service
public class loginService 
{
	@Autowired
	private loginRepo repo;
	
	public String checkLogin(String username, String password) 
	{
	    loginModel user = repo.findByusername(username);
	    if (user == null)
	    {
	      return "no user found";
	    }
	    else{
	    	if(user.getPassword().equals(password)) 
	    	{	    		
	    		return"Login Succesfull"; 
	    	}
	    	else 
	    	{
	    		return "Login Failed";
	    	}
	    }
	}
	public loginModel addUser(loginModel rail) 
	{
		return repo.save(rail);
	}
	public List<loginModel> getUser()
	{
		return repo.findAll();
	}

}

package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.day6.cModel;
import com.example.demo.service.cService;

@RestController
@RequestMapping("/cars")
public class cController 
{
	@Autowired
	private cService serv;
	
	 @PostMapping("/login")
	  public String login(@RequestBody Map<String, String> loginData) 
	 {
	    String username = loginData.get("username");
	    String password = loginData.get("password");
	    String result = serv.checkLogin(username, password);
	    return result;
	  }
	  @PostMapping("/adduser")
	  public cModel AddUser(@RequestBody cModel car) 
	  {
		  return serv.addUser(car);
	  }
      @GetMapping
      public List<cModel> listAll()
      {
    	  return serv.getUser();
      }
    
}

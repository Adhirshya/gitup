package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.loginModel;
import com.example.demo.Service.loginService;


@RestController
@RequestMapping("/rails")
public class loginController 
{
	@Autowired
	private loginService serv;
	
	 @PostMapping("/login")
	  public String login(@RequestBody Map<String, String> loginData) 
	 {
	    String username = loginData.get("username");
	    String password = loginData.get("password");
	    String result = serv.checkLogin(username, password);
	    return result;
	  }

	  @PostMapping("/adduser")
	  public loginModel AddUser(@RequestBody loginModel rail)
	  {
		  return serv.addUser(rail);
	  }
	  
     @GetMapping
     public List<loginModel> listAll()
     {
   	  return serv.getUser();
     }

}

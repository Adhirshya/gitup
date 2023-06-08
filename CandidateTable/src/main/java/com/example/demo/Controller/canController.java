package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.canModel;
import com.example.demo.Service.canService;
@RestController
public class canController 
{
	@Autowired
	public canService cs;
	@PostMapping
	public canModel addDetails(@RequestBody canModel obj3)
	{
		return cs.saveInfo(obj3);
	}

}

package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.canModel;
import com.example.demo.Repo.canRepo;

@Service

public class canService 
{
	@Autowired
	public canRepo obj;
	public canModel saveInfo(canModel obj1)
	{
		return obj.save(obj1);
	}

}

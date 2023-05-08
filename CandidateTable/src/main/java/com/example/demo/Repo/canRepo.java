package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.canModel;

public interface canRepo extends JpaRepository< canModel, Integer> 
{
	

}

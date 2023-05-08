package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.day6.cModel;

public interface cRepo extends JpaRepository<cModel, Integer> 
{
	cModel findByusername(String username);

}

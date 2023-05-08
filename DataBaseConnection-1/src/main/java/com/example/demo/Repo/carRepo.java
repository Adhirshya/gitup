package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.day6.carModel;


public interface carRepo extends JpaRepository< carModel , Integer> 
{

	@Query(value="select * from car",nativeQuery = true)
	List<carModel> getAllData();
	
	
}

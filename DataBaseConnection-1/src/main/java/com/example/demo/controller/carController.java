package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repo.carRepo;
import com.example.demo.day6.carModel;
import com.example.demo.service.carService;
@RestController
public class carController {
@Autowired
public carService cs;

@PostMapping("/cm")
public carModel addDetails(@RequestBody carModel obj4)
{
	return cs.saveInfo(obj4);
}

@GetMapping("/sortDesc/{name}")
public List<carModel> sortName(@PathVariable("name")String name)
{
	return cs.sortDesc(name);
}

//pagination
@GetMapping("/pagination/{pnu}/{psize}")
public List<carModel>paginationData(@PathVariable("pnu") int pnu,@PathVariable("psize")int psize)
{
	return cs.paginationData(pnu, psize);
}

@Autowired
public carRepo cr;

@GetMapping("saveStudent")
public List<carModel> getD()
{
	return cr.getAllData();
}



}

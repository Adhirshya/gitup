package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Repo.carRepo;
import com.example.demo.day6.carModel;

@Service
public class carService
{
	@Autowired
	public carRepo obj;
	public carModel saveInfo(carModel obj1)
	{
		return obj.save(obj1);
		
	}
	//sorting
	public List<carModel> sortDesc(String name)
	{
		return obj.findAll(Sort.by(name).descending());
	}
	//pagination
	public List<carModel> paginationData(int pageNum,int pagesize)
	{
		Page<carModel>p =obj.findAll(PageRequest.of(pageNum, pagesize));
		return p.getContent();
	}
}
package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Model.railModel;
import com.example.demo.Repository.railRepo;

@Service
public class railService 
{
	@Autowired
	public railRepo obj;
	//post
	public railModel saveInfo(railModel obj1)
	{
		return obj.save(obj1);
	}
	//get
	public List<railModel> getInfo()
	{
		return obj.findAll();
	}
	
	//put
    public railModel updateInfo(railModel iu)
    {
    	return obj.saveAndFlush(iu);
    }
    //delete
    public void deleteInfo(int trainid)
    {
    	obj.deleteById(trainid);
    }
    
  //sorting
  	public List<railModel> sortDesc(String name)
  	{
  		return obj.findAll(Sort.by(name).descending());
  	}
  	//pagination
  	public List<railModel> paginationData(int pageNum,int pagesize)
  	{
  		Page<railModel>p =obj.findAll(PageRequest.of(pageNum, pagesize));
  		return p.getContent();
  	}
}

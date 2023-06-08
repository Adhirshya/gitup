package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.railModel;

import com.example.demo.Service.railService;



@RestController
@CrossOrigin("http://localhost:3000")

public class railController
{
	private final railService railService;

    @Autowired
    public railController(railService railService) {
        this.railService = railService;
    }

    @PutMapping("/put/{id}")
    public Optional<railModel> updateById(@PathVariable("id") Long id, @RequestBody railModel updatedModel) 
    {
        return railService.updateById(id, updatedModel);
    }
	
	@Autowired
	public railService rs;
	
	@PostMapping("/post")
	public railModel addDetails(@RequestBody railModel obj3)
	{
		return rs.saveInfo(obj3);
	}
	
    @GetMapping("/get")
    public List <railModel> getDetails()
    {
    	return rs.getInfo();
    }

    
   @PutMapping("/put")
    public railModel updateDetails(@RequestBody railModel trainid)
    {
    	return rs.updateInfo(trainid);
    }
    
   @DeleteMapping("/delete/{rid}")
    public String deleteDetails(@PathVariable ("rid") Long trainid)
    {
    	rs.deleteInfo(trainid);
    	return "Train Id "+trainid+" is deleted";
    }
    
    
    @GetMapping("/get/{id}")
    public Optional<railModel> getById(@PathVariable("id") Long trainid)
    {
        return rs.getById(trainid);
        
    }
    
    
}

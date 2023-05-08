package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Question;
import com.example.demo.Repository.QuestionRepo;

@RestController
@RequestMapping("/question")
public class QuestionController 
{
	@Autowired
	public QuestionRepo qrepo;
	
	@PostMapping("")
	public String saveDetails(@RequestBody Question ques)
	{
		qrepo.save(ques);
		return "Data Saved";
	}
	@GetMapping("")
	public List<Question> getDetails()
	{
		return qrepo.findAll();
	}
	@PutMapping("")
	public String updateDetails(@RequestBody Question quest)
	{
		qrepo.saveAndFlush(quest);
		return "Data Changed";
	}
	@DeleteMapping("{qno}")
	public String deleteDetails(@PathVariable int qno)
	{
		qrepo.deleteById(qno);
		return "Qno "+qno+" deleted";
	}

}

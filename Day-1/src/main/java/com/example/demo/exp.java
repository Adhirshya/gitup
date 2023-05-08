package com.example.demo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class exp 
{


	
		@Value("${carName:thar}")
	    public String name;
		@GetMapping("/he")
		public String display() {
			return "car : "+name;
		
	}

}

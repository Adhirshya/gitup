package com.example.demo.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class LoginModel 
{
	

		@Id
		private String Email;
		private String Password;
		public String getEmail() {
			return Email;
		}
		public void setEmail(String email) {
			Email = email;
		}
		public String getPassword() {
			return Password;
		}
		public void setPassword(String password) {
			Password = password;
		}
		
		

}

package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.LoginModel;

public interface LoginRepo extends JpaRepository<LoginModel, String> {

}

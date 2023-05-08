package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.AdminModel;

public interface AdminRepo extends JpaRepository<AdminModel, String> {

}

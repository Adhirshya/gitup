package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Answer;

public interface AnswerRepo extends JpaRepository<Answer, Integer> {

}

package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Student;



@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
}

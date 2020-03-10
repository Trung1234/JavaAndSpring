package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Courseregist;

@Repository
public interface CourseregistRepository  extends JpaRepository<Courseregist, Integer>{

}

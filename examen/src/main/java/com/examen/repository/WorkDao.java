package com.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.entity.Employee_worked;


public interface WorkDao  extends JpaRepository<Employee_worked, Long>{

}

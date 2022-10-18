package com.examen.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.examen.entity.Employees;
import com.examen.entity.Job;

public interface EmployeeDao extends JpaRepository<Employees, Long>{

	List<Employees> findByNameContaining(String name);

	 @Query(" from Employees e "
	 		+ "inner join Employee_worked  w "
	 		+ " inner join Job j on"
	 		+ "	e.id = w.id where w.worked_date = :worked  ")
	  
	List<Employees> findBySalary(Date worked);

}

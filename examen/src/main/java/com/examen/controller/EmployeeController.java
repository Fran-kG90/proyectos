package com.examen.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examen.entity.Employees;
import com.examen.repository.EmployeeDao;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeDao repo;

	@GetMapping("/employees")
	public ResponseEntity<List<Employees>> getAllEmployees(@RequestParam(required = false) String name) {
		try {
			List<Employees> employees = new ArrayList<Employees>();

			if (name != null)
				repo.findAll().forEach(employees::add);
			else
				repo.findByNameContaining(name).forEach(employees::add);

			if (employees.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(employees, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/employee")
	public ResponseEntity<Employees> createTutorial(@RequestBody Employees employee) {
		Employees _employee = null;
		try {
			SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-dd-MM");

			Date compara = sdformat.parse("2005-01-01");

			if (employee.getBirthdate().after(compara)) {
				 _employee = repo.save(new Employees(employee.getGender(), employee.getJob_id(),
						employee.getName(), employee.getLast_name(), employee.getBirthdate()));
				return new ResponseEntity<>(_employee, HttpStatus.CREATED);

			} 
			else	if (employee.getBirthdate().equals(compara)) {
				 _employee = repo.save(new Employees(employee.getGender(), employee.getJob_id(),
						employee.getName(), employee.getLast_name(), employee.getBirthdate()));
				return new ResponseEntity<>(_employee, HttpStatus.CREATED);

			}

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(_employee, HttpStatus.CREATED);
	
	}

	@GetMapping("/employeeBySalary")
	public ResponseEntity<List<Employees>> getHourWorked(@RequestParam(required = false) Date hour) {
		try {
			List<Employees> employees = new ArrayList<Employees>();

			if (hour == null)
				repo.findAll().forEach(employees::add);
			else
				repo.findBySalary(hour).forEach(employees::add);

			if (employees.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(employees, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

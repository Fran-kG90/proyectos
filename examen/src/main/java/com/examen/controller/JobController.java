package com.examen.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examen.entity.Employees;
import com.examen.entity.Job;
import com.examen.repository.JobDao;

@RestController
@RequestMapping("/api")
public class JobController {

	@Autowired
	JobDao repo;

	@GetMapping("/jobsByPuesto/{puesto}")
	public ResponseEntity<List<Job>> getAllJobs(@PathVariable("puesto") String puesto) {
		List<Job> jobs = repo.findByPuesto(puesto);

		if (puesto != null) {
			return new ResponseEntity<>(jobs, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/jobs")
	public List<Job> getAllEmployees() {
		return repo.findAll();
	}
	
	
	@GetMapping("/jobsByLastname/{last_name}")
	public ResponseEntity<List<Job>> getLastnameJobs(@PathVariable("last_name") String lastname) {
		
		List<Job> jobs = repo.findByLastname(lastname);

		if (lastname != null) {
			return new ResponseEntity<>(jobs, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/jobsByHourWorked/{start}/end/{end}")
	public ResponseEntity<Job> getHourWorked(@PathVariable("end") Date start, @PathVariable("end") Date end) throws ParseException {
		
//		Date myDate1 = new SimpleDateFormat("dd").parse(start);
//		Date myDate2 = new SimpleDateFormat("dd").parse(end);
		List<Job> jobs = repo.findByhour(start,end);

		if ( start != null && end != null) {
			return new ResponseEntity<>(jobs.get(0), HttpStatus.OK); 
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}

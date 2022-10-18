package com.examen.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping("/jobsByPuesto")
	public ResponseEntity<List<Job>> getAllJobs(@RequestParam(required = false) String puesto) {
		try {
			List<Job> jobs = new ArrayList<Job>();

			if (puesto == null)
				repo.findAll().forEach(jobs::add);
			else
				repo.findByPuesto(puesto).forEach(jobs::add);

			if (jobs.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(jobs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/jobs")
	public List<Job> getAllEmployees() {
		return repo.findAll();
	}
	
	
	@GetMapping("/jobsByLastname")
	public ResponseEntity<List<Job>> getLastnameJobs(@RequestParam(required = false) String lastname) {
		try {
			List<Job> jobs = new ArrayList<Job>();

			if (lastname == null)
				repo.findAll().forEach(jobs::add);
			else
				repo.findByLastname(lastname).forEach(jobs::add);

			if (jobs.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(jobs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/jobsByHourWorked")
	public ResponseEntity<List<Job>> getHourWorked(@RequestParam(required = false) Date hour) {
		try {
			List<Job> jobs = new ArrayList<Job>();

			if (hour == null)
				repo.findAll().forEach(jobs::add);
			else
				repo.findByhour(hour).forEach(jobs::add);

			if (jobs.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(jobs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}

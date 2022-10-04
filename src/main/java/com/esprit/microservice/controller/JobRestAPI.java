package com.esprit.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.microservice.entite.Job;
import com.esprit.microservice.service.JobService;

@RestController
public class JobRestAPI {
	
private String title ="Hello , I m the Job Microservice";
	
	
	@Autowired
	private JobService js;
	
	
	@RequestMapping("/helloJob")
	public String sayHello(){
		System.out.println(title);
		return title;
	}
	@PostMapping("/addJob")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Job> createJob(@RequestBody Job job){
		return new ResponseEntity<> (js.addJob(job), HttpStatus.OK);
	}
	@GetMapping("/GetAllJob")
	@ResponseStatus(HttpStatus.OK)
	    public List<Job> getAllUserbyroleName() {		
	     return (List<Job>) (js.getAllJob());
	    }
	
	@PutMapping(value ="/{ID}", produces =MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Job> updateJob(@PathVariable(value = "ID") int ID,@RequestBody Job job ){
		return new ResponseEntity<>(js.updateJob(ID, job),HttpStatus.OK);
	}
	@DeleteMapping(value ="/{ID}", produces =MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deteleteJob(@PathVariable(value ="ID")int ID){
		return new ResponseEntity<>(js.deleteJob(ID),HttpStatus.OK);

	}

}

package com.esprit.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.microservice.entite.Job;
import com.esprit.microservice.repositories.JobRepo;

@Service
public class JobService {

	
	@Autowired 
	private JobRepo jr;
	
	public Job addJob(Job job){
		return jr.save(job);
	}
	public  List<Job> getAllJob(){
		  return jr.findAll();
	  }
	public Job updateJob (int id, Job newJob) {
		if (jr.findById(id).isPresent()){
			Job existingJob = jr.findById(id).get();
			existingJob.setEtat(newJob.getEtat());
			return jr.save(existingJob);
		}else 
			return null;
			}
	
	public String deleteJob(int id){
		if(jr.findById(id).isPresent()){
			jr.deleteById(id);
			return "Job supprimé";
		}else
			return "Job non  supprimé";
	}
}

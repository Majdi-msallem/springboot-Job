package com.esprit.microservice.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.esprit.microservice.entite.Job;

public interface JobRepo extends JpaRepository<Job, Integer> {
	@Query("select j from Job j where j.ID like :ID  ")
	public Page <Job> candidatByID (@Param ("ID") int n ,Pageable pageable);

}

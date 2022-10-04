package com.esprit.microservice;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.esprit.microservice.entite.Job;
import com.esprit.microservice.repositories.JobRepo;

@SpringBootApplication
public class JobApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobApplication.class, args);
	}
	@Bean
	ApplicationRunner init (JobRepo jr){
		return args ->{
			Stream.of("Mariem","Sarra","Mouhamed").forEach(service->{
				jr.save(new Job(service));
			});
			jr.findAll().forEach(System.out::println);
		};

}
}

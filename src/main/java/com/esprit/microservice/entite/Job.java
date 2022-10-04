package com.esprit.microservice.entite;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Job implements Serializable {
	private static final long serialVersionUID = 6 ;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	public String service;
	public Boolean etat;
	public int getId() {
		return ID;
	}
	public void setId(int id) {
		ID = id;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public Boolean getEtat() {
		return etat;
	}
	public void setEtat(Boolean etat) {
		this.etat = etat;
	}
	public Job(int id, String service, Boolean etat) {
		super();
		ID = id;
		this.service = service;
		this.etat = etat;
	}
	public Job() {
		super();
	}
	public Job(String service) {
		super();
		this.service = service;
	}
	
	
}

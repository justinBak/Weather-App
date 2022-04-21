package com.tts.weatherapp;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Request {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String zipCode;
	@CreationTimestamp
	private Date createdAt;
	
	public Request() {
		
	}
	
	public Request(String zipCode) {
		setZipCode(zipCode);
	}

	public Long getId() {
		return id;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}

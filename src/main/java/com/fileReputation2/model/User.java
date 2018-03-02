package com.fileReputation2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class User {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private Long id;
	
	private String name;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
}

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
	
	private String userReputation;
	private boolean isKnowledgeableUser;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public User(Long id, String name, String userReputation) {
		super();
		this.id = id;
		this.name = name;
		this.userReputation = userReputation;
	}

	public User(Long id, String name, boolean isKnowledgeableUser) {
		super();
		this.id = id;
		this.name = name;
		this.isKnowledgeableUser = isKnowledgeableUser;
	}
	public User(Long id, String name, String userReputation,boolean isKnowledgeableUser) {
		super();
		this.id = id;
		this.name = name;
		this.userReputation = userReputation;
		this.isKnowledgeableUser = isKnowledgeableUser;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserReputation() {
		return userReputation;
	}

	public void setUserReputation(String userReputation) {
		this.userReputation = userReputation;
	}

	public boolean isKnowledgeableUser() {
		return isKnowledgeableUser;
	}

	public void setKnowledgeableUser(boolean isKnowledgeableUser) {
		this.isKnowledgeableUser = isKnowledgeableUser;
	}
	
	
}

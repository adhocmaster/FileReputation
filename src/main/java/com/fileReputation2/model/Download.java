package com.fileReputation2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Download {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long fileId;
	private Long userId;
	private double fileReputation;
	
	public Download(Long id, Long fileId, Long userId) {
		super();
		this.id = id;
		this.fileId = fileId;
		this.userId = userId;
	}
	
	public Download(Long id, Long fileId, Long userId, double fileReputation){
		super();
		this.id = id;
		this.fileId = fileId;
		this.userId = userId;
		this.fileReputation = fileReputation;
	}

	public Download() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public double getFileReputation() {
		return fileReputation;
	}

	public void setFileReputation(double fileReputation) {
		this.fileReputation = fileReputation;
	}


}

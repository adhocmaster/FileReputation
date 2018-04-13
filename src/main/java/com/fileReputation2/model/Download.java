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
	
	@ManyToOne
	private FileInfo file;
	
	@ManyToOne
	private User downloader;
	
	private double fileReputation;
	
	public Download(Long id, FileInfo file, User downloader) {
		super();
		this.id = id;
		this.file = file;
		this.downloader = downloader;
	}
	
	public Download(Long id, FileInfo file, User downloader, double fileReputation){
		super();
		this.id = id;
		this.file = file;
		this.downloader = downloader;
		this.fileReputation = fileReputation;
	}

	public Download() {
		super();
		// TODO Auto-generated constructor stub
	}


}

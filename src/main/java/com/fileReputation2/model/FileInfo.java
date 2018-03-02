package com.fileReputation2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class FileInfo {

	public FileInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public FileInfo(Long id, String fileName, Float fileReputation, String fileType, User uploader) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileReputation = fileReputation;
		this.fileType = fileType;
		this.uploader = uploader;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "FileName")
	private String fileName;

	@Column( name = "FileReputation")
	private Float fileReputation;
	
	

	@Column( name = "FileType")
	private String fileType;
	
	@ManyToOne
	private User uploader;
	
}

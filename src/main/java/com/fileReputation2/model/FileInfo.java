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
	
	
	public FileInfo(Long id, String fileName, Float fileReputation, String fileType, User uploader, Float keywordRelevance) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileReputation = fileReputation;
		this.fileType = fileType;
		this.uploader = uploader;
		this.keywordRelevance = keywordRelevance;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "FileName")
	private String fileName;

	@Column( name = "FileReputation")
	private Float fileReputation;
	
	@Column ( name = "keywordRelevance")
	private float keywordRelevance;
	

	@Column( name = "FileType")
	private String fileType;
	
	@ManyToOne
	private User uploader;

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public Float getFileReputation() {
		return fileReputation;
	}


	public void setFileReputation(Float fileReputation) {
		this.fileReputation = fileReputation;
	}


	public float getKeywordRelevance() {
		return keywordRelevance;
	}


	public void setKeywordRelevance(float keywordRelevance) {
		this.keywordRelevance = keywordRelevance;
	}


	public String getFileType() {
		return fileType;
	}


	public void setFileType(String fileType) {
		this.fileType = fileType;
	}


	public User getUploader() {
		return uploader;
	}


	public void setUploader(User uploader) {
		this.uploader = uploader;
	}
	
	
}

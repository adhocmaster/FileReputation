package com.fileReputation2.model;

import java.util.GregorianCalendar;
import java.util.Random;

import com.fileReputation2.util.RandomDate;
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
	
	
	public FileInfo(Long id, String fileName, double fileReputation, String fileType, User uploader, Float keywordRelevance,
			GregorianCalendar uploadDate, int fileQuality) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileReputation = fileReputation;
		this.fileType = fileType;
		this.uploader = uploader;
		this.keywordRelevance = keywordRelevance;
		this.noOfDownloads = 0;
		this.uploadDate = uploadDate;
		/* if next double return is greater then 0.5, consider it as 1 
		 * fileQuality = 1 indicates that file is good
		 * fileQuality = 0 indicates that file is bad*/
		this.fileQuality = fileQuality;
//				new Random().nextDouble() > 0.5 ? 1 : 0;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "FileName")
	private String fileName;

	@Column( name = "FileReputation")
	private double fileReputation;
	
	@Column ( name = "keywordRelevance")
	private float keywordRelevance;
	

	@Column( name = "FileType")
	private String fileType;
	
	@Column(name = "NoOfDownloads")
	private long noOfDownloads; 
	
	@Column(name  = "UploadDate")
	private GregorianCalendar uploadDate;
	
	@Column(name = "FileQuality")
	private int fileQuality;
	
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


	public double getFileReputation() {
		return fileReputation;
	}


	public void setFileReputation(double fileReputation) {
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

	public long getNoOfDownloads() {
		return noOfDownloads;
	}


	public void setNoOfDownloads(long noOfDownloads) {
		this.noOfDownloads = noOfDownloads;
	}


	public GregorianCalendar getUploadDate() {
		return uploadDate;
	}


	public void setUploadDate(GregorianCalendar uploadDate) {
		this.uploadDate = uploadDate;
	}


	public int getFileQuality() {
		return fileQuality;
	}


	public void setFileQuality(int fileQuality) {
		this.fileQuality = fileQuality;
	}
	
}

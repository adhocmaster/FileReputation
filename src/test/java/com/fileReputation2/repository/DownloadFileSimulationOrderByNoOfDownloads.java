package com.fileReputation2.repository;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.math3.distribution.ZipfDistribution;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.fileReputation2.model.Download;
import com.fileReputation2.model.FileInfo;
import com.fileReputation2.model.User;
import com.fileReputation2.util.CalculateFileReputation;

public class DownloadFileSimulationOrderByNoOfDownloads {

	private Random random ;
	private int noOfDownload = 100;

	private ZipfDistribution zipfDistribution;
	@Value("${file_rating.NoOfUser}")
	int NoOfUser;

	@Value("${file_rating.NoOfFileType}")
	int NoOfFileType;

	@Value("${zipf_distribution.exponetial}")
	int exponent;

	@Autowired
	FileInfoRepository fileInfoRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	DownloadRepository downloadRepository;
	
	@Test
	public void test() {
		random = new Random();
		
		downloadSimulationBasedOnNoOfDownloads(); 

		downloadSimulationBasedOnPreviousRating();
		
		
	}
	
	public void downloadSimulationBasedOnNoOfDownloads() {
		int testCycleNo = downloadRepository.findAllByOrderByTestCycleNoDesc().get(0).getTestCycleNo();
		List<FileInfo> fileInfoList = new ArrayList<FileInfo>();
		fileInfoList = fileInfoRepository.findAllByOrderByNoOfDownloadsDesc();
		zipfDistribution = new ZipfDistribution(fileInfoList.size(), exponent);
		int[] fileIndexes = zipfDistribution.sample(100000);
		for (int i = 0; i < fileIndexes.length; i++) {
			FileInfo currentDownloadedFile = fileInfoList.get(fileIndexes[i] - 1);
			User user = userRepository.getOne((long) Math.ceil(NoOfUser * random.nextDouble()));	
			
			double W_DR = CalculateFileReputation.calcluateW_DRBasedOnNoOfDownloads(currentDownloadedFile, user);
			
			List<Download> fileDownloadedByUser = downloadRepository.findAllByUserId(user.getId());
			double R_D = CalculateFileReputation.calculateR_D(fileDownloadedByUser);
			double R_PREV = currentDownloadedFile.getFileReputation();
			
			double R_AFTER = W_DR * R_PREV + (1 - W_DR ) * R_D;
			
			currentDownloadedFile.setFileReputation(R_AFTER);
			fileInfoRepository.save(currentDownloadedFile);
			
			Download download = new Download(null, currentDownloadedFile.getId(), user.getId(),R_PREV, R_AFTER, testCycleNo);
			downloadRepository.save(download);
		}
		
	}
	
	public void downloadSimulationBasedOnPreviousRating() {
		int testCycleNo = downloadRepository.findAllByOrderByTestCycleNoDesc().get(0).getTestCycleNo();
		List<FileInfo> fileInfoList = new ArrayList<FileInfo>();
		fileInfoList = fileInfoRepository.findAllByOrderByNoOfDownloadsDesc();
		zipfDistribution = new ZipfDistribution(fileInfoList.size(), exponent);
		int[] fileIndexes = zipfDistribution.sample(100000);
		for (int i = 0; i < fileIndexes.length; i++) {
			FileInfo currentDownloadedFile = fileInfoList.get(fileIndexes[i] - 1);
			User user = userRepository.getOne((long) Math.ceil(NoOfUser * random.nextDouble()));	
			
			double W_DR = CalculateFileReputation.calculateW_DRBasedOnPreviousRating(currentDownloadedFile, user);
			
			List<Download> fileDownloadedByUser = downloadRepository.findAllByUserId(user.getId());
			double R_D = CalculateFileReputation.calculateR_D(fileDownloadedByUser);
			double R_PREV = currentDownloadedFile.getFileReputation();
			
			double R_AFTER = W_DR * R_PREV + (1 - W_DR ) * R_D;
			
			currentDownloadedFile.setFileReputation(R_AFTER);
			fileInfoRepository.save(currentDownloadedFile);
			
			Download download = new Download(null, currentDownloadedFile.getId(), user.getId(),R_PREV, R_AFTER, testCycleNo);
			downloadRepository.save(download);
		}		
	} 

	public void downloadSimulationBasedOnTimePeriod() {
		//TO-DO : need to implement method in CalculateFileReputation
	}
	
	public void downloadFileSimulationBasedOnHighlyTrustedUser() {
		//To-DO: need to implement method in CalculateFileReputation
	}
	
}

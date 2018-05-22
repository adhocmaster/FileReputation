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

public class DownloadFileSimulationOrderByArrivalDate {

	private Random random;
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
		Random random = new Random();
		int testCycleNo = 1;
		List<FileInfo> fileInfoList = new ArrayList<FileInfo>();
		fileInfoList = fileInfoRepository.findAllByOrderByUploadDateDesc();
		zipfDistribution = new ZipfDistribution(fileInfoList.size(), exponent);
		int[] fileIndexes = zipfDistribution.sample(100000);
		for (int i = 0; i < fileIndexes.length; i++) {
			FileInfo currentDownloadedFile = fileInfoList.get(fileIndexes[i] - 1);
			User user = userRepository.getOne((long) Math.ceil(NoOfUser * random.nextDouble()));	
			
			double R_AFTER = CalculateFileReputation.calculateFileReputation(currentDownloadedFile, user);
			currentDownloadedFile.setFileReputation(R_AFTER);
			fileInfoRepository.save(currentDownloadedFile);
			
			Download download = new Download(null, currentDownloadedFile.getId(), user.getId(), R_AFTER,testCycleNo);
			downloadRepository.save(download);
			

		}

	}
}

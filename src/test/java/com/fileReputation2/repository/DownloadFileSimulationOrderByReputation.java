package com.fileReputation2.repository;

import java.io.Console;
import java.util.ArrayList;
import java.util.Random;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.fileReputation2.model.Download;
import com.fileReputation2.model.FileInfo;
import com.fileReputation2.model.User;
import com.fileReputation2.util.CalculateFileReputation;

import org.apache.commons.math3.distribution.ZipfDistribution;

@RunWith(SpringRunner.class)
@SpringBootTest


public class DownloadFileSimulationOrderByReputation {
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
	public void testFileDownload() {

		Random random = new Random();
		int testCycleNo = 1;
		List<FileInfo> fileInfoList = new ArrayList<FileInfo>();
		fileInfoList = fileInfoRepository.findAllByOrderByFileReputationDesc();
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

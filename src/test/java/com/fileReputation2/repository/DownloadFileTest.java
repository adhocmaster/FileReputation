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

import com.fileReputation2.model.FileInfo;

import org.apache.commons.math3.distribution.ZipfDistribution;
@RunWith(SpringRunner.class)
@SpringBootTest
public class DownloadFileTest {
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
	UserRepository UserRepository;
	
	@Autowired
	DownloadRepository downloadRepository;
	
	@Test
	public void testFileDownload(){
		List<FileInfo> fileInfoList = new ArrayList<FileInfo>();
		fileInfoList = fileInfoRepository.findAllByOrderByFileReputationDesc();
		zipfDistribution = new ZipfDistribution(fileInfoList.size(), exponent);
		int[]sampleIndexes = zipfDistribution.sample(1000);
		for(int i=0; i<sampleIndexes.length; i++) {
			System.out.println(sampleIndexes[i] + " ");
		}
		
		
		
	}
	
}

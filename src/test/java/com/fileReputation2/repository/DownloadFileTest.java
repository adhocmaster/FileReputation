package com.fileReputation2.repository;

import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fileReputation2.model.FileInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DownloadFileTest {
	private Random random;
	private int noOfDownload = 100;
	@Value("${file_rating.NoOfUser}")
	int NoOfUser;

	@Value("${file_rating.NoOfFileType}")
	int NoOfFileType;
	
	@Autowired
	FileInfoRepository fileInfoRepository;
	
	@Autowired
	UserRepository UserRepository;
	
	@Autowired
	DownloadRepository downloadRepository;
	
	@Test
	public void testFileDownload(){
		random = new Random();
		for(int i = 0; i< noOfDownload; i++){
			//FileInfo fileInfo = 
		}
		
	}
	
}

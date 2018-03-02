package com.fileReputation2.repository;

import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fileReputation2.model.Download;
import com.fileReputation2.model.FileInfo;
import com.fileReputation2.model.User;
import com.fileReputation2.service.InitialFileRatingService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UploadFileRepositoryTest {
	
	private int NoOfUploadFiles = 20;
	private Random random;
	
	@Value("${file_rating.NoOfUser}")
	int NoOfUser;

	@Value("${file_rating.NoOfFileType}")
	int NoOfFileType;

	@Autowired
	InitialFileRatingService initialFileRatingService;
	
	@Autowired
	FileInfoRepository fileInfoReposiotry;
	
	@Autowired
	UserRepository userRepository;
	
	
	@Test
	public void testUploadFile() {
		random = new Random();
		for (int i = 0; i< NoOfUploadFiles; i++){
			User user = userRepository.findOne((long)Math.ceil( random.nextFloat() * NoOfUser));
			
			String fileType = Integer.toString((int)Math.ceil( NoOfFileType * random.nextFloat()));
			
			float keyWordRelevance = random.nextFloat();
			
			float initialReputation = initialFileRatingService.getInitialReputation(fileType, keyWordRelevance);
			
			FileInfo fileInfo = new FileInfo(null,"Uploaded_file_" + i,initialReputation,fileType,user,keyWordRelevance);
			
			fileInfoReposiotry.save(fileInfo);
		}
	}
}

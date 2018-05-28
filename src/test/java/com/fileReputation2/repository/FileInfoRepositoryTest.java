package com.fileReputation2.repository;

import java.util.GregorianCalendar;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fileReputation2.model.FileInfo;
import com.fileReputation2.model.User;
import com.fileReputation2.util.RandomDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileInfoRepositoryTest {
	
	@Value("${file_rating.NoOfUser}")
	int NoOfUser;

	@Value("${file_rating.NoOfFileType}")
	int NoOfFileType;
	
	@Value("${file_rating.NoOfFile}")
	int NoOfFiles;
	
	
	@Autowired
	FileInfoRepository fileInfoRepository;
	@Autowired
	UserRepository userRepository;

	@Test
	public void testCreateFile() {

		Random random = new Random();
		for(int i = 0; i< NoOfFiles; i++){
			User user = userRepository.getOne((long)Math.ceil(NoOfUser * random.nextDouble()));
			double reputation = random.nextDouble();
			String fileType = Integer.toString((int) Math.ceil(NoOfFileType * random.nextDouble()));
			float keywordRelevance = (float)(random.nextDouble());
			
			GregorianCalendar fileUploadDate = RandomDate.getRandomDate(2016, 2018);
			
			FileInfo fileInfo = new FileInfo(null,"file_"+i,(float)reputation,fileType,user,keywordRelevance);
			fileInfoRepository.save( fileInfo );
		}
	}

}

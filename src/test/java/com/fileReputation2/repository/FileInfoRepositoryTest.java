package com.fileReputation2.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fileReputation2.model.FileInfo;
import com.fileReputation2.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileInfoRepositoryTest {
	
	@Autowired
	FileInfoRepository fileInfoRepository;

	@Test
	public void testCreateFile() {

		
		FileInfo fileInfo = new FileInfo( null,  );
		
		fileInfoRepository.save( fileInfo );
		
	}

}

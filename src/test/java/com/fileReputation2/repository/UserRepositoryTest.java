package com.fileReputation2.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fileReputation2.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
	
	@Autowired
	UserRepository userRepository;

	@Test
	public void testCreate1User() {
		
		long NoOfUser = 50;
		for(int i = 0;i < NoOfUser; i++){
			User user = new User( null, "User_" + i );
			userRepository.save( user );
		}

		
		
	}

}

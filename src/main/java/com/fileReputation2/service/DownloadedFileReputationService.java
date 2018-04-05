package com.fileReputation2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fileReputation2.model.User;
import com.fileReputation2.repository.DownloadRepository;
import com.fileReputation2.repository.FileInfoRepository;
import com.fileReputation2.repository.UserRepository;

@Service
public class DownloadedFileReputationService {
	
	@Autowired
	FileInfoRepository fileInfoRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	DownloadRepository downloadRepository;
	
	private float getDownloaderReputation(long user_id){
		User user = userRepository.getOne(user_id);
		return 0;
	}
}

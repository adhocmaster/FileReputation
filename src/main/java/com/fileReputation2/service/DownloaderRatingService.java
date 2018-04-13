package com.fileReputation2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fileReputation2.model.FileInfo;
import com.fileReputation2.model.User;
import com.fileReputation2.repository.FileInfoRepository;
import com.fileReputation2.repository.UserRepository;

@Service
public class DownloaderRatingService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	FileInfoRepository fileInfoRepository;
	
	private float getUserReputation(long id,float currentDownloadFileReputation){
		User user = userRepository.findOne(id);
		List<FileInfo> downloadedFileList = new ArrayList<FileInfo>();
		downloadedFileList = fileInfoRepository.findByUploader(user);
		float sumOfFileReputation = 0;
		for(int i = 0; i< downloadedFileList.size(); i++){
			FileInfo fileInfo = downloadedFileList.get(i);
			sumOfFileReputation += fileInfo.getFileReputation();
		}
		
		return (sumOfFileReputation + currentDownloadFileReputation) /(downloadedFileList.size() + 1);
	}
}

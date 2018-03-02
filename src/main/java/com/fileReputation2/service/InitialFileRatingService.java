package com.fileReputation2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fileReputation2.model.FileInfo;
import com.fileReputation2.repository.FileInfoRepository;

@Service
public class InitialFileRatingService {
	
	@Autowired
	FileInfoRepository fileInfoRepository;
	
	@Value("${file_rating.WKR}")
	public float WKR;

	private float getKWR(){
		return this.WKR;
	}
	private float getAvarageReputationOfFile(String fileType){
		List<FileInfo> fileList = new ArrayList<FileInfo>();
		fileList = fileInfoRepository.findByFileType(fileType);
		float sumOfReputation = 0;
		for(int i = 0; i< fileList.size(); i++){
			FileInfo fileInfo = fileList.get(i);
			sumOfReputation += fileInfo.getFileReputation(); 
		}

		return sumOfReputation/fileList.size();
	}

	public float getInitialReputation(String fileType, float keyWordRelevance){
		
		float reputation = this.WKR * keyWordRelevance + (1-this.WKR) * getAvarageReputationOfFile(fileType); 
		return reputation;
	}
}

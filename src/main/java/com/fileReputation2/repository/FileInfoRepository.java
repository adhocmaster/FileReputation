package com.fileReputation2.repository;

import java.util.List;

import javax.persistence.OrderBy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fileReputation2.model.FileInfo;
import com.fileReputation2.model.User;

public interface FileInfoRepository extends JpaRepository<FileInfo, Long>{

	List<FileInfo> findByFileType(String FileType);
	
	List<FileInfo> findByUploader(User user);
	
	
	List<FileInfo> findAllByOrderByFileReputationDesc();
	List<FileInfo> findAllByOrderByUploadDateDesc();
	List<FileInfo> findAllByOrderByNoOfDownloadsDesc();
	
	
}

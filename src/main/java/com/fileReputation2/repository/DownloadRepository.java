package com.fileReputation2.repository;

import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fileReputation2.model.Download;
import com.fileReputation2.model.FileInfo;
import com.fileReputation2.model.User;

public interface DownloadRepository extends JpaRepository<Download, Long> {
	
	List<Download> findAllByUserId(Long userId);
	List<Download> findAllByOrderByTestCycleNoDesc();

}

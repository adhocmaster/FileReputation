package com.fileReputation2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fileReputation2.model.FileInfo;

public interface FileInfoRepository extends JpaRepository<FileInfo, Long>{

}

package com.fileReputation2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fileReputation2.model.Download;

public interface DownloadRepository extends JpaRepository<Download, Long> {

}

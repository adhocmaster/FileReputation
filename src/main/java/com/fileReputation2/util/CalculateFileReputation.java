package com.fileReputation2.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fileReputation2.model.Download;
import com.fileReputation2.model.FileInfo;
import com.fileReputation2.model.User;
import com.fileReputation2.repository.DownloadRepository;

public class CalculateFileReputation {
	
	@Autowired
	static DownloadRepository downloadRepository;
	public static double calculateFileReputation(FileInfo file, User downloader) {
		List<Download> fileDownloadedByUser = downloadRepository.findAllByUserId(downloader.getId());

		double R_D = calculateR_D(fileDownloadedByUser);
		double R_PREV = file.getFileReputation();
		double R_AFTER = R_PREV * R_PREV + (1 - R_PREV ) * R_D;
		return R_AFTER;
	}
	public static double calculateR_D(List<Download> fileDownloadedByUser) {

		double sumOfFileReputatio = 0;
		for (int i = 0; i < fileDownloadedByUser.size(); i++) {
			Download download = fileDownloadedByUser.get(i);
			sumOfFileReputatio += download.getFileReputation();
		}

		return sumOfFileReputatio / fileDownloadedByUser.size();
	}
}

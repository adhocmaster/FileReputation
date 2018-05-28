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

		double sumOfFileReputation = 0;
		for (int i = 0; i < fileDownloadedByUser.size(); i++) {
			Download download = fileDownloadedByUser.get(i);
			sumOfFileReputation += download.getNewFileReputation();
		}

		return sumOfFileReputation / fileDownloadedByUser.size();
	}
	
	public static double calcluateW_DRBasedOnNoOfDownloads(FileInfo file, User downloader) {
		int noOfPreviousDownloads = downloadRepository.findAllByUserId(downloader.getId()).size() ;
		
		double W_DR = noOfPreviousDownloads/(noOfPreviousDownloads + 1);
		return W_DR;
	}
	
	
	public static double calculateW_DRBasedOnTimePeriod(FileInfo file, User downloader) {
		//TODO : this method should be implemented
		return 0;
	}
	
	public static double calculateW_DRBasedOnHighTrustedDownloaders(FileInfo file, User downloader) {
		//TO-DO : this method should be implemented
		return 0;
	}
	public static double calculateW_DRBasedOnPreviousRating(FileInfo file, User downloader) {
		double W_DR = file.getFileReputation();
		return W_DR;
	}
}

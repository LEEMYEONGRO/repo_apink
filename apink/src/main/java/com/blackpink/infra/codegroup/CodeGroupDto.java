package com.blackpink.infra.codegroup;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class CodeGroupDto {

	private String cgSeq;
	private String cgName;
	private Integer cgDeleteNy;
	private Date cgCreationDate;
	private Date cgModificationDate;
	
	private MultipartFile uploadFile;
	private MultipartFile[] uploadFiles;
	
	
	public String getCgSeq() {
		return cgSeq;
	}
	public void setCgSeq(String cgSeq) {
		this.cgSeq = cgSeq;
	}
	public String getCgName() {
		return cgName;
	}
	public void setCgName(String cgName) {
		this.cgName = cgName;
	}
	public Integer getCgDeleteNy() {
		return cgDeleteNy;
	}
	public void setCgDeleteNy(Integer cgDeleteNy) {
		this.cgDeleteNy = cgDeleteNy;
	}
	public Date getCgCreationDate() {
		return cgCreationDate;
	}
	public void setCgCreationDate(Date cgCreationDate) {
		this.cgCreationDate = cgCreationDate;
	}
	public Date getCgModificationDate() {
		return cgModificationDate;
	}
	public void setCgModificationDate(Date cgModificationDate) {
		this.cgModificationDate = cgModificationDate;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public MultipartFile[] getUploadFiles() {
		return uploadFiles;
	}
	public void setUploadFiles(MultipartFile[] uploadFiles) {
		this.uploadFiles = uploadFiles;
	}
	
	
	
	
	
}

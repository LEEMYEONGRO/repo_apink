package com.blackpink.infra.user.product;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class ProductDto {

//	제품
	private String pdSeq;
	private String pdCode;
	private String pdGender;
	private String pdName;
	private int pdPrice;
	private int pdView;
	private Integer pdlikeNy;
	private Integer pdDeleteNy;
	private Date pdCreationDate;
	private Date pdModificationDate;
//	제품
// 리뷰
	private String rvSeq;
	private String rvName;
	private String rvContent;
	private int rvScores;
// 리뷰
	
//	사이즈
	private String szSeq;
	private String szCode;		//컬러코드
	private int szStock;		//수량
	private String szpdSeq;
//	사이즈
	
//	컬러
	private String clSeq; 
	private String clCode;		//컬러코드
	private int clStock;		//수량
	private String clpdSeq;
//	컬러

//	구매수량
	private int PdpmQuantity;
//	구매수량
	
	private String mbName;
	private String mbSeq;
	
	
//	이미지업로드
	private String ibuType;
	private String ibuCategory;
	private Integer ibuDefaultNy;
	private String ibuPath;
	private String ibuOriginalName;
	private String ibuUuidName;
	private String ibuExt;
	private int ibuSize;
	private Integer ibuDelNy;
	private Date ibuRegDateTime;
	private MultipartFile[] uploadFiles;
//	이미지업로드
	
	public String getPdSeq() {
		return pdSeq;
	}
	public void setPdSeq(String pdSeq) {
		this.pdSeq = pdSeq;
	}
	public String getPdCode() {
		return pdCode;
	}
	public void setPdCode(String pdCode) {
		this.pdCode = pdCode;
	}
	public String getPdGender() {
		return pdGender;
	}
	public void setPdGender(String pdGender) {
		this.pdGender = pdGender;
	}
	public String getPdName() {
		return pdName;
	}
	public void setPdName(String pdName) {
		this.pdName = pdName;
	}
	public int getPdPrice() {
		return pdPrice;
	}
	public void setPdPrice(int pdPrice) {
		this.pdPrice = pdPrice;
	}
	public int getPdView() {
		return pdView;
	}
	public void setPdView(int pdView) {
		this.pdView = pdView;
	}
	public Integer getPdlikeNy() {
		return pdlikeNy;
	}
	public void setPdlikeNy(Integer pdlikeNy) {
		this.pdlikeNy = pdlikeNy;
	}
	public Integer getPdDeleteNy() {
		return pdDeleteNy;
	}
	public void setPdDeleteNy(Integer pdDeleteNy) {
		this.pdDeleteNy = pdDeleteNy;
	}
	public Date getPdCreationDate() {
		return pdCreationDate;
	}
	public void setPdCreationDate(Date pdCreationDate) {
		this.pdCreationDate = pdCreationDate;
	}
	public Date getPdModificationDate() {
		return pdModificationDate;
	}
	public void setPdModificationDate(Date pdModificationDate) {
		this.pdModificationDate = pdModificationDate;
	}
	public String getRvSeq() {
		return rvSeq;
	}
	public void setRvSeq(String rvSeq) {
		this.rvSeq = rvSeq;
	}
	public String getRvName() {
		return rvName;
	}
	public void setRvName(String rvName) {
		this.rvName = rvName;
	}
	public String getRvContent() {
		return rvContent;
	}
	public void setRvContent(String rvContent) {
		this.rvContent = rvContent;
	}
	public int getRvScores() {
		return rvScores;
	}
	public void setRvScores(int rvScores) {
		this.rvScores = rvScores;
	}
	public String getSzSeq() {
		return szSeq;
	}
	public void setSzSeq(String szSeq) {
		this.szSeq = szSeq;
	}
	public String getSzCode() {
		return szCode;
	}
	public void setSzCode(String szCode) {
		this.szCode = szCode;
	}
	public int getSzStock() {
		return szStock;
	}
	public void setSzStock(int szStock) {
		this.szStock = szStock;
	}
	public String getSzpdSeq() {
		return szpdSeq;
	}
	public void setSzpdSeq(String szpdSeq) {
		this.szpdSeq = szpdSeq;
	}
	public String getClSeq() {
		return clSeq;
	}
	public void setClSeq(String clSeq) {
		this.clSeq = clSeq;
	}
	public String getClCode() {
		return clCode;
	}
	public void setClCode(String clCode) {
		this.clCode = clCode;
	}
	public int getClStock() {
		return clStock;
	}
	public void setClStock(int clStock) {
		this.clStock = clStock;
	}
	public String getClpdSeq() {
		return clpdSeq;
	}
	public void setClpdSeq(String clpdSeq) {
		this.clpdSeq = clpdSeq;
	}
	public int getPdpmQuantity() {
		return PdpmQuantity;
	}
	public void setPdpmQuantity(int pdpmQuantity) {
		PdpmQuantity = pdpmQuantity;
	}
	public String getMbName() {
		return mbName;
	}
	public void setMbName(String mbName) {
		this.mbName = mbName;
	}
	public String getMbSeq() {
		return mbSeq;
	}
	public void setMbSeq(String mbSeq) {
		this.mbSeq = mbSeq;
	}
	public String getIbuType() {
		return ibuType;
	}
	public void setIbuType(String ibuType) {
		this.ibuType = ibuType;
	}
	public String getIbuCategory() {
		return ibuCategory;
	}
	public void setIbuCategory(String ibuCategory) {
		this.ibuCategory = ibuCategory;
	}
	public Integer getIbuDefaultNy() {
		return ibuDefaultNy;
	}
	public void setIbuDefaultNy(Integer ibuDefaultNy) {
		this.ibuDefaultNy = ibuDefaultNy;
	}
	public String getIbuPath() {
		return ibuPath;
	}
	public void setIbuPath(String ibuPath) {
		this.ibuPath = ibuPath;
	}
	public String getIbuOriginalName() {
		return ibuOriginalName;
	}
	public void setIbuOriginalName(String ibuOriginalName) {
		this.ibuOriginalName = ibuOriginalName;
	}
	public String getIbuUuidName() {
		return ibuUuidName;
	}
	public void setIbuUuidName(String ibuUuidName) {
		this.ibuUuidName = ibuUuidName;
	}
	public String getIbuExt() {
		return ibuExt;
	}
	public void setIbuExt(String ibuExt) {
		this.ibuExt = ibuExt;
	}
	public int getIbuSize() {
		return ibuSize;
	}
	public void setIbuSize(int ibuSize) {
		this.ibuSize = ibuSize;
	}
	public Integer getIbuDelNy() {
		return ibuDelNy;
	}
	public void setIbuDelNy(Integer ibuDelNy) {
		this.ibuDelNy = ibuDelNy;
	}
	public Date getIbuRegDateTime() {
		return ibuRegDateTime;
	}
	public void setIbuRegDateTime(Date ibuRegDateTime) {
		this.ibuRegDateTime = ibuRegDateTime;
	}
	public MultipartFile[] getUploadFiles() {
		return uploadFiles;
	}
	public void setUploadFiles(MultipartFile[] uploadFiles) {
		this.uploadFiles = uploadFiles;
	}
	
	
	
	

	
}
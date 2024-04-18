package com.blackpink.infra.user.product;

import java.util.Date;

public class ProductDto {

//	제품
	private String pdSeq;
	private int pdCode;
	private String pdName;
	private int pdPrice;
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
	private String mbSeq;
	
	public String getPdSeq() {
		return pdSeq;
	}
	
	public void setPdSeq(String pdSeq) {
		this.pdSeq = pdSeq;
	}
	
	public int getPdCode() {
		return pdCode;
	}
	
	public void setPdCode(int pdCode) {
		this.pdCode = pdCode;
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
	
	public String getMbSeq() {
		return mbSeq;
	}

	public void setMbSeq(String mbSeq) {
		this.mbSeq = mbSeq;
	}

	
}
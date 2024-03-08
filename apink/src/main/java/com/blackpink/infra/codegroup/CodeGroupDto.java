package com.blackpink.infra.codegroup;

import java.util.Date;

public class CodeGroupDto {

	private String seq;
	private String codeType;
	private Integer deleteNy;
	private Date registration;
	private Date correction;
	
	private Integer xseqCount;

	
	
	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public Integer getDeleteNy() {
		return deleteNy;
	}

	public void setDeleteNy(Integer deleteNy) {
		this.deleteNy = deleteNy;
	}

	public Date getRegistration() {
		return registration;
	}

	public void setRegistration(Date registration) {
		this.registration = registration;
	}

	public Date getCorrection() {
		return correction;
	}

	public void setCorrection(Date correction) {
		this.correction = correction;
	}

	public Integer getXseqCount() {
		return xseqCount;
	}

	public void setXseqCount(Integer xseqCount) {
		this.xseqCount = xseqCount;
	}
	
	
	
}

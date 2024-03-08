package com.blackpink.infra.code;

import java.util.Date;

public class CodeDto {
	
	private String groupseq;
	private String codeType;
	private String seq;
	private String codeName;
	private Integer deleteNy;
	private Date registration;
	private Date correction;
	private int codeGroup_seq;
	
	
	public String getGroupseq() {
		return groupseq;
	}
	public void setGroupseq(String groupseq) {
		this.groupseq = groupseq;
	}
	public String getCodeType() {
		return codeType;
	}
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getCodeName() {
		return codeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
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
	public int getCodeGroup_seq() {
		return codeGroup_seq;
	}
	public void setCodeGroup_seq(int codeGroup_seq) {
		this.codeGroup_seq = codeGroup_seq;
	}
	
}	

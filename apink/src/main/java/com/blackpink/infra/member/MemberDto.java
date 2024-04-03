package com.blackpink.infra.member;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberDto {

	private String mbSeq;
	private String mbName;
	private Date mbDateBirth;
	private Integer mbGender;
	private String mbEmail;
	private String mbPassword;
	private String mbPhoneNumber;
	private Integer mbDeleteNy;
	private Date mbCreationDate;
	private Date mbModificationDate;
	
	private Integer xseqCount;

	private String passwordCheck;
	
//	for cache
	public static List<MemberDto> cachedCodeArrayList = new ArrayList<MemberDto>();	
	
	

	public String getMbSeq() {
		return mbSeq;
	}

	public void setMbSeq(String mbSeq) {
		this.mbSeq = mbSeq;
	}

	public String getMbName() {
		return mbName;
	}

	public void setMbName(String mbName) {
		this.mbName = mbName;
	}

	public Date getMbDateBirth() {
		return mbDateBirth;
	}

	public void setMbDateBirth(Date mbDateBirth) {
		this.mbDateBirth = mbDateBirth;
	}

	public Integer getMbGender() {
		return mbGender;
	}

	public void setMbGender(Integer mbGender) {
		this.mbGender = mbGender;
	}

	public String getMbEmail() {
		return mbEmail;
	}

	public void setMbEmail(String mbEmail) {
		this.mbEmail = mbEmail;
	}

	public String getMbPassword() {
		return mbPassword;
	}

	public void setMbPassword(String mbPassword) {
		this.mbPassword = mbPassword;
	}

	public String getMbPhoneNumber() {
		return mbPhoneNumber;
	}

	public void setMbPhoneNumber(String mbPhoneNumber) {
		this.mbPhoneNumber = mbPhoneNumber;
	}

	public Integer getMbDeleteNy() {
		return mbDeleteNy;
	}

	public void setMbDeleteNy(Integer mbDeleteNy) {
		this.mbDeleteNy = mbDeleteNy;
	}

	public Date getMbCreationDate() {
		return mbCreationDate;
	}

	public void setMbCreationDate(Date mbCreationDate) {
		this.mbCreationDate = mbCreationDate;
	}

	public Date getMbModificationDate() {
		return mbModificationDate;
	}

	public void setMbModificationDate(Date mbModificationDate) {
		this.mbModificationDate = mbModificationDate;
	}

	public Integer getXseqCount() {
		return xseqCount;
	}

	public void setXseqCount(Integer xseqCount) {
		this.xseqCount = xseqCount;
	}

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

	@Override
	public String toString() {
		return "MemberDto [mbSeq=" + mbSeq + ", mbName=" + mbName + ", mbDateBirth=" + mbDateBirth + ", mbGender="
				+ mbGender + ", mbEmail=" + mbEmail + ", mbPassword=" + mbPassword + ", mbPhoneNumber=" + mbPhoneNumber
				+ ", mbDeleteNy=" + mbDeleteNy + ", mbCreationDate=" + mbCreationDate + ", mbModificationDate="
				+ mbModificationDate + ", xseqCount=" + xseqCount + ", passwordCheck=" + passwordCheck + "]";
	}

	
}

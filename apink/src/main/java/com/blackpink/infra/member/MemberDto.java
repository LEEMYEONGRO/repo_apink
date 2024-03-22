package com.blackpink.infra.member;

import java.util.Date;

public class MemberDto {

	private String seq;
	private String name;
	private Date dateBirth;
	private Integer gender;
	private String email;
	private String password;
	private String phoneNumber;
	private Integer deleteNy;
	private Date creationDate;
	private Date modificationDate;
	
	private Integer xseqCount;

	
	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getDeleteNy() {
		return deleteNy;
	}

	public void setDeleteNy(Integer deleteNy) {
		this.deleteNy = deleteNy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	public Integer getXseqCount() {
		return xseqCount;
	}

	public void setXseqCount(Integer xseqCount) {
		this.xseqCount = xseqCount;
	}

	
	
	
	


	
	
	
	
}

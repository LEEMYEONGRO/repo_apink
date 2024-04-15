package com.blackpink.infra.payment;

import java.util.Date;

public class PaymentDto {
	
	private String memberSeq;
	private String paymentSeq;
	private Date pmCreationDate;
	private int pmDeliveryStatus;
	private String mbSeq;
	private String pmSeq;
	private String pdSeq;
	private String productSeq;
	private String pdName;
	private int pdPrice;
	
	private String mbName;
	private Date mbDateBirth;
	private String mbGender;
	private String mbEmail;
	private String mbPassword;
	private String mbPhoneNumber;
	
	private String passwordCheck;
	private String newmbPassword;
	
	public String getMemberSeq() {
		return memberSeq;
	}
	public void setMemberSeq(String memberSeq) {
		this.memberSeq = memberSeq;
	}
	
	public String getPaymentSeq() {
		return paymentSeq;
	}
	
	public void setPaymentSeq(String paymentSeq) {
		this.paymentSeq = paymentSeq;
	}
	
	public Date getPmCreationDate() {
		return pmCreationDate;
	}
	
	public void setPmCreationDate(Date pmCreationDate) {
		this.pmCreationDate = pmCreationDate;
	}
	
	public int getPmDeliveryStatus() {
		return pmDeliveryStatus;
	}
	
	public void setPmDeliveryStatus(int pmDeliveryStatus) {
		this.pmDeliveryStatus = pmDeliveryStatus;
	}
	
	public String getMbSeq() {
		return mbSeq;
	}
	
	public void setMbSeq(String mbSeq) {
		this.mbSeq = mbSeq;
	}
	
	public String getPmSeq() {
		return pmSeq;
	}
	
	public void setPmSeq(String pmSeq) {
		this.pmSeq = pmSeq;
	}
	
	public String getPdSeq() {
		return pdSeq;
	}
	
	public void setPdSeq(String pdSeq) {
		this.pdSeq = pdSeq;
	}
	
	public String getProductSeq() {
		return productSeq;
	}
	
	public void setProductSeq(String productSeq) {
		this.productSeq = productSeq;
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
	
	public String getMbGender() {
		return mbGender;
	}
	
	public void setMbGender(String mbGender) {
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
	
	public String getNewmbPassword() {
		return newmbPassword;
		
	}
	public void setNewmbPassword(String newmbPassword) {
		this.newmbPassword = newmbPassword;
	}
	
	public String getPasswordCheck() {
		return passwordCheck;
	}
	
	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}
	
	
	
	
	
	
	
	
	
}

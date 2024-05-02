package com.blackpink.infra.payment;

import java.util.Date;

public class PaymentDto {
	
	private String memberSeq;
	private String paymentSeq;
	private int pdpmDeliveryStatus;
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
	
//	address
	private String arSeq;					// 주소Seq
	private String arName;					// 주소지명
	private String arUserName;				// 주소 거주자이름
	private String arPhoneNumber;			// 주소 거주자휴대폰번호
	private String arPostalCode;			// 우편번호
	private String arNumberAddress;			// 기본주소
	private String arRoadNameAddress;		// 도로명주소
	private String arDetailAddress;			// 상세주소
	private String addressSeq;
//	address
	
//	payment
	private String pmCardCode;				//카드사명
	private String pmPayerName;				//카드사용자명
	private String pmCardNumber;			//카드번호
	private Date pmCardMonth;				//카드유효기간 월
	private Date pmCardYear;				//카드유효기간 연도
	private int pmCardVerificationCode;		//카드인증번호
	private Integer pmDeleteNy;
	private Date pmCreationDate;
	private Date pmModificationDate;
//	payment
	
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
	
	public int getPdpmDeliveryStatus() {
		return pdpmDeliveryStatus;
	}
	
	public void setPdpmDeliveryStatus(int pdpmDeliveryStatus) {
		this.pdpmDeliveryStatus = pdpmDeliveryStatus;
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
	
	public String getArSeq() {
		return arSeq;
	}
	
	public void setArSeq(String arSeq) {
		this.arSeq = arSeq;
	}
	
	public String getArName() {
		return arName;
	}
	
	public void setArName(String arName) {
		this.arName = arName;
	}
	
	public String getArUserName() {
		return arUserName;
	}
	
	public void setArUserName(String arUserName) {
		this.arUserName = arUserName;
	}
	
	public String getArPhoneNumber() {
		return arPhoneNumber;
	}
	
	public void setArPhoneNumber(String arPhoneNumber) {
		this.arPhoneNumber = arPhoneNumber;
	}
	
	public String getArPostalCode() {
		return arPostalCode;
	}
	
	public void setArPostalCode(String arPostalCode) {
		this.arPostalCode = arPostalCode;
	}
	
	public String getArNumberAddress() {
		return arNumberAddress;
	}
	
	public void setArNumberAddress(String arNumberAddress) {
		this.arNumberAddress = arNumberAddress;
	}
	
	public String getArRoadNameAddress() {
		return arRoadNameAddress;
	}
	
	public void setArRoadNameAddress(String arRoadNameAddress) {
		this.arRoadNameAddress = arRoadNameAddress;
	}
	
	public String getArDetailAddress() {
		return arDetailAddress;
	}
	
	public void setArDetailAddress(String arDetailAddress) {
		this.arDetailAddress = arDetailAddress;
	}
	
	public String getAddressSeq() {
		return addressSeq;
	}
	
	public void setAddressSeq(String addressSeq) {
		this.addressSeq = addressSeq;
	}
	public String getPmCardCode() {
		return pmCardCode;
	}
	public void setPmCardCode(String pmCardCode) {
		this.pmCardCode = pmCardCode;
	}
	public String getPmPayerName() {
		return pmPayerName;
	}
	public void setPmPayerName(String pmPayerName) {
		this.pmPayerName = pmPayerName;
	}
	public String getPmCardNumber() {
		return pmCardNumber;
	}
	public void setPmCardNumber(String pmCardNumber) {
		this.pmCardNumber = pmCardNumber;
	}
	public Date getPmCardMonth() {
		return pmCardMonth;
	}
	public void setPmCardMonth(Date pmCardMonth) {
		this.pmCardMonth = pmCardMonth;
	}
	public Date getPmCardYear() {
		return pmCardYear;
	}
	public void setPmCardYear(Date pmCardYear) {
		this.pmCardYear = pmCardYear;
	}
	public int getPmCardVerificationCode() {
		return pmCardVerificationCode;
	}
	public void setPmCardVerificationCode(int pmCardVerificationCode) {
		this.pmCardVerificationCode = pmCardVerificationCode;
	}
	public Integer getPmDeleteNy() {
		return pmDeleteNy;
	}
	public void setPmDeleteNy(Integer pmDeleteNy) {
		this.pmDeleteNy = pmDeleteNy;
	}
	public Date getPmModificationDate() {
		return pmModificationDate;
	}
	public void setPmModificationDate(Date pmModificationDate) {
		this.pmModificationDate = pmModificationDate;
	}
	
	
	
}

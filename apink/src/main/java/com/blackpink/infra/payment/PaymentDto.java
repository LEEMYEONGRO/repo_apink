package com.blackpink.infra.payment;

import java.util.Date;

public class PaymentDto {
	
	private String pmSeq;
	private Date pmCreationDate;
	private String mbSeq;
	private String pdSeq;
	private String pdName;
	private int pdDeliveryStatus;
	private int pdPrice;
	
	
	public String getPmSeq() {
		return pmSeq;
	}
	public void setPmSeq(String pmSeq) {
		this.pmSeq = pmSeq;
	}
	public Date getPmCreationDate() {
		return pmCreationDate;
	}
	public void setPmCreationDate(Date pmCreationDate) {
		this.pmCreationDate = pmCreationDate;
	}
	public String getMbSeq() {
		return mbSeq;
	}
	public void setMbSeq(String mbSeq) {
		this.mbSeq = mbSeq;
	}
	public String getPdSeq() {
		return pdSeq;
	}
	public void setPdSeq(String pdSeq) {
		this.pdSeq = pdSeq;
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
	public int getPdDeliveryStatus() {
		return pdDeliveryStatus;
	}
	public void setPdDeliveryStatus(int pdDeliveryStatus) {
		this.pdDeliveryStatus = pdDeliveryStatus;
	}
	
	
	
}

package com.blackpink.infra.address;

import java.util.Date;

public class AddressDto {

	private String arSeq;
	private String arName;
	private String arUserName;
	private String arPhoneNumber;
	private int arPostalCode;
	private String arNumberAddress;
	private String arRoadNameAddress;
	private String arDetailAddress;
	private String arSeeAlso;
	private int arLatitude;
	private int arLongitude;
	private Integer arDeleteNy;
	private Date arCreationDate;
	private Date arModificationDate;
	private String mbSeq;
	
	public String getArSeq() {
		return arSeq;
	}
	
	public String getArName() {
		return arName;
	}

	public void setArName(String arName) {
		this.arName = arName;
	}

	public void setArSeq(String arSeq) {
		this.arSeq = arSeq;
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
	
	public int getArPostalCode() {
		return arPostalCode;
	}
	
	public void setArPostalCode(int arPostalCode) {
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
	
	public String getArSeeAlso() {
		return arSeeAlso;
	}
	
	public void setArSeeAlso(String arSeeAlso) {
		this.arSeeAlso = arSeeAlso;
	}
	
	public int getArLatitude() {
		return arLatitude;
	}
	
	public void setArLatitude(int arLatitude) {
		this.arLatitude = arLatitude;
	}
	
	public int getArLongitude() {
		return arLongitude;
	}
	
	public void setArLongitude(int arLongitude) {
		this.arLongitude = arLongitude;
	}
	
	public Integer getArDeleteNy() {
		return arDeleteNy;
	}
	
	public void setArDeleteNy(Integer arDeleteNy) {
		this.arDeleteNy = arDeleteNy;
	}
	
	public Date getArCreationDate() {
		return arCreationDate;
	}
	
	public void setArCreationDate(Date arCreationDate) {
		this.arCreationDate = arCreationDate;
	}
	
	public Date getArModificationDate() {
		return arModificationDate;
	}
	
	public void setArModificationDate(Date arModificationDate) {
		this.arModificationDate = arModificationDate;
	}
	
	public String getMbSeq() {
		return mbSeq;
	}
	
	public void setMbSeq(String mbSeq) {
		this.mbSeq = mbSeq;
	}
	
}

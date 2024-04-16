package com.blackpink.infra.payment;

import com.blackpink.common.base.BaseVo;

public class PaymentVo extends BaseVo {

	private Integer shDelNy = 0; 								/* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
	private Integer shOptionDate = 1;							/* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
	private String shDateStart;
	private String shDateEnd;
	private Integer shOption;									/* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
	private String ShValue;
	private String mbSeq;
	
	private String mbPassword;
	private String newmbPassword;
	
	public Integer getShDelNy() {
		return shDelNy;
	}
	public void setShDelNy(Integer shDelNy) {
		this.shDelNy = shDelNy;
	}
	public Integer getShOptionDate() {
		return shOptionDate;
	}
	public void setShOptionDate(Integer shOptionDate) {
		this.shOptionDate = shOptionDate;
	}
	public String getShDateStart() {
		return shDateStart;
	}
	public void setShDateStart(String shDateStart) {
		this.shDateStart = shDateStart;
	}
	public String getShDateEnd() {
		return shDateEnd;
	}
	public void setShDateEnd(String shDateEnd) {
		this.shDateEnd = shDateEnd;
	}
	public Integer getShOption() {
		return shOption;
	}
	public void setShOption(Integer shOption) {
		this.shOption = shOption;
	}
	public String getShValue() {
		return ShValue;
	}
	public void setShValue(String shValue) {
		ShValue = shValue;
	}
	
	public String getMbSeq() {
		return mbSeq;
	}
	public void setMbSeq(String mbSeq) {
		this.mbSeq = mbSeq;
	}
	
	public String getMbPassword() {
		return mbPassword;
	}
	
	public void setMbPassword(String mbPassword) {
		this.mbPassword = mbPassword;
	}
	
	public String getNewmbPassword() {
		return newmbPassword;
	}
	
	public void setNewmbPassword(String newmbPassword) {
		this.newmbPassword = newmbPassword;
	}
	
	
	
	
}

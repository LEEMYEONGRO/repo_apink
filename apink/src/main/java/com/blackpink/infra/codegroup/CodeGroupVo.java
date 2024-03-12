package com.blackpink.infra.codegroup;

public class CodeGroupVo {

	private Integer shDelNy = 0; /* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
	private Integer shOptionDate = 2; /* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
	private String shDateStart;
	private String shDateEnd;
	private Integer shOption; /* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
	private String ShValue;

	/* private String seq; */

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

	/*
	 * public String getSeq() { return seq; }
	 * 
	 * public void setSeq(String seq) { this.seq = seq; }
	 */

}

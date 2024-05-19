package com.blackpink.infra.user.product;

import java.util.List;

import com.blackpink.common.base.BaseVo;

public class ProductVo extends BaseVo {

	private Integer shDelNy = 0; /* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
	private Integer shOptionDate = 1; /* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
	private String shDateStart;
	private String shDateEnd;
	private Integer shOption; /* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
	private String ShValue;
	private String mbSeq;

//	카테고리
	private List<String> category;
	private List<String> color;
	private List<String> size;
	private List<String> gender;
	
	
	private List<ProductVo> list;


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


	public List<String> getCategory() {
		return category;
	}


	public void setCategory(List<String> category) {
		this.category = category;
	}


	public List<String> getColor() {
		return color;
	}


	public void setColor(List<String> color) {
		this.color = color;
	}


	public List<String> getSize() {
		return size;
	}


	public void setSize(List<String> size) {
		this.size = size;
	}


	public List<String> getGender() {
		return gender;
	}


	public void setGender(List<String> gender) {
		this.gender = gender;
	}


	public List<ProductVo> getList() {
		return list;
	}


	public void setList(List<ProductVo> list) {
		this.list = list;
	}
	
	
	
}

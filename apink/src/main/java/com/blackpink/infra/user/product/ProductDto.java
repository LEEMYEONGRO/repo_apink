package com.blackpink.infra.user.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductDto {

//	제품
	private String pdSeq;
	private int pdCode;
	private String pdName;
	private int pdPrice;
	private Integer pdlikeNy;
	private Integer pdDeleteNy;
	private Date pdCreationDate;
	private Date pdModificationDate;
//	제품

//	for cache
	public static List<ProductDto> cachedCodeArrayList = new ArrayList<ProductDto>();
	
	public String getPdSeq() {
		return pdSeq;
	}
	
	public void setPdSeq(String pdSeq) {
		this.pdSeq = pdSeq;
	}
	
	public int getPdCode() {
		return pdCode;
	}
	
	public void setPdCode(int pdCode) {
		this.pdCode = pdCode;
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
	
	public Integer getPdlikeNy() {
		return pdlikeNy;
	}
	
	public void setPdlikeNy(Integer pdlikeNy) {
		this.pdlikeNy = pdlikeNy;
	}
	
	public Integer getPdDeleteNy() {
		return pdDeleteNy;
	}
	
	public void setPdDeleteNy(Integer pdDeleteNy) {
		this.pdDeleteNy = pdDeleteNy;
	}
	
	public Date getPdCreationDate() {
		return pdCreationDate;
	}
	
	public void setPdCreationDate(Date pdCreationDate) {
		this.pdCreationDate = pdCreationDate;
	}
	
	public Date getPdModificationDate() {
		return pdModificationDate;
	}
	
	public void setPdModificationDate(Date pdModificationDate) {
		this.pdModificationDate = pdModificationDate;
	}

	@Override
	public String toString() {
		return "ProductDto [pdSeq=" + pdSeq + ", pdCode=" + pdCode + ", pdName=" + pdName + ", pdPrice=" + pdPrice
				+ ", pdlikeNy=" + pdlikeNy + ", pdDeleteNy=" + pdDeleteNy + ", pdCreationDate=" + pdCreationDate
				+ ", pdModificationDate=" + pdModificationDate + "]";
	}
	
	
	


	
	
	
	
	
	
}
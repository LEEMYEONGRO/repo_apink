package com.blackpink.infra.codegroup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CodeGroupDto {

	private String cgSeq;
	private String cgName;
	private Integer cgDeleteNy;
	private Date cgCreationDate;
	private Date cgModificationDate;
	
//	for cache
	public static List<CodeGroupDto> cachedCodeArrayList = new ArrayList<CodeGroupDto>();

	public String getCgSeq() {
		return cgSeq;
	}

	public void setCgSeq(String cgSeq) {
		this.cgSeq = cgSeq;
	}

	public String getCgName() {
		return cgName;
	}

	public void setCgName(String cgName) {
		this.cgName = cgName;
	}

	public Integer getCgDeleteNy() {
		return cgDeleteNy;
	}

	public void setCgDeleteNy(Integer cgDeleteNy) {
		this.cgDeleteNy = cgDeleteNy;
	}

	public Date getCgCreationDate() {
		return cgCreationDate;
	}

	public void setCgCreationDate(Date cgCreationDate) {
		this.cgCreationDate = cgCreationDate;
	}

	public Date getCgModificationDate() {
		return cgModificationDate;
	}

	public void setCgModificationDate(Date cgModificationDate) {
		this.cgModificationDate = cgModificationDate;
	}

	@Override
	public String toString() {
		return "CodeGroupDto [cgSeq=" + cgSeq + ", cgName=" + cgName + ", cgDeleteNy=" + cgDeleteNy
				+ ", cgCreationDate=" + cgCreationDate + ", cgModificationDate=" + cgModificationDate + "]";
	}
	
	
}

package com.blackpink.infra.code;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CodeDto {
	
	private String groupseq;
	private String cgName;
	
	private String cdSeq;
	private String cdName;
	private Integer cdDeleteNy;
	private Date cdCreationDate;
	private Date cdModificationDate;
	private String cgSeq;
	
//	for cache
	public static List<CodeDto> cachedCodeArrayList = new ArrayList<CodeDto>();
	
	public String getGroupseq() {
		return groupseq;
	}
	public void setGroupseq(String groupseq) {
		this.groupseq = groupseq;
	}
	public String getCgName() {
		return cgName;
	}
	public void setCgName(String cgName) {
		this.cgName = cgName;
	}
	public String getCdSeq() {
		return cdSeq;
	}
	public void setCdSeq(String cdSeq) {
		this.cdSeq = cdSeq;
	}
	public String getCdName() {
		return cdName;
	}
	public void setCdName(String cdName) {
		this.cdName = cdName;
	}
	public Integer getCdDeleteNy() {
		return cdDeleteNy;
	}
	public void setCdDeleteNy(Integer cdDeleteNy) {
		this.cdDeleteNy = cdDeleteNy;
	}
	public Date getCdCreationDate() {
		return cdCreationDate;
	}
	public void setCdCreationDate(Date cdCreationDate) {
		this.cdCreationDate = cdCreationDate;
	}
	public Date getCdModificationDate() {
		return cdModificationDate;
	}
	public void setCdModificationDate(Date cdModificationDate) {
		this.cdModificationDate = cdModificationDate;
	}
	public String getCgSeq() {
		return cgSeq;
	}
	public void setCgSeq(String cgSeq) {
		this.cgSeq = cgSeq;
	}
	
	@Override
	public String toString() {
		return "CodeDto [groupseq=" + groupseq + ", cgName=" + cgName + ", cdSeq=" + cdSeq + ", cdName=" + cdName
				+ ", cdDeleteNy=" + cdDeleteNy + ", cdCreationDate=" + cdCreationDate + ", cdModificationDate="
				+ cdModificationDate + ", cgSeq=" + cgSeq + "]";
	}
	

	
	
	
	
	
}
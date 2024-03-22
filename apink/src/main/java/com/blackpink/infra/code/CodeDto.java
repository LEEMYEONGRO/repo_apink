package com.blackpink.infra.code;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CodeDto {
	
	private String groupseq;
	private String codeGroupName;
	private String seq;
	private String codeName;
	private Integer deleteNy;
	private Date creationDate;
	private Date modificationDate;
	private String codeGroup_seq;
	
//	for cache
	public static List<CodeDto> cachedCodeArrayList = new ArrayList<CodeDto>();	
	
	
	
	public String getGroupseq() {
		return groupseq;
	}



	public void setGroupseq(String groupseq) {
		this.groupseq = groupseq;
	}



	public String getCodeGroupName() {
		return codeGroupName;
	}



	public void setCodeGroupName(String codeGroupName) {
		this.codeGroupName = codeGroupName;
	}



	public String getSeq() {
		return seq;
	}



	public void setSeq(String seq) {
		this.seq = seq;
	}



	public String getCodeName() {
		return codeName;
	}



	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}



	public Integer getDeleteNy() {
		return deleteNy;
	}



	public void setDeleteNy(Integer deleteNy) {
		this.deleteNy = deleteNy;
	}



	public Date getCreationDate() {
		return creationDate;
	}



	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}



	public Date getModificationDate() {
		return modificationDate;
	}



	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}



	public String getCodeGroup_seq() {
		return codeGroup_seq;
	}



	public void setCodeGroup_seq(String codeGroup_seq) {
		this.codeGroup_seq = codeGroup_seq;
	}



	public static List<CodeDto> getCachedCodeArrayList() {
		return cachedCodeArrayList;
	}


	public static void setCachedCodeArrayList(List<CodeDto> cachedCodeArrayList) {
		CodeDto.cachedCodeArrayList = cachedCodeArrayList;
	}


	@Override
	public String toString() {
		return "CodeDto [groupseq=" + groupseq + ", codeGroupName=" + codeGroupName + ", seq=" + seq + ", codeName="
				+ codeName + ", deleteNy=" + deleteNy + ", creationDate=" + creationDate + ", modificationDate="
				+ modificationDate + ", codeGroup_seq=" + codeGroup_seq + "]";
	}



	
	
}	

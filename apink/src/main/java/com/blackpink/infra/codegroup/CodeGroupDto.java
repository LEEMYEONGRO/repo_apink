package com.blackpink.infra.codegroup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CodeGroupDto {

	private String seq;
	private String codeGroupName;
	private Integer deleteNy;
	private Date creationDate;
	private Date modificationDate;
	
	private Integer xseqCount;

	
//	for cache
	public static List<CodeGroupDto> cachedCodeArrayList = new ArrayList<CodeGroupDto>();
	
	
	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getCodeGroupName() {
		return codeGroupName;
	}

	public void setCodeGroupName(String codeGroupName) {
		this.codeGroupName = codeGroupName;
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

	public Integer getXseqCount() {
		return xseqCount;
	}

	public void setXseqCount(Integer xseqCount) {
		this.xseqCount = xseqCount;
	}

	@Override
	public String toString() {
		return "CodeGroupDto [seq=" + seq + ", codeGroupName=" + codeGroupName + ", deleteNy=" + deleteNy
				+ ", creationDate=" + creationDate + ", modificationDate=" + modificationDate + ", xseqCount="
				+ xseqCount + "]";
	}

	
	
	
	
}

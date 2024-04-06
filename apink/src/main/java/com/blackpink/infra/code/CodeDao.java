package com.blackpink.infra.code;

import java.util.List;

public interface CodeDao {
	
	public List<CodeDto> selectList(CodeVo vo);
	
	public int selectOneCount(CodeVo vo);
	
	public CodeDto selectOne(CodeDto dto);
	
	public int insert(CodeDto dto);
	
	public int update(CodeDto dto);
	
	public int updateDeleteNy(CodeDto dto);
	
	public int delete(CodeDto dto);
	
	public List<CodeDto> selectListCachedCodeArrayList();
}
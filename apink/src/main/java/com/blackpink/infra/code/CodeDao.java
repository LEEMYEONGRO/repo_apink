package com.blackpink.infra.code;

import java.util.List;

import com.blackpink.infra.codegroup.CodeGroupVo;

public interface CodeDao {

	public List<CodeDto> selectList(CodeVo vo);
	
	public CodeDto selectOne(CodeDto dto);
	
	public int insert(CodeDto dto);
	
	public int update(CodeDto dto);
	
	public int deleteNyUpdate(CodeDto dto);
	
	public int codeDelete(CodeDto dto);
	
	public List<CodeDto> selectListCachedCodeArrayList();
	
	public int selectOneCount(CodeVo vo);
	
}

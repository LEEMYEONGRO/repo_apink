package com.blackpink.infra.code;

import java.util.List;

public interface CodeDao {

	public List<CodeDto> selectList();
	
	public CodeDto selectOne(CodeDto dto);
	
	public int insert(CodeDto dto);
	
	public int update(CodeDto dto);
	
	public int deleteNyUpdate(CodeDto dto);
	
	public int codeDelete(CodeDto dto);
}

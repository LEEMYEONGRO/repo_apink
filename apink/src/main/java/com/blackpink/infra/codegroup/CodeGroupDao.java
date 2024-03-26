package com.blackpink.infra.codegroup;

import java.util.List;

public interface CodeGroupDao {
	
	public List<CodeGroupDto> selectList(); // 관례적으로 목록을 가져오는 함수 이름은 selectList를 주로 사용.
	
	
	public CodeGroupDto selectOne(CodeGroupDto dto); // 데이터 하나만 리턴함 

	public int insert(CodeGroupDto dto);
	
	public int update(CodeGroupDto dto);
	
	public int updateDeleteNy(CodeGroupDto dto);
	
	public int delete(CodeGroupDto dto);
	
	public List<CodeGroupDto> selectList(CodeGroupVo vo);
	
	public List<CodeGroupDto> selectListWithoutPaging();
	
	
	public int selectOneCount(CodeGroupVo vo);
	

}

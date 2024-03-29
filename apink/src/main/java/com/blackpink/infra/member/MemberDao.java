package com.blackpink.infra.member;

import java.util.List;

public interface MemberDao {
	
	public List<MemberDto> selectList();
	
	public MemberDto selectOne(MemberDto dto); 

	public MemberDto login(MemberDto dto);
	
	public int insert(MemberDto dto);
	
	public int update(MemberDto dto);
	
	public int updateDeleteNy(MemberDto dto);
	
	public int delete(MemberDto dto);
	
	public List<MemberDto> selectList(MemberVo vo);

}

package com.blackpink.infra.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	MemberDao dao;

	
	public List<MemberDto> selectList(MemberVo vo){ return dao.selectList(vo);}

	
	public MemberDto selectOne(MemberDto dto) {
		 return dao.selectOne(dto);
		
	}
	
	public MemberDto login(MemberDto dto) {
		return dao.login(dto);
	}
	
	public int insert(MemberDto dto) {
		return dao.insert(dto);
	}
	
	public int update(MemberDto dto) {
		return dao.update(dto);
	}
	
	public int updateDeleteNy(MemberDto dto) {
		return dao.updateDeleteNy(dto);
	}
	
	public int delete(MemberDto dto) {
		return dao.delete(dto);
	}
	

}

package com.blackpink.infra.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeGroupService {
	
	@Autowired
	CodeGroupDao dao;
	
	public List<CodeGroupDto> selectList(CodeGroupVo vo){
		return dao.selectList(vo);
	}
	
	public CodeGroupDto selectOne(CodeGroupDto dto) {
		return dao.selectOne(dto);
	}
	
	public int insert(CodeGroupDto dto) {
		return dao.insert(dto);
	}
	
	public int insertExsel(CodeGroupDto dto) {
		return dao.insertExsel(dto);
	}
	
	public int update(CodeGroupDto dto) {
		return dao.update(dto);
	}
	
	public int updateDeleteNy(CodeGroupDto dto) {
		return dao.updateDeleteNy(dto);
	}
	
	public int delete(CodeGroupDto dto) {
		return dao.delete(dto);
	}
	
	public List<CodeGroupDto>selectListWithoutPaging(){
		return dao.selectListWithoutPaging();
	}
	
	public int selectOneCount(CodeGroupVo vo) {
		return dao.selectOneCount(vo);
	}
	
}
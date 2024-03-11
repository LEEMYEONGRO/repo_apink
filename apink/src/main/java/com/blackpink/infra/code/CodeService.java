package com.blackpink.infra.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackpink.infra.codegroup.CodeGroupDto;
import com.blackpink.infra.codegroup.CodeGroupVo;

@Service
public class CodeService {
	
	@Autowired
	CodeDao dao;
	
	public List<CodeDto> selectList(CodeVo vo){ return dao.selectList(vo);}
	
	public CodeDto selectOne(CodeDto dto) {
		return dao.selectOne(dto);
	}
	
	public int insert(CodeDto dto) {
		return dao.insert(dto);
	}
	
	public int update(CodeDto dto) {
		return dao.update(dto);
	}
	
	public int deleteNyUpdate(CodeDto dto) {
		return dao.deleteNyUpdate(dto);
	}
	
	public int codeDelete(CodeDto dto) {
		return dao.codeDelete(dto);
	}
}

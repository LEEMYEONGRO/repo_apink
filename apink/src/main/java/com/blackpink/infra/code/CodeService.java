package com.blackpink.infra.code;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class CodeService {
	
	@Autowired
	CodeDao dao;
	
	public List<CodeDto> selectList(CodeVo vo) {
		return dao.selectList(vo);
	}
	
	public int selectOneCount(CodeVo vo) {
		return dao.selectOneCount(vo);
	}
	
	public CodeDto selectOne(CodeDto dto) {
		return dao.selectOne(dto);
	}
	
	public int insert(CodeDto dto) {
		return dao.insert(dto);
	}
	
	public int update(CodeDto dto) {
		return dao.update(dto);
	}
	
	public int updateDeleteNy(CodeDto dto) {
		return dao.updateDeleteNy(dto);
	}
	
	public int delete(CodeDto dto) {
		return dao.delete(dto);
	}
	
	 @PostConstruct
		public void selectListCachedCodeArrayList() throws Exception {
			List<CodeDto> codeListFromDb = (ArrayList<CodeDto>) dao.selectListCachedCodeArrayList();
//			codeListFromDb = (ArrayList<Code>) dao.selectListCachedCodeArrayList();
			CodeDto.cachedCodeArrayList.clear(); 
			CodeDto.cachedCodeArrayList.addAll(codeListFromDb);
			System.out.println("cachedCodeArrayList: " + CodeDto.cachedCodeArrayList.size() + " chached !");
		}
}
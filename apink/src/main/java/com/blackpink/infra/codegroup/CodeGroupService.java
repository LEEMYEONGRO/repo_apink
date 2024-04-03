package com.blackpink.infra.codegroup;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackpink.infra.code.CodeDto;

import jakarta.annotation.PostConstruct;

@Service
public class CodeGroupService {
//	CodeGroupDao codeGroupDao;
	
	@Autowired
	CodeGroupDao dao;
	
	public List<CodeGroupDto> selectList(CodeGroupVo vo){
		return dao.selectList(vo);}

	public CodeGroupDto selectOne(CodeGroupDto dto) {
		return dao.selectOne(dto);
	}
	
	public int insert(CodeGroupDto dto) {
		return dao.insert(dto);
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
	
	public List<CodeGroupDto> selectListWithoutPaging() {
		return dao.selectListWithoutPaging();
	}
	
	public int selectOneCount(CodeGroupVo vo) {
		return dao.selectOneCount(vo);
	}
	
    @PostConstruct
	public void selectListCachedCodeArrayList() throws Exception {
		List<CodeGroupDto> codeListFromDb = (ArrayList<CodeGroupDto>) dao.selectListCachedCodeArrayList();
//		codeListFromDb = (ArrayList<Code>) dao.selectListCachedCodeArrayList();
		CodeGroupDto.cachedCodeArrayList.clear(); 
		CodeGroupDto.cachedCodeArrayList.addAll(codeListFromDb);
		System.out.println("cachedCodeArrayList: " + CodeGroupDto.cachedCodeArrayList.size() + " chached !");
	}
    
    public static String selectOneCachedCode(int codeGroup) throws Exception {
		String rt = "";
		for(CodeGroupDto codeGroupRow : CodeGroupDto.cachedCodeArrayList) {
			if (codeGroupRow.getCgSeq().equals(Integer.toString(codeGroup))) {
				rt = codeGroupRow.getCgName();
			} else {
				// by pass
			}
		}
		return rt;
	}
    
    public static List<CodeGroupDto> selectListCachedCode(String seq) throws Exception {
		List<CodeGroupDto> rt = new ArrayList<CodeGroupDto>();
		for(CodeGroupDto codeGroupRow : CodeGroupDto.cachedCodeArrayList) {
			if (codeGroupRow.getCgSeq().equals(seq)) {
				rt.add(codeGroupRow);
			} else {
				// by pass
			}
		}
		return rt;
	}
    

}

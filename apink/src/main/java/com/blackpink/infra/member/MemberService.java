package com.blackpink.infra.member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class MemberService {
	
	@Autowired
	MemberDao dao;

	
	public List<MemberDto> selectList(MemberVo vo){
		return dao.selectList(vo);}

	
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
	
	public List<MemberDto> selectListWithoutPaging() {
		return dao.selectListWithoutPaging();
	}
	
	public int selectOneCount(MemberVo vo) {
		return dao.selectOneCount(vo);
	}
	
    @PostConstruct
	public void selectListCachedCodeArrayList() throws Exception {
		List<MemberDto> codeListFromDb = (ArrayList<MemberDto>) dao.selectListCachedCodeArrayList();
//		codeListFromDb = (ArrayList<Code>) dao.selectListCachedCodeArrayList();
		MemberDto.cachedCodeArrayList.clear(); 
		MemberDto.cachedCodeArrayList.addAll(codeListFromDb);
		System.out.println("cachedCodeArrayList: " + MemberDto.cachedCodeArrayList.size() + " chached !");
	}
    
    public static String selectOneCachedCode(int member) throws Exception {
		String rt = "";
		for(MemberDto memberRow : MemberDto.cachedCodeArrayList) {
			if (memberRow.getMbSeq().equals(Integer.toString(member))) {
				rt = memberRow.getMbName();
			} else {
				// by pass
			}
		}
		return rt;
	}
    
    public static List<MemberDto> selectListCachedCode(String MbSeq) throws Exception {
		List<MemberDto> rt = new ArrayList<MemberDto>();
		for(MemberDto memberRow : MemberDto.cachedCodeArrayList) {
			if (memberRow.getMbSeq().equals(MbSeq)) {
				rt.add(memberRow);
			} else {
				// by pass
			}
		}
		return rt;
	}
    

	
}

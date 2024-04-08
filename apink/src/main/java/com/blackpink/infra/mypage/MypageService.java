package com.blackpink.infra.mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackpink.infra.member.MemberDto;

@Service
public class MypageService {

	@Autowired
	MypageDao dao;
	
	public MypageDto login(MypageDto dto) {
		return dao.login(dto);
	}
	
}

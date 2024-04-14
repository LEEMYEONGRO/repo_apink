package com.blackpink.infra.payment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

	@Autowired
	PaymentDao dao;
	
	public List<PaymentDto> selectList(PaymentVo vo){
		return dao.selectList(vo);
	}
	
	public PaymentDto item(PaymentVo vo) {
		return dao.item(vo);
	}
	
	public int update(PaymentDto dto) {
		return dao.update(dto);
	}
	
	public int updatePw(PaymentVo vo) {
		return dao.updatePw(vo);
	}
	
	public PaymentDto existingPassword(PaymentVo vo) {
		return dao.existingPassword(vo);
	}
	
	public int selectOneCount(PaymentVo vo) {
		return dao.selectOneCount(vo);
	}
}

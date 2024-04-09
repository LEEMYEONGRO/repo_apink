package com.blackpink.infra.payment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

	@Autowired
	PaymentDao dao;
	
	public List<PaymentDto> selectMypage(PaymentVo vo){
		return dao.selectMypage(vo);
	}
	
	public List<PaymentDto> selectList(PaymentVo vo){
		return dao.selectList(vo);
	}
	
	public PaymentDto item(PaymentVo vo) {
		return dao.item(vo);
	}
}

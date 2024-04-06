package com.blackpink.infra.payment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

	@Autowired
	PaymentDao dao;
	
	public List<PaymentDto> selectMypage(PaymentDto dto){
		return dao.selectMypage(dto);
	}
	
}

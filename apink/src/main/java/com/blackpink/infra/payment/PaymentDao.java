package com.blackpink.infra.payment;

import java.util.List;

public interface PaymentDao {
	
	public List<PaymentDto> selectMypage(PaymentVo vo);
	
	public List<PaymentDto> selectList(PaymentVo vo);
	
	public PaymentDto item(PaymentVo vo);
}

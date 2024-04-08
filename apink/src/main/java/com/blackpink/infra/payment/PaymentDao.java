package com.blackpink.infra.payment;

import java.util.List;

public interface PaymentDao {
	
	public List<PaymentDto> selectMypage(PaymentVo vo);
	
}

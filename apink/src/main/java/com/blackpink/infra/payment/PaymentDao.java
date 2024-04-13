package com.blackpink.infra.payment;

import java.util.List;

public interface PaymentDao {
	
	
	public List<PaymentDto> selectList(PaymentVo vo);
	
	public PaymentDto item(PaymentVo vo);
	
	public int update(PaymentDto dto);
	
	public int updatePw(PaymentDto dto);
	
	public PaymentDto newPassword(PaymentDto dto);
	
	public int selectOneCount(PaymentVo vo);
}

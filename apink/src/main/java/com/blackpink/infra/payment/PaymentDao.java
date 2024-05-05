package com.blackpink.infra.payment;

import java.util.List;

public interface PaymentDao {
	
//	마이페이지 상품주문리스트
	public List<PaymentDto> selectList(PaymentVo vo);
//	마이페이지 사용자정보
	public PaymentDto item(PaymentVo vo);
//	마이페이지, 결제화면 주소리스트
	public List<PaymentDto> addressList(PaymentVo vo);
//	결제화면 단일주소리스트
	public PaymentDto addressItem(PaymentVo vo);
//	결제화면 카드정보
	public List<PaymentDto> paymentList(PaymentVo vo);
//	결제화면 단일카드정보
	public PaymentDto paymentItem(PaymentDto dto);
	
	public int update(PaymentDto dto);
	
	public int addressUpdate(PaymentDto dto);
	
	public int updatePw(PaymentVo vo);
	
	public int addressInsert(PaymentVo vo);
	
	public PaymentDto existingPassword(PaymentVo vo);
	
	public int selectOneCount(PaymentVo vo);
	
	public int addressCount(PaymentVo vo);
}

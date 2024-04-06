package com.blackpink.infra.mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blackpink.infra.payment.PaymentDto;
import com.blackpink.infra.payment.PaymentService;
import jakarta.servlet.http.HttpSession;
@Controller
public class MypageController {

	@Autowired
	PaymentService service;
	
	@RequestMapping(value = "/myPage")
	public String myPage(PaymentDto dto, Model model, HttpSession httpSession) throws Exception {
		
//		vo.setParamsPaging(service.selectOneCount(vo));
//		
//		if (vo.getTotalRows() > 0) {
//			model.addAttribute("list", service.selectMyPage(vo));
//		}
			dto.setMbSeq((String)httpSession.getAttribute("sessMbSeq"));
			System.out.println("----------------------" + (String)httpSession.getAttribute("sessMbSeq"));
			model.addAttribute("list", service.selectMypage(dto));
		
			return "/v1/infra/user/myPage";
	}
	
	@RequestMapping(value = "/loginUser")
	public String loginUser(PaymentDto dto) {
		
		return "/v1/infra/user/loginUser";
	}
	
}

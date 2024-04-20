package com.blackpink.infra.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class PaymentController {

	@Autowired
	PaymentService service;
	
	@RequestMapping(value = "/payment")
	public String myPage(@ModelAttribute("vo")PaymentVo vo,Model model, HttpSession httpSession) throws Exception {
		
//		vo.setMbSeq((String)httpSession.getAttribute("sessMbSeqUser"));
		
//		model.addAttribute("item", service.item(vo));
		
		return "/v1/infra/user/payment";
	}
}

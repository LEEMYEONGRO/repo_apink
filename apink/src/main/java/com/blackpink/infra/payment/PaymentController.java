package com.blackpink.infra.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blackpink.infra.user.product.ProductDto;

import jakarta.servlet.http.HttpSession;

@Controller
public class PaymentController {

	@Autowired
	PaymentService service;
	
	@RequestMapping(value = "/payment")
	public String payment(@ModelAttribute("vo")PaymentVo vo, Model model,ProductDto pddto, PaymentDto dto, HttpSession httpSession) throws Exception {
		
		return "/v1/infra/user/payment";
	}
}

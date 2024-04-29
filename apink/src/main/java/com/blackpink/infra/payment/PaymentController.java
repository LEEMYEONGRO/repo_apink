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
	public String payment(@ModelAttribute("vo") PaymentVo vo, Model model, ProductDto pddto, PaymentDto dto, HttpSession httpSession) throws Exception {
	    // 이전 페이지에서 전달한 데이터를 받아옴
	    String pdName = pddto.getPdName();
	    int pdPrice = pddto.getPdPrice();
	    int pdpmQuantity = pddto.getPdpmQuantity();
	    String clCode = pddto.getClCode();
	    String szCode = pddto.getSzCode();
	    
	    System.out.println(pdName);
	    System.out.println(pdPrice);
	    System.out.println(pdpmQuantity);
	    System.out.println(clCode);
	    System.out.println(szCode);
	    // 받아온 데이터를 모델에 추가하여 결제 페이지로 전달
	    model.addAttribute("pdName", pdName);
	    model.addAttribute("pdPrice", pdPrice);
	    model.addAttribute("pdpmQuantity", pdpmQuantity);
	    model.addAttribute("clCode", clCode);
	    model.addAttribute("szCode", szCode);
	    
	    return "/v1/infra/user/payment";
	}
}

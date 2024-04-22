package com.blackpink.infra.productpayment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.blackpink.infra.payment.PaymentService;

@Controller
public class ProductpaymentController {

	@Autowired
	PaymentService service;
	
	
}

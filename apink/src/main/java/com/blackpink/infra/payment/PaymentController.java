package com.blackpink.infra.payment;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blackpink.infra.codegroup.CodeGroupDto;
import com.blackpink.infra.user.product.ProductDto;

import jakarta.servlet.http.HttpSession;

@Controller
public class PaymentController {

	@Autowired
	PaymentService service;
//	결제페이지
	@RequestMapping(value = "/payment")
	public String payment(@ModelAttribute("vo") PaymentVo vo, Model model, ProductDto pddto, PaymentDto dto, HttpSession httpSession) throws Exception {
	    
		vo.setMbSeq((String)httpSession.getAttribute("sessMbSeqUser"));
		
		// 이전 페이지에서 전달한 데이터를 받아옴
		String pdSeq = pddto.getPdSeq();
	    String pdName = pddto.getPdName();
	    int pdPrice = pddto.getPdPrice();
	    int pdpmQuantity = pddto.getPdpmQuantity();
	    String clCode = pddto.getClCode();
	    String szCode = pddto.getSzCode();
//	    System.out.println(pdSeq + "-----------------------------");
//	    System.out.println(pdName);
//	    System.out.println(pdPrice);
//	    System.out.println(pdpmQuantity);
//	    System.out.println(clCode);
//	    System.out.println(szCode);
	    
//	    받아온 데이터를 모델에 추가하여 결제 페이지로 전달
	    model.addAttribute("pdSeq", pdSeq);
	    model.addAttribute("pdName", pdName);
	    model.addAttribute("pdPrice", pdPrice);
	    model.addAttribute("pdpmQuantity", pdpmQuantity);
	    model.addAttribute("clCode", clCode);
	    model.addAttribute("szCode", szCode);
	   	
//	    주소내역불러오기
	    model.addAttribute("addressList", service.addressList(vo));
	    model.addAttribute("paymentList", service.paymentList(vo));
	    return "v1/infra/user/payment";
	}
	
	@RequestMapping("productpaymentInsert")
	public String productpaymentInsert(PaymentDto dto) {
		
		service.productpaymentInsert(dto); 
		
		return "redirect:/myPage"; 
	}
	
//	결제를 위한 주소정보 아작스
	@ResponseBody
	@RequestMapping(value = "addressSelectCheck")
	public Map<String, Object> addressSelectCheck(PaymentVo vo, PaymentDto dto, Model model, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
				
		if(dto.getArSeq() != null) {
				        
	        // returnMap에도 성공 여부와 함께 데이터를 담아 전달
	        returnMap.put("rt", "success");
	        returnMap.put("addressItem", service.addressItem(vo));
			
		} else {
			returnMap.put("rt", "fail");
		}
		return returnMap;
	}
	
//	결제를 위한 카드정보 아작스
	@ResponseBody
	@RequestMapping(value = "paymentSelectCheck")
	public Map<String, Object> paymentSelectCheck(PaymentVo vo, PaymentDto dto, Model model, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
				
		if(dto.getPmSeq() != null) {
				        
	        // returnMap에도 성공 여부와 함께 데이터를 담아 전달
	        returnMap.put("rt", "success");
	        returnMap.put("paymentItem", service.paymentItem(dto));
			
		} else {
			returnMap.put("rt", "fail");
		}
		return returnMap;
	}
}

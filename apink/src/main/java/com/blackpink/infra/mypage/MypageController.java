package com.blackpink.infra.mypage;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blackpink.common.constants.Constants;
import com.blackpink.common.util.UtilDateTime;
import com.blackpink.infra.payment.PaymentDto;
import com.blackpink.infra.payment.PaymentService;
import com.blackpink.infra.payment.PaymentVo;

import jakarta.servlet.http.HttpSession;
@Controller
public class MypageController {

	@Autowired
	PaymentService service;
	
	@Autowired
	MypageService MypageService;
	
	@RequestMapping(value = "/myPage")
	public String myPage(@ModelAttribute("vo")PaymentVo vo,Model model, HttpSession httpSession) throws Exception {
		
		setSearch(vo);
		
		vo.setMbSeq((String)httpSession.getAttribute("sessMbSeqUser"));
		vo.setParamsPaging(service.selectOneCount(vo));
		
		System.out.println(vo.getShValue() + "-------------------------------------------");
		
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", service.selectList(vo));
		}
		
		model.addAttribute("item", service.item(vo));
			
		return "/v1/infra/user/myPage";
	}
	
	public void setSearch(PaymentVo vo) throws Exception {
		vo.setShDateStart(vo.getShDateStart() == null
		    ? UtilDateTime.calculateDayReplace00TimeString(UtilDateTime.nowLocalDateTime(), Constants.DATE_INTERVAL)
		    : UtilDateTime.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null
		    ? UtilDateTime.nowString()
		    : UtilDateTime.addNowTimeString(vo.getShDateEnd()));		
	}
	
	@RequestMapping(value = "update")
	public String update(PaymentDto dto) {
		
		service.update(dto);
		return "redirect:/myPage";
	}
	
	@RequestMapping(value = "updatePw")
	public String updatePw(PaymentDto dto) {
		
		service.updatePw(dto);
		return "redirect:/myPage";
	}
	
	@RequestMapping(value = "/loginUser")
	public String loginUser(PaymentDto dto) {
		
		return "/v1/infra/user/loginUser";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/signinUser")
	public Map<String, Object> signinUser(MypageDto dto, HttpSession httpSession) {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		MypageDto dtoL = MypageService.login(dto);
		
		if(dto.getMbEmail().equals(dtoL.getMbEmail())) {
			if(matchesBcrypt(dto.getMbPassword(),dtoL.getMbPassword() , 10)) {
				returnMap.put("rt", "success");

			httpSession.setAttribute("sessEmailUser", dtoL.getMbEmail());
			httpSession.setAttribute("sessMbSeqUser", dtoL.getMbSeq());
			httpSession.setAttribute("sessNameUser", dtoL.getMbName());
			httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE_XDM); // 60second * 30 = 30minute
		}else {
			returnMap.put("rt", "password");
		}
	}else {
		returnMap.put("rt", "email");
	}
	return returnMap;
	}
	
//	@ResponseBody
//	@RequestMapping(value = "/newPassword")
//	public Map<String, Object> newPassword(PaymentDto dto) {
//		
//		Map<String, Object> returnMap = new HashMap<String, Object>();
//		
//		PaymentDto dtoPw = service.newPassword(dto);
//		
//		if(matchesBcrypt(dto.getMbPassword(),dtoPw.getMbPassword() , 10)) {
//			if((dto.getMbPassword().equals(dtoPw.getMbPassword())) {
//				returnMap.put("rt", "success");
//		
//		if(dto.getMbPassword().equals(dtoPw.getMbPassword())) {
//			if(matchesBcrypt(dto.getMbPassword(),dtoPw.getMbPassword() , 10)) {
//				returnMap.put("rt", "success");
//		}else {
//			returnMap.put("rt", "newPassword");
//		}
//	}else {
//		returnMap.put("rt", "password");
//	}
//		return returnMap;
//	}
	
	public String encodeBcrypt(String planeText, int strength) {
		  return new BCryptPasswordEncoder(strength).encode(planeText);
	}

			
	public boolean matchesBcrypt(String planeText, String hashValue, int strength) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(strength);
		return passwordEncoder.matches(planeText, hashValue);
	}
	
	
}

package com.blackpink.infra.mypage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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
import com.blackpink.infra.code.CodeDto;
import com.blackpink.infra.payment.PaymentDto;
import com.blackpink.infra.payment.PaymentService;
import com.blackpink.infra.payment.PaymentVo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

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
		
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", service.selectList(vo));
		}
		
		model.addAttribute("item", service.item(vo));
		
		model.addAttribute("addressList", service.addressList(vo));
		
//	    api
	    String apiUrl = "https://ecos.bok.or.kr/api/KeyStatisticList/sample/json/kr/2/5";
	    JsonNode node = callApiAndGetResponse(apiUrl);
	    model.addAttribute("node", node);
		
		return "v1/infra/user/myPage";
	}
	
	public void setSearch(PaymentVo vo) throws Exception {
		vo.setShDateStart(vo.getShDateStart() == null
		    ? UtilDateTime.calculateDayReplace00TimeString(UtilDateTime.nowLocalDateTime(), Constants.DATE_INTERVAL)
		    : UtilDateTime.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null
		    ? UtilDateTime.nowString()
		    : UtilDateTime.addNowTimeString(vo.getShDateEnd()));		
	}
	
	@RequestMapping(value = "/addressUserCorrection")
	public String addressUserCorrection(PaymentDto dto, Model model) {
		
//		model.addAttribute("addressItem", service.addressItem(dto));
		
		return "v1/infra/user/addressUserCorrection";
	}
	
	@RequestMapping(value = "update")
	public String update(PaymentDto dto) {
		
		service.update(dto);
		
		return "redirect:/myPage";
	}
	
	@RequestMapping(value = "addressUpdate")
	public String addressUpdate(PaymentDto dto) {
		
		service.addressUpdate(dto);
		
		return "redirect:/myPage";
	}
	
	@RequestMapping(value = "addressInsert")
	public String addressInsert(PaymentVo vo) {
		
		service.addressInsert(vo);
		
		return "redirect:/myPage";
	}
	
	@RequestMapping(value = "/loginUser")
	public String loginUser(PaymentDto dto) {
		
		return "v1/infra/user/loginUser";
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
	
	@ResponseBody
	@RequestMapping(value = "/logoutUser")
	public Map<String, Object> logoutUser(HttpSession httpSession) {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		httpSession.invalidate();
		
		returnMap.put("rt", "success");
		return returnMap;
	}
	
	@ResponseBody
	@RequestMapping(value = "/newPassword")
	public Map<String, Object> newPassword(@ModelAttribute("vo")PaymentVo vo, PaymentDto dto, HttpSession httpSession) {
		
		vo.setMbSeq((String)httpSession.getAttribute("sessMbSeqUser"));
		
		Map<String, Object> returnMap = new HashMap<String, Object>();

		PaymentDto dtoPw = service.existingPassword(vo); // 기존 비밀번호를 가져옴
		
		// 기존 비밀번호 확인
	    if(matchesBcrypt(vo.getMbPassword(),dtoPw.getMbPassword() , 10)) {
	    	// 새 비밀번호와 확인 비밀번호 일치 여부 확인
		    if(dto.getNewmbPassword().equals(dto.getPasswordCheck())) {
		    	
		    	vo.setNewmbPassword(encodeBcrypt(vo.getNewmbPassword(), 10));
			        
		    	service.updatePw(vo);
		        
			    returnMap.put("rt", "success");
		    }else{
		    	returnMap.put("rt", "no");
		    }
	    }else {
	    	returnMap.put("rt", "existingPassword");
	    }
	    return returnMap;
	}
	
	public String encodeBcrypt(String planeText, int strength) {
		  return new BCryptPasswordEncoder(strength).encode(planeText);
	}

	public boolean matchesBcrypt(String planeText, String hashValue, int strength) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(strength);
		return passwordEncoder.matches(planeText, hashValue);
	}
	
	private JsonNode callApiAndGetResponse(String apiUrl) throws IOException {
	    URL url = new URL(apiUrl);
	    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
	    httpURLConnection.setRequestMethod("GET");

	    BufferedReader bufferedReader;
	    if (httpURLConnection.getResponseCode() >= 200 && httpURLConnection.getResponseCode() <= 300) {
	        bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
	    } else {
	        bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
	    }

	    StringBuilder stringBuilder = new StringBuilder();
	    String line;
	    while ((line = bufferedReader.readLine()) != null) {
	        System.out.println("line: " + line);
	        stringBuilder.append(line);
	    }

	    bufferedReader.close();
	    httpURLConnection.disconnect();

	    ObjectMapper objectMapper = new ObjectMapper();
	    return objectMapper.readTree(stringBuilder.toString());
	}
	
}

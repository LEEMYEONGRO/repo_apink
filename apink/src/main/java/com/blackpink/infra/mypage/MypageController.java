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
import com.blackpink.infra.member.MemberDto;
import com.blackpink.infra.member.MemberVo;
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
	public String myPage(@ModelAttribute("vo")PaymentVo vo, Model model, HttpSession httpSession) throws Exception {
		
		setSearch(vo);
		
//		vo.setParamsPaging(service.selectOneCount(vo));
		
		if (vo.getTotalRows() > 0) {
		}
			vo.setMbSeq((String)httpSession.getAttribute("sessMbSeq"));
			model.addAttribute("list", service.selectMypage(vo));
		
			return "/v1/infra/user/myPage";
	}
	
	public void setSearch(PaymentVo vo) throws Exception {
		/* 최초 화면 로딩시에 세팅은 문제가 없지만 */
		/*이후 전체적으로 데이터를 조회를 하려면 null 값이 넘어 오는 관계로 문제가 전체 데이터 조회가 되지 못한다.*/
		/*해서 BaseVo.java 에서 기본값을 주어서 처리*/
//		vo.setShUseNy(vo.getShUseNy() == null ? 1 : vo.getShUseNy());
//		vo.setShDelNy(vo.getShDelNy() == null ? 0 : vo.getShDelNy());
//		vo.setShOptionDate(vo.getShOptionDate() == null ? 2 : vo.getShOptionDate());
		
		/* 초기값 세팅이 있는 경우 사용 */
		vo.setShDateStart(vo.getShDateStart() == null
		    ? UtilDateTime.calculateDayReplace00TimeString(UtilDateTime.nowLocalDateTime(), Constants.DATE_INTERVAL)
		    : UtilDateTime.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null
		    ? UtilDateTime.nowString()
		    : UtilDateTime.addNowTimeString(vo.getShDateEnd()));		
		
//		/* 초기값 세팅이 없는 경우 사용 */
//		vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(vo.getShDateStart()));
//		vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(vo.getShDateEnd()));
		
		
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
	
	public boolean matchesBcrypt(String planeText, String hashValue, int strength) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(strength);
		return passwordEncoder.matches(planeText, hashValue);
	}
}

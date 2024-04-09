package com.blackpink.infra.member;

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
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@RequestMapping(value = "/memberXdmList")
	public String memberXdmList(@ModelAttribute("vo") MemberVo vo, Model model) throws Exception {
		
		setSearch(vo);
		
		vo.setParamsPaging(service.selectOneCount(vo));
		
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", service.selectList(vo));
		}
		
//		System.out.println("vo.getShDateStart(): " + vo.getShDateStart());
//		System.out.println("vo.getShDateEnd(): " + vo.getShDateEnd());
//		System.out.println("vo.getRowNumToShow()"+vo.getRowNumToShow());
		
//		 model.addAttribute("vo", vo);
		
		return "/v1/infra/memberXdm/memberXdmList";
	}
	
	
	@RequestMapping(value = "/memberXdmAddition")
	public String memberXdmAddition(MemberDto dto, Model model ) {
		
		model.addAttribute("oneList", service.selectOne(dto));
		
		return "/v1/infra/memberXdm/memberXdmAddition";
	}
	
	@RequestMapping(value = "/loginXdm")
	public String loginXdm(MemberDto dto) {
		
		return "/v1/infra/loginXdm/loginXdm";
	}
	
	@ResponseBody
	@RequestMapping(value = "/signinXdm")
	public Map<String, Object> signinXdm(MemberDto dto, HttpSession httpSession) {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		MemberDto dtoL = service.login(dto);
		
		if(dto.getMbEmail().equals(dtoL.getMbEmail())) {
			if(matchesBcrypt(dto.getMbPassword(),dtoL.getMbPassword() , 10)) {
				returnMap.put("rt", "success");

			httpSession.setAttribute("sessEmailXdm", dtoL.getMbEmail());
			httpSession.setAttribute("sessMbSeqXdm", dtoL.getMbSeq());
			httpSession.setAttribute("sessNameXdm", dtoL.getMbName());
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
	@RequestMapping(value = "/signoutinxdm")
	public Map<String, Object> signoutinxdm(HttpSession httpSession) {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		httpSession.invalidate();
		
		returnMap.put("rt", "success");
		return returnMap;
	}
	
	
	@RequestMapping(value = "/memberXdmInsert")
	public String memberXdmInsert(MemberDto dto) {
		System.out.println("memberXdmInsert");
		dto.setMbPassword(encodeBcrypt(dto.getMbPassword(), 10));
		
		System.out.println("dto.getIfmmId()encoded : " + dto.getMbPassword());
		
		service.insert(dto);
		
		return "redirect:/memberXdmList";
	}
	
	@RequestMapping(value = "/memberXdmCorrection")
	public String memberXdmCorrection(MemberDto dto, Model model) {
		
		model.addAttribute("oneList", service.selectOne(dto));
		
		return "/v1/infra/memberXdm/memberXdmCorrection";
		
	}
		
	@RequestMapping(value = "/memberXdmUpdate")
	public String memberXdmUpdate(MemberDto dto) {
		
		service.update(dto);
		
		return "redirect:/memberXdmList";
		
	}
	
	@RequestMapping(value = "/memberXdmDeleteNy")
	public String memberXdmDeleteNy(MemberDto dto) {
		
		service.updateDeleteNy(dto);
		
		return "redirect:/memberXdmList";
		
	}
	
	@RequestMapping(value = "/memberXdmDelete")
	public String memberXdmDelete(MemberDto dto) {
		
		service.delete(dto);
		
		return "redirect:/memberXdmList";
		
	}
	
	
	public void setSearch(MemberVo vo) throws Exception {
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
	
	public String encodeBcrypt(String planeText, int strength) {
		  return new BCryptPasswordEncoder(strength).encode(planeText);
	}

			
	public boolean matchesBcrypt(String planeText, String hashValue, int strength) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(strength);
		return passwordEncoder.matches(planeText, hashValue);
	}
	
	@ResponseBody
	@RequestMapping(value = "signinXdmProc")
	public Map<String, Object> signinXdmProc(MemberDto dto, HttpSession httpSession) throws Exception {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();

//		String passwordCheck = dto.getPasswordCheck();
		dto.setMbPassword(encodeBcrypt(dto.getMbPassword(),10));
		
		if(matchesBcrypt(dto.getPasswordCheck(), dto.getMbPassword(),10)) {
			returnMap.put("rt", "success");
		} else {
			System.out.println("false");
		}
		return returnMap;
	}
}

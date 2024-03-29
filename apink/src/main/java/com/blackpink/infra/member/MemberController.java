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
	private String password;
	
	@RequestMapping(value = "/memberUserList")
	public String memberUserList(@ModelAttribute("vo") MemberVo vo, Model model) throws Exception {
		
		setSearch(vo);
		
		model.addAttribute("list", service.selectList(vo));

		System.out.println("vo.getShDateStart(): " + vo.getShDateStart());
		System.out.println("vo.getShDateEnd(): " + vo.getShDateEnd());
		
//		 model.addAttribute("vo", vo);
		
		return "/v1/infra/memberUser/memberUserList";
	}
	
	
	@RequestMapping(value = "/memberUserAddition")
	public String memberUserAddition(MemberDto dto, Model model ) {
		
		model.addAttribute("oneList", service.selectOne(dto));
		
		return "/v1/infra/memberUser/memberUserAddition";
	}
	
	
	@RequestMapping("memberUserInsert")
	public String memberUserInsert(MemberDto dto) {
		
		dto.setPassword(encodeBcrypt(dto.getPassword(), 10));
		
//		System.out.println("dto.getIfmmId()encoded : " + dto.getPassword());
		
		service.insert(dto);
		
		return "redirect:/memberUserList";
	}
	
	@RequestMapping("memberUserCorrection")
	public String memberUserCorrection(MemberDto dto, Model model) {
		
		model.addAttribute("oneList", service.selectOne(dto));
		
		return "/v1/infra/memberUser/memberUserCorrection";
		
	}
		
	@RequestMapping("memberUserUpdate")
	public String memberUserUpdate(MemberDto dto) {
		
		service.update(dto);
		
		return "redirect:/memberUserList";
		
	}
	
	@RequestMapping("memberUserDeleteNy")
	public String memberUserDeleteNy(MemberDto dto) {
		
		service.updateDeleteNy(dto);
		
		return "redirect:/memberUserList";
		
	}
	
	@RequestMapping("memberUserDelete")
	public String memberUserDelete(MemberDto dto) {
		
		service.delete(dto);
		
		return "redirect:/memberUserList";
		
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

		String password = dto.getPassword();
		dto.setPassword(encodeBcrypt(dto.getPassword(),10));
		
		if(matchesBcrypt(password, dto.getPasswordCheck(), 10)) {
			returnMap.put("rt", "success");
		} else {
			System.out.println("false");
		}
		return returnMap;
	}
}

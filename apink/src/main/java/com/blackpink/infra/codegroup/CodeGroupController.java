package com.blackpink.infra.codegroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blackpink.common.constants.Constants;
import com.blackpink.common.util.UtilDateTime;

@Controller
public class CodeGroupController {
	
	@Autowired
	CodeGroupService service;
	
	//@RequestMapping("codeGroupXdmList")
	//public String codeGroupXdmList(Model model) {
		
//		List<CodeGroupDto> codeGroupDtos = service.selectList();
//		
//		for(CodeGroupDto a: codeGroupDtos) {
//			System.out.println(a.getCodeType());
//		}
//		
		//model.addAttribute("list", service.selectList());
				
				
		//return "/v1/infra/codegroup/codeGroupXdmList";
		
	//}
	
//	@RequestMapping("codeGroupView")
//	public String codeGroupView(CodeGroupDto dto) {
//		
//		System.out.println("dto.getSeq(): " + dto.getSeq());
//		System.out.println("dto.getCodeType(): " + dto.getCodeType());
//		System.out.println("dto.getDeleteNy(): " + dto.getDeleteNy());
//		
//		return "codeGroupView";
//	}
	
//	@RequestMapping("codeGroupView")
//	public String codeGroupView(CodeGroupDto dto, Model model) {
//		
//		model.addAttribute("oneList", service.selectOne(dto));
//		
//		return "/v1/infra/codegroup/codeGroupView";
//		
//		
//	}
//	
//	@RequestMapping("codeGroupCorrection")
//	public String codeGroupCorrection(CodeGroupDto dto, Model model) {
//		
//		model.addAttribute("oneList", service.selectOne(dto));
//		
//		return "/v1/infra/codegroup/codeGroupCorrection";
//		
//		
//	}
//	
//	@RequestMapping("codeGroupRegistration")
//	public String codeGroupRegistration(CodeGroupDto dto, Model model) {
//		
//		model.addAttribute("oneList", service.selectOne(dto));
//		
//		return "/v1/infra/codegroup/codeGroupRegistration";
//		
//		
//	}
//	
//	@RequestMapping("codeGroupInsert")
//	public String codeGroupInsert(CodeGroupDto dto) {
//		
//		service.insert(dto);
//		
//		return "redirect:/codeGroupXdmList";
//		
//	}
//	
//	@RequestMapping("codeGroupUpdate")
//	public String codeGroupUpdate(CodeGroupDto dto) {
//		
//		service.update(dto);
//		
//		return "redirect:/codeGroupXdmList";
//		
//	}
//	
//	@RequestMapping("updateDeleteNy")
//	public String updateDeleteNy(CodeGroupDto dto) {
//		
//		service.updateDeleteNy(dto);
//		
//		return "redirect:/codeGroupXdmList";
//		
//	}
//	
//	@RequestMapping("delete")
//	public String delete(CodeGroupDto dto) {
//		
//		service.delete(dto);
//		
//		return "redirect:/codeGroupXdmList";
//		
//	}
	
	@RequestMapping(value = "/index")
	public String index() {
		
		return "/v1/infra/index/index";
	}
	
	@RequestMapping(value = "/codeGroupXdmList")
	public String codeGroupXdmList(@ModelAttribute("vo") CodeGroupVo vo, Model model) throws Exception {
		
		setSearch(vo);
		vo.setParamsPaging(service.selectOneCount(vo));
		
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", service.selectList(vo));
		}
		
//		 model.addAttribute("vo", vo);
		
		return "/v1/infra/codeGroupXdm/codeGroupXdmList";
	}
	
	
	@RequestMapping(value = "/codeGroupXdmAddition")
	public String codeGroupXdmAddition(CodeGroupDto dto, Model model ) {
		
		model.addAttribute("oneList", service.selectOne(dto));
		
		return "/v1/infra/codeGroupXdm/codeGroupXdmAddition";
	}
	
	
	@RequestMapping("codeGroupXdmInsert")
	public String codeGroupXdmInsert(CodeGroupDto dto) {
		
		service.insert(dto);
		
		return "redirect:/codeGroupXdmList";
	}
	
	@RequestMapping("codeGroupXdmCorrection")
	public String codeGroupXdmCorrection(CodeGroupDto dto, Model model) {
		
		model.addAttribute("oneList", service.selectOne(dto));
		
		return "/v1/infra/codeGroupXdm/codeGroupXdmCorrection";
		
	}
		
	@RequestMapping("codeGroupXdmUpdate")
	public String codeGroupXdmUpdate(CodeGroupDto dto) {
		
		service.update(dto);
		
		return "redirect:/codeGroupXdmList";
		
	}
	
	@RequestMapping("codeGroupXdmDeleteNy")
	public String codeGroupXdmDeleteNy(CodeGroupDto dto) {
		
		service.updateDeleteNy(dto);
		
		return "redirect:/codeGroupXdmList";
		
	}
	
	@RequestMapping("codeGroupXdmDelete")
	public String codeGroupXdmDelete(CodeGroupDto dto) {
		
		service.delete(dto);
		
		return "redirect:/codeGroupXdmList";
		
	}
	
	
	public void setSearch(CodeGroupVo vo) throws Exception {
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
}

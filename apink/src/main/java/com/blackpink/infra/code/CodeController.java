package com.blackpink.infra.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blackpink.common.constants.Constants;
import com.blackpink.common.util.UtilDateTime;
import com.blackpink.infra.codegroup.CodeGroupService;

@Controller
public class CodeController {

	@Autowired
	CodeService service;
	
	@Autowired
	CodeGroupService codeGroupService;
	
//	@RequestMapping("codeXdmList")
//	public String codeXdmList(Model model) {
//		
//		model.addAttribute("list", service.selectList());
//		
//		return "/v1/infra/code/codeXdmList";
//	}
	
//	@RequestMapping("codeView")
//	public String codeView(CodeDto dto ,Model model) {
//		
//		model.addAttribute("oneList", service.selectOne(dto));
//		
//		return "/v1/infra/code/codeView";
//		
//		
//	}
//	
//	@RequestMapping("codeCorrection")
//	public String codeCorrection(CodeDto dto, Model model) {
//		
//		model.addAttribute("oneList", service.selectOne(dto));
//		
//		return "/v1/infra/code/codeCorrection";
//		
//	}
//	
//	@RequestMapping("codeRegistration")
//	public String codeRegistration (CodeDto dto, Model model) {
//		
//		model.addAttribute("oneList", service.selectOne(dto));
//		
//		return "/v1/infra/code/codeRegistration";
//		
//	}
//	@RequestMapping("codeInsert")
//	public String codeInsert (CodeDto dto) {
//		
//		service.insert(dto);
//		
//		return "redirect:/codeXdmList";
//	}
//	
//	@RequestMapping("codeUpdate")
//	public String codeUpdate (CodeDto dto) {
//		
//		service.update(dto);
//		
//		return "redirect:/codeXdmList";
//		
//	}
//	
//	@RequestMapping("deleteNyUpdate")
//	public String deleteNyUpdate (CodeDto dto) {
//		
//		service.deleteNyUpdate(dto);
//		
//		return "redirect:/codeXdmList";
//	}
//	
//	@RequestMapping("codeDelete")
//	public String delete (CodeDto dto) {
//		
//		service.codeDelete(dto);
//		
//		return "redirect:/codeXdmList";
//	}

	@RequestMapping(value = "/codeXdmList")
	public String codeXdmList(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception { 
		
		setSearch(vo);
		
		vo.setParamsPaging(service.selectOneCount(vo));
		
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", service.selectList(vo));
		}
		
		
//		System.out.println("vo.getShDateStart(): " + vo.getShDateStart());
//		System.out.println("vo.getShDateEnd(): " + vo.getShDateEnd());
		
		return "/v1/infra/codeXdm/codeXdmList";
	}
	
	
	@RequestMapping(value = "/codeXdmAddition")
	public String codeXdmAddition(CodeDto dto, Model model ) {
		
		model.addAttribute("listCodeGroup", codeGroupService.selectListWithoutPaging());
		
		model.addAttribute("oneList", service.selectOne(dto));
		
		return "/v1/infra/codeXdm/codeXdmAddition";
	}
	
	
	@RequestMapping("codeXdmInsert")
	public String codeXdmInsert(CodeDto dto) {
		
		service.insert(dto);
		System.out.println(dto.toString()+ "--------------------------------------------");
		return "redirect:/codeXdmList";
	}
	
	@RequestMapping("codeXdmCorrection")
	public String codeXdmCorrection(CodeDto dto, Model model) {
		
		model.addAttribute("oneList", service.selectOne(dto));
		
		return "/v1/infra/codeXdm/codeXdmCorrection";
		
	}
		
	@RequestMapping("codeXdmUpdate")
	public String codeXdmUpdate(CodeDto dto) {
		
		service.update(dto);
		
		return "redirect:/codeXdmList";
		
	}
	
	@RequestMapping("codeXdmDeleteNy")
	public String codeXdmDeleteNy(CodeDto dto) {
		
		service.deleteNyUpdate(dto);
		
		return "redirect:/codeXdmList";
		
	}
	
	@RequestMapping("codeXdmDelete")
	public String codeXdmDelete(CodeDto dto) {
		
		service.codeDelete(dto);
	
		return "redirect:/codeXdmList";
	}
	
	
		
		
		public void setSearch(CodeVo vo) throws Exception {
			/* 최초 화면 로딩시에 세팅은 문제가 없지만 */
			/*이후 전체적으로 데이터를 조회를 하려면 null 값이 넘어 오는 관계로 문제가 전체 데이터 조회가 되지 못한다.*/
			/*해서 BaseVo.java 에서 기본값을 주어서 처리*/
//			vo.setShUseNy(vo.getShUseNy() == null ? 1 : vo.getShUseNy());
//			vo.setShDelNy(vo.getShDelNy() == null ? 0 : vo.getShDelNy());
//			vo.setShOptionDate(vo.getShOptionDate() == null ? 2 : vo.getShOptionDate());
			
			/* 초기값 세팅이 있는 경우 사용 */
			vo.setShDateStart(vo.getShDateStart() == null
			    ? UtilDateTime.calculateDayReplace00TimeString(UtilDateTime.nowLocalDateTime(), Constants.DATE_INTERVAL)
			    : UtilDateTime.add00TimeString(vo.getShDateStart()));
			vo.setShDateEnd(vo.getShDateEnd() == null
			    ? UtilDateTime.nowString()
			    : UtilDateTime.addNowTimeString(vo.getShDateEnd()));		
		
//			/* 초기값 세팅이 없는 경우 사용 */
//			vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(vo.getShDateStart()));
//			vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(vo.getShDateEnd()));
			
	}
}

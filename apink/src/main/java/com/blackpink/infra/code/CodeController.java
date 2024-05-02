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
	
	@RequestMapping(value = "/codeXdmList")
	public String codeXdmList(@ModelAttribute("vo")CodeVo vo, Model model) throws Exception{
		
		setSearch(vo);
		
		vo.setParamsPaging(service.selectOneCount(vo));
		
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", service.selectList(vo));
		}
		
		return "v1/infra/codeXdm/codeXdmList";
	}
	
	public void setSearch(CodeVo vo) throws Exception {

		vo.setShDateStart(vo.getShDateStart() == null
		    ? UtilDateTime.calculateDayReplace00TimeString(UtilDateTime.nowLocalDateTime(), Constants.DATE_INTERVAL)
		    : UtilDateTime.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null
		    ? UtilDateTime.nowString()
		    : UtilDateTime.addNowTimeString(vo.getShDateEnd()));		
	}
	
	
	@RequestMapping(value = "/codeXdmAddition")
	public String codeXdmAddition(CodeDto dto, Model model) {
		
		model.addAttribute("listCodeGroup", codeGroupService.selectListWithoutPaging());
		
		model.addAttribute("oneList", service.selectOne(dto));
		
		return "v1/infra/codeXdm/codeXdmAddition";
	}
	
	@RequestMapping(value = "/codeXdmInsert")
	public String codeXdmInsert(CodeDto dto) {
		
		service.insert(dto);
		
		return "redirect:/codeXdmList";
	}
	
	@RequestMapping(value = "/codeXdmCorrection")
	public String codeXdmCorrection(CodeDto dto, Model model) {
		
		model.addAttribute("oneList", service.selectOne(dto));
		
		return "v1/infra/codeXdm/codeXdmCorrection";
	}
	
	@RequestMapping(value = "/codeXdmUpdate")
	public String codeXdmUpdate(CodeDto dto) {
		
		service.update(dto);
		
		return "redirect:/codeXdmList";
	}
	
	@RequestMapping(value = "/codeUpdateDeleteNy")
	public String codeUpdateDeleteNy(CodeDto dto) {
		
		service.updateDeleteNy(dto);
		
		return "redirect:/codeXdmList";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(CodeDto dto) {
		
		service.delete(dto);
		
		return "redirect:/codeXdmList";
	}
	
}
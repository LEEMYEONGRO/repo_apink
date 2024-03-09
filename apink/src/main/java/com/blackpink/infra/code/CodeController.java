package com.blackpink.infra.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blackpink.infra.codegroup.CodeGroupDto;

@Controller
public class CodeController {

	@Autowired
	CodeService service;
	
	@RequestMapping("codeXdmList")
	public String codeXdmList(Model model) {
		
		model.addAttribute("list", service.selectList());
		
		return "/v1/infra/code/codeXdmList";
	}
	
	@RequestMapping("codeView")
	public String codeView(CodeDto dto ,Model model) {
		
		model.addAttribute("oneList", service.selectOne(dto));
		
		return "/v1/infra/code/codeView";
		
		
	}
	
	@RequestMapping("codeCorrection")
	public String codeCorrection(CodeDto dto, Model model) {
		
		model.addAttribute("oneList", service.selectOne(dto));
		
		return "/v1/infra/code/codeCorrection";
		
	}
	
	@RequestMapping("codeRegistration")
	public String codeRegistration (CodeDto dto, Model model) {
		
		model.addAttribute("oneList", service.selectOne(dto));
		
		return "/v1/infra/code/codeRegistration";
		
	}
	@RequestMapping("codeInsert")
	public String codeInsert (CodeDto dto) {
		
		service.insert(dto);
		
		return "redirect:/codeXdmList";
	}
	
	@RequestMapping("codeUpdate")
	public String codeUpdate (CodeDto dto) {
		
		service.update(dto);
		
		return "redirect:/codeXdmList";
		
	}
	
	@RequestMapping("deleteNyUpdate")
	public String deleteNyUpdate (CodeDto dto) {
		
		service.deleteNyUpdate(dto);
		
		return "redirect:/codeXdmList";
	}
	
	@RequestMapping("codeDelete")
	public String delete (CodeDto dto) {
		
		service.codeDelete(dto);
		
		return "redirect:/codeXdmList";
	}
	
	@RequestMapping(value = "/codeCdmList")
	public String codeCdmList(Model model) {
		
		model.addAttribute("list", service.selectList());
		
		return "/v1/infra/codeCdm/codeCdmList";
	}
	
	@RequestMapping(value = "/codeCdmAddition")
	public String codeCdmAddition(CodeDto dto, Model model ) {
		
		model.addAttribute("oneList", service.selectOne(dto));
		
		return "/v1/infra/codeCdm/codeCdmAddition";
	}
	
	
	@RequestMapping("codeCdmInsert")
	public String codeCdmInsert(CodeDto dto) {
		
		service.insert(dto);
		
		return "redirect:/codeCdmList";
	}
	
	@RequestMapping("codeCdmCorrection")
	public String codeCdmCorrection(CodeDto dto, Model model) {
		
		model.addAttribute("oneList", service.selectOne(dto));
		
		return "/v1/infra/codeCdm/codeCdmCorrection";
		
	}
		
	@RequestMapping("codeCdmUpdate")
	public String codeCdmUpdate(CodeDto dto) {
		
		service.update(dto);
		
		return "redirect:/codeCdmList";
		
	}
	
	@RequestMapping("codeCdmDeleteNy")
	public String codeCdmDeleteNy(CodeDto dto) {
		
		service.deleteNyUpdate(dto);
		
		return "redirect:/codeCdmList";
		
	}
	
	@RequestMapping("codeCdmDelete")
	public String codeCdmDelete(CodeDto dto) {
		
		service.codeDelete(dto);
		
		return "redirect:/codeCdmList";
		
	}
}

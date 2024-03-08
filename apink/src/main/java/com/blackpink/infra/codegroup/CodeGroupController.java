package com.blackpink.infra.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeGroupController {
	
	@Autowired
	CodeGroupService service;
	
	@RequestMapping("codeGroupXdmList")
	public String codeGroupXdmList(Model model) {
		
//		List<CodeGroupDto> codeGroupDtos = service.selectList();
//		
//		for(CodeGroupDto a: codeGroupDtos) {
//			System.out.println(a.getCodeType());
//		}
//		
		model.addAttribute("list", service.selectList());
				
				
		return "/v1/infra/codegroup/codeGroupXdmList";
		
	}
	
//	@RequestMapping("codeGroupView")
//	public String codeGroupView(CodeGroupDto dto) {
//		
//		System.out.println("dto.getSeq(): " + dto.getSeq());
//		System.out.println("dto.getCodeType(): " + dto.getCodeType());
//		System.out.println("dto.getDeleteNy(): " + dto.getDeleteNy());
//		
//		return "codeGroupView";
//	}
	
	@RequestMapping("codeGroupView")
	public String codeGroupView(CodeGroupDto dto, Model model) {
		
		model.addAttribute("oneList", service.selectOne(dto));
		
		return "/v1/infra/codegroup/codeGroupView";
		
		
	}
	
	@RequestMapping("codeGroupCorrection")
	public String codeGroupCorrection(CodeGroupDto dto, Model model) {
		
		model.addAttribute("oneList", service.selectOne(dto));
		
		return "/v1/infra/codegroup/codeGroupCorrection";
		
		
	}
	
	@RequestMapping("codeGroupRegistration")
	public String codeGroupRegistration(CodeGroupDto dto, Model model) {
		
		model.addAttribute("oneList", service.selectOne(dto));
		
		return "/v1/infra/codegroup/codeGroupRegistration";
		
		
	}
	
	@RequestMapping("codeGroupInsert")
	public String codeGroupInsert(CodeGroupDto dto) {
		
		service.insert(dto);
		
		return "redirect:/codeGroupXdmList";
		
	}
	
	@RequestMapping("codeGroupUpdate")
	public String codeGroupUpdate(CodeGroupDto dto) {
		
		service.update(dto);
		
		return "redirect:/codeGroupXdmList";
		
	}
	
	@RequestMapping("updateDeleteNy")
	public String updateDeleteNy(CodeGroupDto dto) {
		
		service.updateDeleteNy(dto);
		
		return "redirect:/codeGroupXdmList";
		
	}
	
	@RequestMapping("delete")
	public String delete(CodeGroupDto dto) {
		
		service.delete(dto);
		
		return "redirect:/codeGroupXdmList";
		
	}
	
	@RequestMapping(value = "/index")
	public String index() {
		
		return "/v1/infra/codeGroupCdm/index";
	}
	
	@RequestMapping(value = "/codeGroupCdmList")
	public String codeGroupCdmList(Model model) {
		
		model.addAttribute("list", service.selectList());
		
		return "/v1/infra/codeGroupCdm/codeGroupCdmList";
	}
	
	@RequestMapping(value = "/codeGroupCdmAddition")
	public String codeGroupCdmAddition(CodeGroupDto dto, Model model ) {
		
		model.addAttribute("oneList", service.selectOne(dto));
		
		return "/v1/infra/codeGroupCdm/codeGroupCdmAddition";
	}
	
	
	@RequestMapping("codeGroupCdmInsert")
	public String codeGroupCdmInsert(CodeGroupDto dto) {
		
		service.insert(dto);
		
		return "redirect:/codeGroupCdmList";
	}
	
	@RequestMapping("codeGroupCdmCorrection")
	public String codeGroupCdmCorrection(CodeGroupDto dto, Model model) {
		
		model.addAttribute("oneList", service.selectOne(dto));
		
		return "/v1/infra/codeGroupCdm/codeGroupCdmCorrection";
		
	}
		
	@RequestMapping("codeGroupCdmUpdate")
	public String codeGroupCdmUpdate(CodeGroupDto dto) {
		
		service.update(dto);
		
		return "redirect:/codeGroupCdmList";
		
	}
	
	@RequestMapping("codeGroupCdmDeleteNy")
	public String codeGroupCdmDeleteNy(CodeGroupDto dto) {
		
		service.updateDeleteNy(dto);
		
		return "redirect:/codeGroupCdmList";
		
	}
	
	@RequestMapping("codeGroupCdmDelete")
	public String codeGroupCdmDelete(CodeGroupDto dto) {
		
		service.delete(dto);
		
		return "redirect:/codeGroupCdmList";
		
	}
		
}

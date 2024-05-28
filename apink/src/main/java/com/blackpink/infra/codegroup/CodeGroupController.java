package com.blackpink.infra.codegroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.blackpink.common.constants.Constants;
import com.blackpink.common.util.UtilDateTime;

@Controller
public class CodeGroupController {
	
	@Autowired
	CodeGroupService service;
	
	@RequestMapping(value = "/index")
	public String index() {
		
		return "v1/infra/index/index";
	}
	
	@RequestMapping(value = "/portfolioIndex")
	public String portfolioIndex() {
		
		return "v1/infra/portfolio/portfolioIndex";
	}
	
	@RequestMapping(value = "/codeGroupXdmList")
	public String codeGroupXdmList(@ModelAttribute("vo") CodeGroupVo vo, Model model) throws Exception {
		
		setSearch(vo);
		
		return "v1/infra/codeGroupXdm/codeGroupXdmList";
	}
	
	@RequestMapping(value = "/codeGroupXdmAjaxLita")
	public String codeGroupXdmAjaxLita(@ModelAttribute("vo") CodeGroupVo vo, Model model) throws Exception {
		
		setSearch(vo); 
		
		vo.setParamsPaging(service.selectOneCount(vo)); 
		
		if (vo.getTotalRows() > 0) { 
			model.addAttribute("list", service.selectList(vo));
		}
		
		return "v1/infra/codeGroupXdm/codeGroupXdmAjaxLita";
	}
	
	
	@RequestMapping(value = "/codeGroupXdmAddition")
	public String codeGroupXdmAddition(CodeGroupDto dto, Model model ) {
		
		model.addAttribute("oneList", service.selectOne(dto));
		
		return "v1/infra/codeGroupXdm/codeGroupXdmAddition";
	}
	
	@RequestMapping("codeGroupXdmInsert")
	public String codeGroupXdmInsert(CodeGroupDto dto) {
		
	System.out.println("dto.getUploadFiles()" + dto.getUploadFiles().length);
			
			for(MultipartFile a : dto.getUploadFiles()) {
			    System.out.println(a.getOriginalFilename());
			}
		
		service.insert(dto); 
		
		return "redirect:/codeGroupXdmList"; 
	}
	
	@RequestMapping("codeGroupXdmCorrection")
	public String codeGroupXdmCorrection(CodeGroupDto dto, Model model) {
		
		model.addAttribute("oneList", service.selectOne(dto));
		
		return "v1/infra/codeGroupXdm/codeGroupXdmCorrection";
		
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

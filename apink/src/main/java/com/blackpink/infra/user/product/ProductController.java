package com.blackpink.infra.user.product;

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
public class ProductController {

	@Autowired
	ProductService service;
	
	@RequestMapping(value = "/shopList")
	public String shopList(@ModelAttribute("vo") ProductVo vo, Model model) throws Exception {
		
		vo.setPdParamsPaging(service.selectPdOneCount(vo));
		
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", service.selectPdList(vo));
		}
		
		return "/v1/infra/user/shopList";
	}
	
	@RequestMapping(value = "/indexUser")
	public String indexUser(@ModelAttribute("vo") ProductVo vo, Model model) throws Exception {
		
		vo.setParamsPaging(service.selectPdOneCount(vo));
		
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", service.selectPdList(vo));
		}
		
		return "/v1/infra/user/indexUser";
	}
	
	@RequestMapping(value = "/productXdmList")
	public String productXdmList(@ModelAttribute("vo") ProductVo vo, Model model) throws Exception {
		
		setSearch(vo);
		
		vo.setParamsPaging(service.selectOneCount(vo));
		
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", service.selectList(vo));
		}
		
//		System.out.println("vo.getShDateStart(): " + vo.getShDateStart());
//		System.out.println("vo.getShDateEnd(): " + vo.getShDateEnd());
//		System.out.println("vo.getRowNumToShow()"+vo.getRowNumToShow());
//		
		return "/v1/infra/product/productXdmList";
		
	}
	
	@RequestMapping(value = "/productXdmAddition")
	public String productXdmAddition(ProductDto dto, Model model ) {
		
		model.addAttribute("oneList", service.selectOne(dto));
		
		return "/v1/infra/product/productXdmAddition";
	}
	
	@RequestMapping(value = "/productXdmInsert")
	public String productXdmInsert(ProductDto dto) {
		
		service.insert(dto);
		
		return "redirect:/productXdmList";
	}
	
	@RequestMapping(value = "/productXdmCorrection")
	public String productXdmCorrection(ProductDto dto, Model model) {
		
		model.addAttribute("oneList", service.selectOne(dto));
		
		return "/v1/infra/product/productXdmCorrection";
		
	}
	
	@RequestMapping(value = "shopDetailedPage")
	public String shopDetailedPage(ProductDto dto, Model model) {
		
		model.addAttribute("list", service.selectRvList(dto));
		
		model.addAttribute("item", service.item(dto));
		
		model.addAttribute("sizeList", service.selectSizeList(dto));
		
		model.addAttribute("colorList", service.selectColorList(dto));
		
		return "/v1/infra/user/shopDetailedPage";
	}
		
	@RequestMapping(value = "/productXdmUpdate")
	public String productXdmUpdate(ProductDto dto) {
		
		service.update(dto);
		
		return "redirect:/productXdmList";
		
	}
	
	@RequestMapping(value = "/productDeleteNy")
	public String productXdmDeleteNy(ProductDto dto) {
		
		service.updateDeleteNy(dto);
		
		return "redirect:/productXdmList";
		
	}
	
	@RequestMapping(value = "/productDelete")
	public String productXdmDelete(ProductDto dto) {
		
		service.delete(dto);
		
		return "redirect:/productXdmList";
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/reviewinsert")
	public Map<String, Object> reviewinsert(Model model, ProductDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		dto.setMbSeq((String)httpSession.getAttribute("sessMbSeqUser"));
		dto.setRvName((String)httpSession.getAttribute("sessNameUser"));
		System.out.println(dto.getPdSeq() + "1------------------------------------------");
		String str = dto.getMbSeq();
		if(str != null){
			System.out.println(dto.getPdSeq() + "2------------------------------------------");
			returnMap.put("rt", "success");
			service.insertRv(dto);
		}
		else{
			returnMap.put("rt", "false");
		}
		return returnMap;
	}
	
	public void setSearch(ProductVo vo) throws Exception {
		
		/* 초기값 세팅이 있는 경우 사용 */
		vo.setShDateStart(vo.getShDateStart() == null
		    ? UtilDateTime.calculateDayReplace00TimeString(UtilDateTime.nowLocalDateTime(), Constants.DATE_INTERVAL)
		    : UtilDateTime.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null
		    ? UtilDateTime.nowString()
		    : UtilDateTime.addNowTimeString(vo.getShDateEnd()));		
	}
		
}

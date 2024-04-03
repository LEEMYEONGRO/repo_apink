package com.blackpink.infra.user.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blackpink.common.constants.Constants;
import com.blackpink.common.util.UtilDateTime;

@Controller
public class ProductController {

	@Autowired
	ProductService service;
	
	@RequestMapping(value = "/shopListr")
	public String shopListr(@ModelAttribute("vo") ProductVo vo, Model model) throws Exception {
		
		vo.setParamsPaging(service.selectPdOneCount(vo));
		
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", service.selectPdList(vo));
		}
		
		return "/v1/infra/user/shopListr";
		
	}
	
	@RequestMapping(value = "/myPage")
	public String myPage(@ModelAttribute("vo") ProductVo vo, Model model) throws Exception {
		
		setSearch(vo);
				
		vo.setParamsPaging(service.selectOneCount(vo));
		
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", service.selectMyPage(vo));
		}
		
//		System.out.println("vo.getShDateStart(): " + vo.getShDateStart());
//		System.out.println("vo.getShDateEnd(): " + vo.getShDateEnd());
//		System.out.println("vo.getRowNumToShow()"+vo.getRowNumToShow());
//		
		return "/v1/infra/user/myPage";
		
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
		
		model.addAttribute("item", service.item(dto));
		
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
	
	
	public void setSearch(ProductVo vo) throws Exception {
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

package com.blackpink.infra.user.product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.blackpink.common.constants.Constants;
import com.blackpink.common.util.UtilDateTime;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProductController {

	@Autowired
	ProductService service;
	
	@RequestMapping(value = "/shopList")
	public String shopList(@ModelAttribute("vo") ProductVo vo, Model model) throws Exception {
		setSearch(vo);
		vo.setPdParamsPaging(service.selectPdOneCount(vo));
		
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", service.selectCategoryList(vo));
		}
		
//	    api
	    String apiUrl = "https://ecos.bok.or.kr/api/KeyStatisticList/sample/json/kr/2/5";
	    JsonNode node = callApiAndGetResponse(apiUrl);
	    model.addAttribute("node", node);
	    
		return "v1/infra/user/shopList";
	}
	
//	카테고리 리스트
	@RequestMapping(value = "/categoryselect")
	public String categoryselect(@ModelAttribute("vo") ProductVo vo,Model model, ProductDto dto) throws Exception {
		setSearch(vo);
		vo.setPdParamsPaging(service.selectPdOneCount(vo));
		
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", service.selectCategoryList(vo));
		}	
		
//	    api
	    String apiUrl = "https://ecos.bok.or.kr/api/KeyStatisticList/sample/json/kr/2/5";
	    JsonNode node = callApiAndGetResponse(apiUrl);
	    model.addAttribute("node", node);
		
	    return "v1/infra/user/shopListAjax";
	}
//	index화면 상품리스트
	@RequestMapping(value = "/indexUser")
	public String indexUser(@ModelAttribute("vo") ProductVo vo, Model model) throws Exception {
	    
	    vo.setParamsPaging(service.selectPdOneCount(vo));
	    
	    if (vo.getTotalRows() > 0) {
	        model.addAttribute("list", service.selectPdList(vo)); // pdView로 정렬된 상품 목록
	        model.addAttribute("newProducts", service.selectPdListOrderBySeq(vo)); // pdSeq로 정렬된 상품 목록
	    }
//	    api
	    String apiUrl = "https://ecos.bok.or.kr/api/KeyStatisticList/sample/json/kr/2/5";
	    JsonNode node = callApiAndGetResponse(apiUrl);
	    model.addAttribute("node", node);
	    
	    return "v1/infra/user/indexUser";
	}
//	조회수 증강
	@RequestMapping(value = "/viewUpdate")
	public String viewUpdate(ProductDto dto) {
		
		service.viewUpdate(dto);
		
		return "redirect:/shopDetailedPage";
		
	}
	
	@RequestMapping(value = "/productXdmList")
	public String productXdmList(@ModelAttribute("vo") ProductVo vo, Model model) throws Exception {
		
		setSearch(vo);
		
		vo.setParamsPaging(service.selectOneCount(vo));
		
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", service.selectList(vo));
		}

		return "v1/infra/product/productXdmList";
		
	}
	
	@RequestMapping(value = "/productXdmAddition")
	public String productXdmAddition(ProductDto dto, Model model ) {
		
		model.addAttribute("oneList", service.selectOne(dto));
		
		return "v1/infra/product/productXdmAddition";
	}
//	제품추가
	@RequestMapping(value = "/productXdmInsert")
	public String productXdmInsert(ProductDto dto) {
		
		service.insert(dto);
		
		return "redirect:/productXdmList";
	}
	
	@RequestMapping(value = "/productXdmCorrection")
	public String productXdmCorrection(ProductDto dto, Model model) {
		
		model.addAttribute("oneList", service.selectOne(dto));
		
		return "v1/infra/product/productXdmCorrection";
		
	}
//	상품 상세목록
	@RequestMapping(value = "shopDetailedPage")
	public String shopDetailedPage(ProductDto dto,@ModelAttribute("vo") ProductVo vo, Model model, RedirectAttributes redirectAttributes) throws Exception {
		
		setSearch(vo);
		
		model.addAttribute("list", service.selectRvList(dto));
		
		model.addAttribute("item", service.item(dto));
		
		model.addAttribute("sizeList", service.selectSizeList(dto));
		
		model.addAttribute("colorList", service.selectColorList(dto));
		
		model.addAttribute("ibuList", service.selectIbuList(dto));
		
		service.viewUpdate(dto);
		
		redirectAttributes.addFlashAttribute("vo", vo);
		
//	    api
	    String apiUrl = "https://ecos.bok.or.kr/api/KeyStatisticList/sample/json/kr/2/5";
	    JsonNode node = callApiAndGetResponse(apiUrl);
	    model.addAttribute("node", node);
	    
		return "v1/infra/user/shopDetailedPage";
	}
//		제품업데이트
	@RequestMapping(value = "/productXdmUpdate")
	public String productXdmUpdate(ProductDto dto) throws Exception {
		
		service.updateIbu(dto);
		
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
	
	private JsonNode callApiAndGetResponse(String apiUrl) throws IOException {
	    URL url = new URL(apiUrl);
	    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
	    httpURLConnection.setRequestMethod("GET");

	    BufferedReader bufferedReader;
	    if (httpURLConnection.getResponseCode() >= 200 && httpURLConnection.getResponseCode() <= 300) {
	        bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
	    } else {
	        bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
	    }

	    StringBuilder stringBuilder = new StringBuilder();
	    String line;
	    while ((line = bufferedReader.readLine()) != null) {
	        System.out.println("line: " + line);
	        stringBuilder.append(line);
	    }

	    bufferedReader.close();
	    httpURLConnection.disconnect();

	    ObjectMapper objectMapper = new ObjectMapper();
	    return objectMapper.readTree(stringBuilder.toString());
	}
}

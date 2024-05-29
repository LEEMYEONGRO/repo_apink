package com.blackpink.infra.codegroup;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.blackpink.common.constants.Constants;
import com.blackpink.common.util.UtilDateTime;

import jakarta.servlet.http.HttpServletResponse;

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
	
	@RequestMapping("excelDownload")
    public void excelDownload(CodeGroupVo vo, HttpServletResponse httpServletResponse) throws Exception {
		
		setSearch(vo); 
		
		vo.setParamsPaging(service.selectOneCount(vo));

		if (vo.getTotalRows() > 0) {
			List<CodeGroupDto> list = service.selectList(vo);
			
			Workbook workbook = new HSSFWorkbook();	// for xls
//	        Workbook workbook = new XSSFWorkbook();
	        Sheet sheet = workbook.createSheet("첫번째 시트");
	        CellStyle cellStyle = workbook.createCellStyle();        
	        Row row = null;
	        Cell cell = null;
	        int rowNum = 0;
			
//	        each column width setting
	        sheet.setColumnWidth(0, 4100);
	        sheet.setColumnWidth(1, 4100);
	        sheet.setColumnWidth(2, 5100);
	        sheet.setColumnWidth(3, 5100);
	        sheet.setColumnWidth(4, 2100);

//	        Header
	        String[] tableHeader = {"코드그룹 코드", "코드그룹 이름", "등록일", "수정일", "삭제여부"};

	        row = sheet.createRow(rowNum++);
			for(int i=0; i<tableHeader.length; i++) {
				cell = row.createCell(i);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
				cell.setCellValue(tableHeader[i]);
			}

//	        Body
	        for (int i=0; i<list.size(); i++) {
	            row = sheet.createRow(rowNum++);
	            
//	            String type: null 전달 되어도 ok
//	            int, date type: null 시 오류 발생 하므로 null check
//	            String type 이지만 정수형 데이터가 전체인 seq 의 경우 캐스팅
	            
	            cell = row.createCell(0);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	            cell.setCellValue(Integer.parseInt(list.get(i).getCgSeq()));
	            
	            cell = row.createCell(1);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	cell.setCellValue(list.get(i).getCgName());
	        	
	        	cell = row.createCell(2);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	if(list.get(i).getCgModificationDate() != null) cell.setCellValue(UtilDateTime.dateTimeToString(list.get(i).getCgModificationDate()));
	        	
	        	cell = row.createCell(3);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	if(list.get(i).getCgCreationDate() != null) cell.setCellValue(UtilDateTime.dateTimeToString(list.get(i).getCgCreationDate()));
     
	            cell = row.createCell(4);
	            cellStyle.setAlignment(HorizontalAlignment.CENTER);
	            cell.setCellStyle(cellStyle);
	            if(list.get(i).getCgDeleteNy() != null) cell.setCellValue(list.get(i).getCgDeleteNy() == 0 ? "N" : "Y");
	        }

	        httpServletResponse.setContentType("ms-vnd/excel");
	        httpServletResponse.setHeader("Content-Disposition", "attachment;filename=example.xls");	// for xls
//	        httpServletResponse.setHeader("Content-Disposition", "attachment;filename=example.xlsx");

	        workbook.write(httpServletResponse.getOutputStream());
	        workbook.close();
		}
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

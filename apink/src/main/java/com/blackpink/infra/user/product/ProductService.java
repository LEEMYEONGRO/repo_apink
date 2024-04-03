package com.blackpink.infra.user.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import jakarta.annotation.PostConstruct;

@Service
public class ProductService {

	@Autowired
	ProductDao dao;
	
	public List<ProductDto> selectList(ProductVo vo){
		return dao.selectList(vo);}
	
	public List<ProductDto> selectPdList(ProductVo vo){
		return dao.selectPdList(vo);
	}

	public List<ProductDto> selectMyPage(ProductVo vo){
		return dao.selectMyPage(vo);
	}
	
	public ProductDto selectOne(ProductDto dto) {
		return dao.selectOne(dto);
	}
	
	public int insert(ProductDto dto) {
		return dao.insert(dto);
	}
	
	public int update(ProductDto dto) {
		return dao.update(dto);
	}
	
	public int updateDeleteNy(ProductDto dto) {
		return dao.updateDeleteNy(dto);
	}
	
	public int delete(ProductDto dto) {
		return dao.delete(dto);
	}
	
	public List<ProductDto> selectListWithoutPaging() {
		return dao.selectListWithoutPaging();
	}
	
	public int selectOneCount(ProductVo vo) {
		return dao.selectOneCount(vo);
	}
	
	public int selectPdOneCount(ProductVo vo) {
		return dao.selectPdOneCount(vo);
	}
	
    @PostConstruct
	public void selectListCachedCodeArrayList() throws Exception {
		List<ProductDto> codeListFromDb = (ArrayList<ProductDto>) dao.selectListCachedCodeArrayList();
//		codeListFromDb = (ArrayList<Code>) dao.selectListCachedCodeArrayList();
		ProductDto.cachedCodeArrayList.clear(); 
		ProductDto.cachedCodeArrayList.addAll(codeListFromDb);
		System.out.println("cachedCodeArrayList: " + ProductDto.cachedCodeArrayList.size() + " chached !");
	}
    
    public static String selectOneCachedCode(int Product) throws Exception {
		String rt = "";
		for(ProductDto ProductRow : ProductDto.cachedCodeArrayList) {
			if (ProductRow.getPdSeq().equals(Integer.toString(Product))) {
				rt = ProductRow.getPdName();
			} else {
				// by pass
			}
		}
		return rt;
	}
    
    public static List<ProductDto> selectListCachedCode(String seq) throws Exception {
		List<ProductDto> rt = new ArrayList<ProductDto>();
		for(ProductDto ProductRow : ProductDto.cachedCodeArrayList) {
			if (ProductRow.getPdSeq().equals(seq)) {
				rt.add(ProductRow);
			} else {
				// by pass
			}
		}
		return rt;
	}
}

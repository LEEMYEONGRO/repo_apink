package com.blackpink.infra.user.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	ProductDao dao;
	
	public List<ProductDto> selectList(ProductVo vo){
		return dao.selectList(vo);}
//	인덱스화면 상품리스트
	public List<ProductDto> selectPdList(ProductVo vo){
		return dao.selectPdList(vo);
	}
    
    public List<ProductDto> selectPdListOrderBySeq(ProductVo vo) {
        return dao.selectPdListOrderBySeq(vo);
    }
//	인덱스화면 상품리스트
//	카테고리 리스트
	public List<ProductDto> selectCategoryList(ProductVo vo){
		return dao.selectCategoryList(vo);
	}

	public List<ProductDto> selectMyPage(ProductVo vo){
		return dao.selectMyPage(vo);
	}
	
	public List<ProductDto> selectRvList(ProductDto dto) {
		return dao.selectRvList(dto);
	}
	
	public ProductDto selectOne(ProductDto dto) {
		return dao.selectOne(dto);
	}
	
	public ProductDto item(ProductDto dto) {
		return dao.item(dto);
	}
	
	public List<ProductDto> selectSizeList(ProductDto dto) {
		return dao.selectSizeList(dto);
	}
	
	public List<ProductDto> selectColorList(ProductDto dto) {
		return dao.selectColorList(dto);
	}
	
	public int insert(ProductDto dto) {
		return dao.insert(dto);
	}
	
	public int update(ProductDto dto) {
		return dao.update(dto);
	}
	
	public int insertRv(ProductDto dto) {
		return dao.insertRv(dto);
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
	
	public int selectRvOneCount(ProductVo vo) {
		return dao.selectRvOneCount(vo);
	}
	
	public int viewUpdate(ProductDto dto) {
		return dao.viewUpdate(dto);
	}
	
}

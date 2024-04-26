package com.blackpink.infra.user.product;

import java.util.List;

public interface ProductDao {

	public List<ProductDto> selectList(ProductVo vo);
	
	public List<ProductDto> selectPdList(ProductVo vo);
	
	public List<ProductDto> selectMyPage(ProductVo vo);
	
	public List<ProductDto> selectRvList(ProductDto dto);
	
	public ProductDto selectOne(ProductDto dto);

	public ProductDto item(ProductDto dto);
	
	public List<ProductDto> selectSizeList(ProductDto dto);
	
	public List<ProductDto> selectColorList(ProductDto dto);
	
	public int insert(ProductDto dto);
	
	public int insertRv(ProductDto dto);
	
	public int update(ProductDto dto);
	
	public int updateDeleteNy(ProductDto dto);
	
	public int delete(ProductDto dto);
	
	public List<ProductDto> selectListWithoutPaging();
	
	public int selectOneCount(ProductVo vo);
	
	public int selectPdOneCount(ProductVo vo);

	public int selectRvOneCount(ProductVo vo);
}

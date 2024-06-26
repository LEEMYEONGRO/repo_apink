package com.blackpink.infra.user.product;

import java.util.List;

public interface ProductDao {

	public List<ProductDto> selectList(ProductVo vo);
	
	public List<ProductDto> selectPdList(ProductVo vo);
//	카테고리 리스트
	public List<ProductDto> selectCategoryList(ProductVo vo);
//	마이페이지
	public List<ProductDto> selectMyPage(ProductVo vo);
//	리뷰 리스트
	public List<ProductDto> selectRvList(ProductDto dto);
//	상품상세 이미지리스트
	public List<ProductDto> selectIbuList(ProductDto dto);
	
	public ProductDto selectOne(ProductDto dto);

	public ProductDto item(ProductDto dto);
	
	public List<ProductDto> selectSizeList(ProductDto dto);
	
	public List<ProductDto> selectColorList(ProductDto dto);
	
	public int insert(ProductDto dto);
	
	public int insertRv(ProductDto dto);
//	제품업데이트
	public int update(ProductDto dto);
//	이미지 업로드
	public int updateIbu(ProductDto dto);
	
	public int updateDeleteNy(ProductDto dto);
	
	public int delete(ProductDto dto);
	
	public List<ProductDto> selectListWithoutPaging();
	
	public int selectOneCount(ProductVo vo);
	
	public int selectPdOneCount(ProductVo vo);

	public int selectRvOneCount(ProductVo vo);

	public int viewUpdate(ProductDto dto);
	
    public List<ProductDto> selectPdListOrderBySeq(ProductVo vo);
    
    public int insertIbu(ProductDto dto);

}

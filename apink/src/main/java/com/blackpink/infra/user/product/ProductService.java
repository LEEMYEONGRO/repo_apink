package com.blackpink.infra.user.product;

import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;

@Service
public class ProductService {

	@Autowired
	AmazonS3Client amazonS3Client;
	
	@Value("${cloud.aws.s3.bucket}") private String bucket;
	
	@Autowired
	ProductDao dao;
	
	public List<ProductDto> selectList(ProductVo vo){
		return dao.selectList(vo);}
//	인덱스화면 상품리스트
	public List<ProductDto> selectPdList(ProductVo vo){
		return dao.selectPdList(vo);
	}
//	인덱스화면 상품리스트    
    public List<ProductDto> selectPdListOrderBySeq(ProductVo vo) {
        return dao.selectPdListOrderBySeq(vo);
    }

//	카테고리 리스트
	public List<ProductDto> selectCategoryList(ProductVo vo){
		return dao.selectCategoryList(vo);
	}

	public List<ProductDto> selectMyPage(ProductVo vo){
		return dao.selectMyPage(vo);
	}
//	리뷰 리스트
	public List<ProductDto> selectRvList(ProductDto dto) {
		return dao.selectRvList(dto);
	}
//	상품상세 이미지리스트
	public List<ProductDto> selectIbuList(ProductDto dto) {
		return dao.selectIbuList(dto);
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
//	제품 업데이트
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
	
	public int updateIbu(ProductDto dto) throws Exception
	{
		dao.update(dto);
		for(MultipartFile multipartFile : dto.getUploadFiles()) {
			
			if(!multipartFile.isEmpty()) {
				//System.out.println("multipartFile.getOriginalFilename() : " + multipartFile.getOriginalFilename());
				
		        ObjectMetadata metadata = new ObjectMetadata();
		        metadata.setContentLength(multipartFile.getSize());
		        metadata.setContentType(multipartFile.getContentType());
		        
		        
		        amazonS3Client.putObject(bucket, multipartFile.getOriginalFilename(), multipartFile.getInputStream(), metadata);
				
		        String objectUrl = amazonS3Client.getUrl(bucket, multipartFile.getOriginalFilename()).toString();
		        
		        String uuid = UUID.randomUUID().toString();
		        
		        String exit = FilenameUtils.getExtension(multipartFile.getOriginalFilename());

		        dto.setIbuPath(objectUrl);;
		        dto.setIbuOriginalName(FilenameUtils.getBaseName(multipartFile.getOriginalFilename()));
		        dto.setIbuUuidName(uuid);
		        dto.setIbuSize((int) multipartFile.getSize());
		        dto.setIbuExt(exit);
		        
		        System.out.println(dto.getIbuPath());
		        System.out.println(dto.getIbuOriginalName());
		        System.out.println(dto.getIbuUuidName());
		        System.out.println(dto.getIbuSize());
		        System.out.println(dto.getIbuExt());
		        System.out.println(dto.getPdSeq());
		        
		        dao.insertIbu(dto);
			}
		}
		return 1;
	}
	
}

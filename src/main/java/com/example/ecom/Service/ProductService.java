package com.example.ecom.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecom.Dto.CategoryDto;
import com.example.ecom.Dto.ProductDto;
import com.example.ecom.Exception.ResourceNotFoundException;
import com.example.ecom.Model.Category;
import com.example.ecom.Model.Product;
import com.example.ecom.Repository.CategoryRepository;
import com.example.ecom.Repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private CategoryRepository catRepo;
	
	public ProductDto createProduct( ProductDto productDto, int catId) {
//		//ProductDto to Product
//		Product entity = convertDtoToEntity(product);
//		Product save = productRepo.save(entity);
//
//		// Product to ProductDto
//		ProductDto dto = convertEntityToDto(save);
//		return dto;
		
		//////////////////////////////////////////////////
		
		//Fetch Category, available or not
		Category catbyId = this.catRepo.findById(catId).orElseThrow(()->new ResourceNotFoundException("This Category = "+ catId +" Id not found"));
		
		// ProductDto to Product
		Product proEntity = convertDtoToEntity(productDto);
		
		// Saving the category
		proEntity.setCategory(catbyId);
		
		// save the product in DB
		Product save = this.productRepo.save(proEntity);
		
		//Product to ProductDto
		ProductDto dto = convertEntityToDto(save);
		return dto;
	}
	
	public List<ProductDto> viewAll(){	
		List<Product> findAll = productRepo.findAll();
		List<ProductDto> findAllDto = findAll.stream().map(product ->this.convertEntityToDto(product)).collect(Collectors.toList());
		return findAllDto;
	}
	
	public ProductDto viewProductById(int pid) {
		Product findById =  productRepo.findById(pid).orElseThrow(()->new ResourceNotFoundException("Product with id = " + pid + " , Not found for Viewing"));
		ProductDto proDto =  this.convertEntityToDto(findById);
		return proDto;
	}
	
	public void deleteProductById(int pid) {
	    if (!productRepo.existsById(pid)) {
	        throw new ResourceNotFoundException("Product with id = " + pid + " , Not found for Deletion");
	    }
	    // If product exists,delete it
	    productRepo.deleteById(pid);	
	}
	
	public ProductDto updateProductById(int pid, ProductDto newProduct) {
		Product oldProduct =  productRepo.findById(pid).orElseThrow(()->new ResourceNotFoundException("Product with id = " + pid + " , Not found for Update"));
		
		oldProduct.setProduct_name(newProduct.getProduct_name());
		oldProduct.setProduct_price(newProduct.getProduct_price());
		oldProduct.setProduct_quantity(newProduct.getProduct_quantity());
		oldProduct.setProduct_imageName(newProduct.getProduct_imageName());
		oldProduct.setProduct_desc(newProduct.getProduct_desc());
		
		Product save =  productRepo.save(oldProduct);
		
		ProductDto proDto = convertEntityToDto(save);
		 
		return proDto;
	}
	
	
	// JpaEntity to DtoEntity
//	public ProductDto convertEntityToDto(Product proEntity){
//		
//		ProductDto productDto = new ProductDto();
//		productDto.setProduct_id(proEntity.getProduct_id());
//		productDto.setProduct_name(proEntity.getProduct_name());
//		productDto.setProduct_price(proEntity.getProduct_price());
//		productDto.setProduct_quantity(proEntity.getProduct_quantity());
//		productDto.setProduct_imageName(proEntity.getProduct_imageName());
//		productDto.setProduct_desc(proEntity.getProduct_desc());
////		return productDto;
//		
//		//changing Category to CategoryDto
//		CategoryDto catDto = new CategoryDto();
//		catDto.setCategoryId(proEntity.getCategory().getCategoryId());
//		catDto.setCategoryName(proEntity.getCategory().getCategoryName());
//		
//		// setting Category Dto in product Dto
//		productDto.setCategory(catDto);
//		
//		return productDto;
//		
//	}
	
	public ProductDto convertEntityToDto(Product proEntity) {
	    if (proEntity == null) {
	        return null; // Handle null Product entity
	    }

	    ProductDto productDto = new ProductDto();
	    productDto.setProduct_id(proEntity.getProduct_id());
	    productDto.setProduct_name(proEntity.getProduct_name());
	    productDto.setProduct_price(proEntity.getProduct_price());
	    productDto.setProduct_quantity(proEntity.getProduct_quantity());
	    productDto.setProduct_imageName(proEntity.getProduct_imageName());
	    productDto.setProduct_desc(proEntity.getProduct_desc());

	    // Check if the category exists before accessing its fields
	    if (proEntity.getCategory() != null) {
	        CategoryDto catDto = new CategoryDto();
	        catDto.setCategoryId(proEntity.getCategory().getCategoryId());
	        catDto.setCategoryName(proEntity.getCategory().getCategoryName());
	        productDto.setCategory(catDto);
	    } else {
	        productDto.setCategory(null); // Explicitly set category to null if not present
	    }

	    return productDto;
	}
	
	//Dto to Entity
	public Product convertDtoToEntity(ProductDto proDto){
		Product product = new Product();
		product.setProduct_id(proDto.getProduct_id());
		product.setProduct_name(proDto.getProduct_name());
		product.setProduct_price(proDto.getProduct_price());
		product.setProduct_quantity(proDto.getProduct_quantity());
		product.setProduct_imageName(proDto.getProduct_imageName());
		product.setProduct_desc(proDto.getProduct_desc());
		return product;
	}
}

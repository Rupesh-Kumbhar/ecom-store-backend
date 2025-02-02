package com.example.ecom.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecom.Dto.CategoryDto;
import com.example.ecom.Exception.ResourceNotFoundException;
import com.example.ecom.Repository.CategoryRepository;
import com.example.ecom.Model.Category;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository catRepo;
	@Autowired
	private ModelMapper mapper;
	
	public CategoryDto createCategory(CategoryDto catDto) {
		//CatDto to CatEntity
		Category cat = this.mapper.map(catDto, Category.class); 
		Category save = this.catRepo.save(cat);
		
		// Save returning Entity
		
		//CatEntity to Dto
		CategoryDto saveDto = this.mapper.map(save,CategoryDto.class);
		return saveDto; 
	}
	
	public CategoryDto updateCategory(CategoryDto newCat, int catId) {
		Category oldCat = this.catRepo.findById(catId).orElseThrow(()-> new ResourceNotFoundException("This Category Id = " + catId +" not found") );
//		oldCat.setCategoryId(newCat.getCategoryId());
		oldCat.setCategoryName(newCat.getCategoryName());
		Category save = this.catRepo.save(oldCat);
		return this.mapper.map(save, CategoryDto.class);
	} 
	
	public void deleteCategoryById(int catId){
		Category cat = this.catRepo.findById(catId).orElseThrow(()-> new ResourceNotFoundException("Category = "+ catId +" not found for deletion"));
		this.catRepo.delete(cat);
	}
	
	public CategoryDto viewCategoryById(int catId){
		Category viewCatId = this.catRepo.findById(catId).orElseThrow(()-> new ResourceNotFoundException("Category = "+ catId +" not found for Viewing"));
		return this.mapper.map(viewCatId, CategoryDto.class);
	}
	
	public List<CategoryDto> viewCategoryAll(){
		List<Category> catAll = this.catRepo.findAll();
		List<CategoryDto> catAllDto =  catAll.stream().map(cat ->this.mapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		return catAllDto;
	}
	
	public CategoryDto searchCategoryByName(String categoryName) {
        Category category = catRepo.findByCategoryName(categoryName)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with name: " + categoryName));
        return mapper.map(category, CategoryDto.class);
    }
}

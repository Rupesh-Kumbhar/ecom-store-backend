package com.example.ecom.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecom.Dto.ApiResponse;
import com.example.ecom.Dto.CategoryDto;
import com.example.ecom.Service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService catService;
//	private CategoryDto createCat;
	
	//Create
	@PostMapping("/create-category")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto catDto ){
		CategoryDto createCatDto = this.catService.createCategory(catDto);
		return new ResponseEntity<CategoryDto>(createCatDto,HttpStatus.ACCEPTED) ;
	}
	
	//Update
	@PostMapping("/update/{catId}")
	private ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto catDto, @PathVariable int catId) {
		CategoryDto updateCatDto = this.catService.updateCategory(catDto,catId);
		return new ResponseEntity<CategoryDto>(updateCatDto,HttpStatus.OK);
	}
	
	//Delete
	@DeleteMapping("/delete/{catId}")
	public ResponseEntity<ApiResponse>  deleteById(@PathVariable int catId) {
		this.catService.deleteCategoryById(catId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category deleted successfully",true),HttpStatus.OK);
	}
	
	//viewCatId
	@GetMapping("/viewById/{catId}")
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable int catId){
		CategoryDto getCategoryById = this.catService.viewCategoryById(catId);
		return new ResponseEntity<CategoryDto>(getCategoryById,HttpStatus.OK);
	}
	
	//viewAll
	@GetMapping("/viewAll")
	public ResponseEntity<List<CategoryDto>> getAllCategories() {
		List<CategoryDto> getAllCategoriesList =  this.catService.viewCategoryAll();
		return new ResponseEntity<List<CategoryDto>>(getAllCategoriesList,HttpStatus.OK);
	}
	
	// Search by name
    @GetMapping("/search/{name}")
    public ResponseEntity<CategoryDto> searchCategoryByName(@PathVariable String name) {
        CategoryDto categoryDto = this.catService.searchCategoryByName(name);
        return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.OK);
    }
	
}

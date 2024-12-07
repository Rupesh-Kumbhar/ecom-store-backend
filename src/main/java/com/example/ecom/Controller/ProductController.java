package com.example.ecom.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecom.Dto.ProductDto;
import com.example.ecom.Model.Product;
import com.example.ecom.Service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/create/{catId}")
	@ResponseBody
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto, @PathVariable int catId) {
//		System.out.println("Product controller");
//		System.out.println(productService);
		
		ProductDto createProduct =  productService.createProduct(productDto,catId);
		//System.out.println("Received DTO: " + productDto);	Just loggin for weather the productDto is getting used or not
		return new ResponseEntity<ProductDto>(createProduct,HttpStatus.CREATED);

	}
	
	//viewAll
	@GetMapping("/viewAll")
	public ResponseEntity<List<ProductDto>> viewAllProduct(){
		List<ProductDto> viewAll = productService.viewAll();
//		System.out.println("Received viewAll DTO" + viewAll );
		return new ResponseEntity<List<ProductDto>> (viewAll,HttpStatus.ACCEPTED);
	}
	
	//viewProductById
	@GetMapping("/view/{productId}")
	public ResponseEntity<ProductDto> viewProductById(@PathVariable int productId ) {
		ProductDto viewProductById =  productService.viewProductById(productId);
		System.out.println("Received view pro id" + viewProductById );
		return new ResponseEntity<ProductDto>(viewProductById,HttpStatus.OK);
	}
	
	//deleteProductById
	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<String> deleteProductById(@PathVariable int productId) {
//		System.out.println(productId); 
		productService.deleteProductById(productId);
		return new ResponseEntity<String>("Product Deleted",HttpStatus.OK);
	}
	
	//updateProductById
	@PutMapping("/update/{productId}")
	public ResponseEntity<ProductDto> updateProductById(@PathVariable int productId, @RequestBody ProductDto newProduct ) {
		ProductDto updateProduct =  productService.updateProductById(productId, newProduct);
		System.out.println("Received Update pro id "+updateProduct);
		return new ResponseEntity<ProductDto>(updateProduct,HttpStatus.ACCEPTED);
	}
	
	
}

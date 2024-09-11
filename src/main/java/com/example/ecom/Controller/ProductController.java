package com.example.ecom.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecom.Model.Product;
import com.example.ecom.Service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/create")
	@ResponseBody
	public Product createProduct(@RequestBody Product product) {
//		System.out.println("Product controller");
//		System.out.println(productService);
		
		Product createProduct =  productService.createProduct(product);
		return createProduct;
	}
	
	//viewAll
	@GetMapping("/viewAll")
	public List<Product> viewAllProduct(){
		List<Product> viewAll = productService.viewAll();
		return viewAll;
	}
	
	//viewProductById
	@GetMapping("/view/{productId}")
	public Product viewProductById(@PathVariable int productId ) {
		Product viewProductById =  productService.viewProductById(productId);
		return viewProductById;
	}
	
	//deleteProductById
	@GetMapping("/delete/{productId}")
	public void deleteProductById(@PathVariable int productId) {
//		System.out.println(productId); 
		productService.deleteProductById(productId);
	}
	
	//updateProductById
	@PutMapping("/update/{productId}")
	public Product updateProductById(@PathVariable int productId, @RequestBody Product newProduct ) {
		Product updateProduct =  productService.updateProductById(productId, newProduct);
		return updateProduct;
	}
	
	
}

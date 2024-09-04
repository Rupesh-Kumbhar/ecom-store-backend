package com.example.ecom.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
}

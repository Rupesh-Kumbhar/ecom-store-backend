package com.example.ecom.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecom.Model.Product;
import com.example.ecom.Repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	public Product createProduct( Product product) {
		Product save = productRepo.save(product);
		return save;
	}
}

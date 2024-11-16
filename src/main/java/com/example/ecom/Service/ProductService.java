package com.example.ecom.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecom.Exception.ResourceNotFoundException;
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
	
	public List<Product> viewAll(){	
		List<Product> findAll = productRepo.findAll();
		return findAll;
	}
	
	public Product viewProductById(int pid) {
		Product findById =  productRepo.findById(pid).orElseThrow(()->new ResourceNotFoundException("Product with id = " + pid + " , Not found for Viewing"));
		return findById;
	}
	
	public void deleteProductById(int pid) {
	    if (!productRepo.existsById(pid)) {
	        throw new ResourceNotFoundException("Product with id = " + pid + " , Not found for Deletion");
	    }
	    // If product exists,delete it
	    productRepo.deleteById(pid);	
	}
	
	public Product updateProductById(int pid, Product newProduct) {
		Product oldProduct =  productRepo.findById(pid).orElseThrow(()->new ResourceNotFoundException("Product with id = " + pid + " , Not found for Update"));
		
		oldProduct.setProduct_name(newProduct.getProduct_name());
		oldProduct.setProduct_price(newProduct.getProduct_price());
		oldProduct.setProduct_quantity(newProduct.getProduct_quantity());
		oldProduct.setProduct_imageName(newProduct.getProduct_imageName());
		oldProduct.setProduct_desc(newProduct.getProduct_desc());
		
		Product save =  productRepo.save(oldProduct);
		
		return save;
	}
}

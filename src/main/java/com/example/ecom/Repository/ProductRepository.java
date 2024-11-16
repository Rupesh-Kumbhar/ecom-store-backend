package com.example.ecom.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecom.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
//	public Product findById(int product);
}

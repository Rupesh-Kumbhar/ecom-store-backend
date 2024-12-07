package com.example.ecom.Model;

import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int categoryId;
	private String categoryName;
	
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY,cascade =CascadeType.ALL )
	private Set <Product> product;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public Set <Product> getProduct(Set<Product> product) {
		return product ;
	}
	
	public void setProduct(Set <Product> product) {
		this.product=product;
	}
}

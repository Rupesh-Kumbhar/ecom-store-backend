package com.example.ecom.Dto;


public class CategoryDto {
	
	private int categoryId;
	private String categoryName;
	
	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoryDto(int categoryId, String categoryName) {
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
}

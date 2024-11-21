package com.example.ecom.Dto;

public class ProductDto {
	private int product_id;
	
	private String product_name;
	
	private double product_price;
	
	private int product_quantity;
	
	private String product_imageName;
	
	private String product_desc;

	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDto(int product_id, String product_name, double product_price, int product_quantity,
			String product_imageName, String product_desc) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_quantity = product_quantity;
		this.product_imageName = product_imageName;
		this.product_desc = product_desc;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getProduct_price() {
		return product_price;
	}

	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}

	public int getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}

	public String getProduct_imageName() {
		return product_imageName;
	}

	public void setProduct_imageName(String product_imageName) {
		this.product_imageName = product_imageName;
	}

	public String getProduct_desc() {
		return product_desc;
	}

	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}
	
}

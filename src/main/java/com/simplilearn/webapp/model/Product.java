package com.simplilearn.webapp.model;

import java.util.Date;

public class Product {

	// properties
	private int id;
	private String name;
	private double price;
	private String desc;
	private Date createdAt;
	private Date modifiedAt;
	
	// constructor
	public Product() {}
	
	public Product(int id) {
		this.id = id;
	}
	
	public Product(String name, double price, String desc) {
		super();
		this.name = name;
		this.price = price;
		this.desc = desc;
		this.createdAt =  new Date();
		this.modifiedAt = new Date();
	}

	public Product(int id, String name, double price, String desc) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.desc = desc;
		this.createdAt =  new Date();
		this.modifiedAt = new Date();
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", desc=" + desc + ", createdAt="
				+ createdAt + ", modifiedAt=" + modifiedAt + "]";
	}

}

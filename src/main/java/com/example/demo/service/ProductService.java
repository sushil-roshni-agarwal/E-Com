package com.example.demo.service;

import java.util.List;

import com.example.demo.exceptions.InvalidProductIdException;
import com.example.demo.exceptions.InvalidProductNameException;
import com.example.demo.exceptions.InvalidProductTypeException;
import com.example.demo.model.Product;

public interface ProductService {

	public Product saveProduct(Product product);
	public List<Product> getAllProducts();
//
	public Product findOneProduct(int productid) throws InvalidProductIdException;

	public List<Product> getProductsByType(String productType);

	public List<String> getDistinctProduct();

	public List<Product> getAllProductsByType();

	public List<Product> getAllProductsByPrice();
	public List<Product>findByproductType(String productType) throws InvalidProductTypeException;
	
	public List<Product>findByproductName(String productName) throws InvalidProductNameException;
}

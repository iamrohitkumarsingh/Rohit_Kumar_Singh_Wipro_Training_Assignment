package com.wipro.jdbc.service;

import java.sql.SQLException;
import java.util.List;

import com.wipro.jdbc.model.Product;

public interface ProductService {
	void insertProduct(Product product)throws SQLException,ClassNotFoundException;
	void deleteProduct(Integer id)throws SQLException,ClassNotFoundException;
	List<Product>getAllProducts()throws SQLException,ClassNotFoundException;
	Product getProduct(Integer id)throws SQLException,ClassNotFoundException;

}

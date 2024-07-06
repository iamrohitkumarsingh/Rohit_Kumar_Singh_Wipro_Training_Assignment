package com.wipro.jdbc.client;

import com.wipro.jdbc.util.*;
import com.wipro.jdbc.model.*;
import com.wipro.jdbc.service.ProductService;
import com.wipro.jdbc.service.ProductServiceImp;

import java.sql.*;

public class ProductClient {

	public static void main(String[] args) throws SQLException , ClassNotFoundException{
		// TODO Auto-generated method stub
		ProductService p = new ProductServiceImp();
		
		p.insertProduct(new Product(1,"Laptop",40000));
		p.insertProduct(new Product(2,"mac",500000));
		p.insertProduct(new Product(3,"Phone",20000));
     	p.insertProduct(new Product(4,"Pendrive",1500));
		p.insertProduct(new Product(5,"Airdopes",2000));

		
		p.deleteProduct(4);
		p.getAllProducts().forEach(System.out::println);
		
		Product product = p.getProduct(5);
		System.out.println(product);

		

	}

}

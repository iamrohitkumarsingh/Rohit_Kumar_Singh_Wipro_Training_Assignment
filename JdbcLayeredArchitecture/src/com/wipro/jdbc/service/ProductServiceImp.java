package com.wipro.jdbc.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wipro.jdbc.model.Product;
import com.wipro.jdbc.util.DbConn;

public class ProductServiceImp implements ProductService{
	
	public void insertProduct(Product product) throws SQLException,ClassNotFoundException{
		PreparedStatement pst = DbConn.getConnection().prepareStatement("Insert into product Values(?,?,?)");
		pst.setInt(1, product.getId());
		pst.setString(2, product.getName());
		pst.setInt(3, product.getPrice());
        pst.execute();
        System.out.println("Product inserted");
		}
	
	public void deleteProduct(Integer id) throws SQLException,ClassNotFoundException{
		PreparedStatement pst = DbConn.getConnection().prepareStatement("Delete from product where id = ?");
		pst.setInt(1,id);
		pst.execute();
		System.out.println("Product Deletd");
	}
	
	public  List<Product> getAllProducts() throws SQLException,ClassNotFoundException{
		Statement st = DbConn.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = st.executeQuery("Select * from product");
		List<Product> productList = new ArrayList<>();
		while(rs.next()) {
			Product product = new Product();
			product.setId(rs.getInt(1));
			product.setName(rs.getString(2));
			product.setPrice(rs.getInt(3));
			productList.add(product);
		}
        return productList;
		}
	
	public  Product getProduct(Integer id) throws SQLException,ClassNotFoundException{
		
		PreparedStatement pst = DbConn.getConnection().prepareStatement("Select * from product where id =?");
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		Product product = new Product();

		while(rs.next()) {
			product.setId(rs.getInt(1));
			product.setName(rs.getString(2));
			product.setPrice(rs.getInt(3));
		}
        return product;
		}
}

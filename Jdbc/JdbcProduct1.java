package com.wipro.io;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcProduct1 {
	
	private Connection connection;
	public JdbcProduct1(Connection connection) {
		this.connection=connection;
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:9501/XE", "system", "rps@123");
			System.out.println("connection successfull");
			
			JdbcProduct1 pr=new JdbcProduct1(con);
			
			pr.createProductTable();
			
			pr.addProduct(101,"phone",10000);
			pr.updateProduct(101,"iphone",90000);
			pr.addProduct(102,"Bag",1000);
			pr.addProduct(103,"Laptop",50000);
			pr.addProduct(104, "Books", 200);
			pr.deleteProduct(1);
			pr.listProduct();
			con.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

	public void createProductTable() {
		// TODO Auto-generated method stub
		try (Statement statement=connection.createStatement()){
			String sql="CREATE TABLE Product("+
					"id NUMBER PRIMARY KEY,"+
					"name VARCHAR(20),"+
					"price NUMBER)";
			statement.executeUpdate(sql);
			System.out.println("Product table created");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void addProduct(int id,String name, int price)throws SQLException{

		try(PreparedStatement pst=connection.prepareStatement("Insert into Product(id,name,price)values(?,?,?)")){
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setInt(3, price);
			pst.executeUpdate();
			System.out.println("Product Added");
		}
	}

	public void updateProduct(int id, String name, int price) throws SQLException {
		// TODO Auto-generated method stub
		try(PreparedStatement pst=connection.prepareStatement("Update product set name=?,price=? where id=?")){
			pst.setString(1, name);
			pst.setInt(2, price);
			pst.setInt(3, id);
			pst.executeUpdate();
			System.out.println("product Updated");
		}
		
	}
	
	private void deleteProduct(int id) throws SQLException {
		// TODO Auto-generated method stub
		try(PreparedStatement pst=connection.prepareStatement("Delete from product where id=?")){
			pst.setInt(1, id);
			pst.executeUpdate();
			System.out.println("product deleted");
		}
		
	}
	
	private void listProduct() throws SQLException {
		// TODO Auto-generated method stub
		try(Statement statement = connection.createStatement();
				ResultSet resultset=statement.executeQuery("Select * from Product")){
			while(resultset.next()) {
				System.out.println(resultset.getInt("id")+"|"+resultset.getString("name")+"|"+resultset.getInt("price"));
			}
		}
		
	}
}

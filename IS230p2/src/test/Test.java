package test;

import java.sql.*;
public class Test {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection connection = null;
		String url = "jdbc:mariadb://localhost:3306/PROJECT";
		String user = "root";
		String pwd = "";
		
		try {
			connection = DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Successfully connected to database");
		
		
		try {
			Statement stmt = connection.createStatement();
			int productID = 123;
			String name = "Ahmad";
			int price = 236;
			int sales = 1000;

			String sql = "INSERT INTO PRODUCTS VALUES("+productID+",'"+name+"',"+price+",'"+sales+"')";
			stmt.executeUpdate(sql);
			
			ResultSet rs = null;
			
			rs = stmt.executeQuery("SELECT * FROM PRODUCTS ");
			while(rs.next()) {
				System.out.print(rs.getInt("productID") + "\t");
				System.out.print(rs.getString("name") + "\t");
				System.out.print(rs.getInt("price") + "\t");
				System.out.print(rs.getInt("sales") + "\t");
				System.out.println();
			}
						
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}








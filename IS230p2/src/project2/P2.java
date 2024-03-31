package project2;

import java.sql.*;
import java.util.Scanner;

public class P2 {
	public static void main(String args[]) {
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
		while (true) {
			System.out.println("Successfully connected to database");
			Scanner input = new Scanner(System.in);
			System.out.println("welcome to our programm");
			System.out.println("choose an option");
			System.out.println("1.insert new product");
			System.out.println("2.display all the products");
			System.out.println("3.change price ");
			System.out.println("4.exit");
			System.out.print("your choice :");

			int choice;
			try {
				choice = input.nextInt();
			} catch (Exception e) {
				choice = 5;
			}
			Statement stmt=null;
			try {
				stmt = connection.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			switch (choice) {
			case 1:
				try {
					boolean loop = true;
					while (loop) {
						
						System.out.print("enter productId :");
						int productID = input.nextInt();
						System.out.println();
						System.out.print("enter product name :");
						String name = input.next();
						System.out.println();
						System.out.print("enter product price :");
						int price = input.nextInt();
						System.out.println();
						System.out.print("enter product sales");
						int sales = input.nextInt();

						String sql = "INSERT INTO PRODUCTS VALUES(" + productID + ",'" + name + "'," + price + ",'"
								+ sales + "')";

						stmt.executeUpdate(sql);
						System.out.println();
						System.out.print("want to insert another prodect (y/n) :");
						String another = input.next();
						if (another.equals("y"))
							;
						else if (another.equals("n"))
							loop = false;
						else
							System.out.println("wong input try again");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;
			case 2:
				try {
					ResultSet rs = null;

					rs = stmt.executeQuery("SELECT * FROM PRODUCTS ");
					while (rs.next()) {
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

				break;
			case 3:
				break;
			case 4:
				System.out.println("thank you ");
				input.close();
				System.exit(0);
				break;
			default:
				System.out.println("something went wrong");
				break;
			}
		}

	}
}
